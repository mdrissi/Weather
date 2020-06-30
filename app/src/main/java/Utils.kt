package com.example.weather

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
class Utils {
    private val TAG = "checkConnection"

    /**
     * cheak weather we are connected or not
     *
     * @param context
     * @return Boolean
     */
    fun isConnected(context: Context): Boolean {
        try {
            val e: ConnectivityManager = context.getSystemService(
                Context.CONNECTIVITY_SERVICE
            ) as ConnectivityManager
            val activeNetwork: NetworkInfo = e.getActiveNetworkInfo()
            return activeNetwork.isConnectedOrConnecting()
        } catch (e: Exception) {
            Log.w(TAG, e.toString())
        }
        return false
    }
}