package com.example.weathercast.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Main {
    @SerializedName("temp")
    @Expose
    private var temp: Double? = null

    @SerializedName("feels_like")
    @Expose
    private var feelsLike: Double? = null

    @SerializedName("temp_min")
    @Expose
    private var tempMin: Double? = null

    @SerializedName("temp_max")
    @Expose
    private var tempMax: Double? = null

    @SerializedName("pressure")
    @Expose
    private var pressure: Double? = null

    @SerializedName("humidity")
    @Expose
    private var humidity: Double? = null

    fun getTemp(): Double? {
        return temp
    }

    fun setTemp(temp: Double?) {
        this.temp = temp
    }

    fun getFeelsLike(): Double? {
        return feelsLike
    }

    fun setFeelsLike(feelsLike: Double?) {
        this.feelsLike = feelsLike
    }

    fun getTempMin(): Double? {
        return tempMin
    }

    fun setTempMin(tempMin: Double?) {
        this.tempMin = tempMin
    }

    fun getTempMax(): Double? {
        return tempMax
    }

    fun setTempMax(tempMax: Double?) {
        this.tempMax = tempMax
    }

    fun getPressure(): Double? {
        return pressure
    }

    fun setPressure(pressure: Double?) {
        this.pressure = pressure
    }

    fun getHumidity(): Double? {
        return humidity
    }

    fun setHumidity(humidity: Double?) {
        this.humidity = humidity
    }
}