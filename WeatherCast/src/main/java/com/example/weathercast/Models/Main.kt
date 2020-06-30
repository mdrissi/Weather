package com.example.weathercast.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Main {
    /**
     * temperature
     */

    @SerializedName("temp")
    @Expose
    private var temp: Double? = null

    /**
     * real feel
     */
    @SerializedName("feels_like")
    @Expose
    private var feelsLike: Double? = null

    /**
     * Minimum temperature same city during day
     */
    @SerializedName("temp_min")
    @Expose
    private var tempMin: Double? = null

    /**
     * Maximum temperature same city during day
     */
    @SerializedName("temp_max")
    @Expose
    private var tempMax: Double? = null

    /**
     * the Pressure
     */
    @SerializedName("pressure")
    @Expose
    private var pressure: Double? = null

    /**
     * humidity
     */
    @SerializedName("humidity")
    @Expose
    private var humidity: Double? = null

    /**
     * Tgetter for temperature
     *
     * @return double
     */
    fun getTemp(): Double? {
        return temp
    }

    /**
     * setter
     *
     * @param temp
     */
    fun setTemp(temp: Double?) {
        this.temp = temp
    }

    /**
     * How feels like
     *
     * @return double
     */
    fun getFeelsLike(): Double? {
        return feelsLike
    }

    fun setFeelsLike(feelsLike: Double?) {
        this.feelsLike = feelsLike
    }

    /**
     * get the minimum temperature
     *
     * @return
     */
    fun getTempMin(): Double? {
        return tempMin
    }

    fun setTempMin(tempMin: Double?) {
        this.tempMin = tempMin
    }

    /**
     * Get  the max temperature
     *
     * @return
     */
    fun getTempMax(): Double? {
        return tempMax
    }

    fun setTempMax(tempMax: Double?) {
        this.tempMax = tempMax
    }

    /**
     * get the pressure
     *
     * @return
     */
    fun getPressure(): Double? {
        return pressure
    }

    fun setPressure(pressure: Double?) {
        this.pressure = pressure
    }

    /**
     * get the Humidity
     *
     * @return
     */
    fun getHumidity(): Double? {
        return humidity
    }

    fun setHumidity(humidity: Double?) {
        this.humidity = humidity
    }
}