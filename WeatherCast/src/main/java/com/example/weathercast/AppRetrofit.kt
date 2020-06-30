package com.example.weathercast

import com.example.weathercast.Interfaces.ApiServices
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * retrofit class
 *
 * @property cacheDir
 * @property isConnected
 */
class AppRetrofit(private val cacheDir: File, private val isConnected: Boolean) {
    private val PARENT_URL = "https://api.openweathermap.org/"
    private val HEADER_CACHE_CONTROL = "Cache-Control"
    private val HEADER_PRAGMA = "Pragma"

    private var apiServices: ApiServices? = null

    /**
     * initialise okhttp client and retrofit
     */
    init {
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(provideOfflineCacheInterceptor())
            .addNetworkInterceptor(provideCacheInterceptor())
            .cache(provideCache())
            .build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(PARENT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        apiServices = retrofit.create(ApiServices::class.java)
    }

    /**
     * get api Services
     *
     * @return
     */
    fun getService(): ApiServices? {
        return apiServices
    }

    /**
     * malloc cache to be used in offline
     *
     * @return
     */
    private fun provideCache(): Cache? {
        var cache: Cache? = null
        try {
            cache = Cache(
                File(cacheDir, "http-cache"),
                10 * 1024 * 1024
            ) // 10 MB
        } catch (e: Exception) {
            println("Could not create Cache!")
        }
        return cache
    }

    /**
     * Provide cache Interceptor
     *
     * @return
     */
    private fun provideCacheInterceptor(): Interceptor? {
        return Interceptor { chain ->
            val response: Response = chain.proceed(chain.request())
            val cacheControl: CacheControl = if (isConnected) {
                CacheControl.Builder()
                    .maxAge(0, TimeUnit.SECONDS)
                    .build()
            } else {
                CacheControl.Builder()
                    .maxStale(7, TimeUnit.DAYS)
                    .build()
            }
            response.newBuilder()
                .removeHeader(HEADER_PRAGMA)
                .removeHeader(HEADER_CACHE_CONTROL)
                .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                .build()
        }
    }

    /**
     * provide offline cache
     *
     * @return
     */
    private fun provideOfflineCacheInterceptor(): Interceptor? {
        return Interceptor { chain ->
            var request: Request = chain.request()
            if (!isConnected) {
                val cacheControl = CacheControl.Builder()
                    .maxStale(7, TimeUnit.DAYS)
                    .build()
                request = request.newBuilder()
                    .removeHeader(HEADER_PRAGMA)
                    .removeHeader(HEADER_CACHE_CONTROL)
                    .cacheControl(cacheControl)
                    .build()
            }
            chain.proceed(request)
        }
    }
}