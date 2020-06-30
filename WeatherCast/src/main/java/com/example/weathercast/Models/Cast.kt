package com.example.weathercast.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Cast {
    @SerializedName("weather")
    @Expose
    private var weather: List<Weather>? = null

    @SerializedName("main")
    @Expose
    private var main: Main? = null

    @SerializedName("wind")
    @Expose
    private var wind: Wind? = null

    @SerializedName("sys")
    @Expose
    private var sys: Sys? = null

    @SerializedName("timezone")
    @Expose
    private var timezone: Int? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("cod")
    @Expose
    private var cod: Int? = null

    /**
     * Get weather scope
     *
     * @return List
     */
    fun getWeather(): List<Weather?>? {
        return weather
    }

    fun setWeather(weather: List<Weather?>?) {
        this.weather = weather as List<Weather>?
    }

    /**
     * Get the main
     *
     * @return
     */
    fun getMain(): Main? {
        return main
    }

    fun setMain(main: Main?) {
        this.main = main
    }

    fun getWind(): Wind? {
        return wind
    }

    fun setWind(wind: Wind?) {
        this.wind = wind
    }

    fun getSys(): Sys? {
        return sys
    }

    fun setSys(sys: Sys?) {
        this.sys = sys
    }

    fun getTimezone(): Int? {
        return timezone
    }

    fun setTimezone(timezone: Int?) {
        this.timezone = timezone
    }

    /**
     * get city name
     *
     * @return string
     */
    fun getName(): String? {
        return name
    }

    /**
     * set city Name
     *
     * @param name
     */
    fun setName(name: String?) {
        this.name = name
    }

    /**
     * get Cod
     *
     * @return int
     */
    fun getCod(): Int? {
        return cod
    }

    /**
     * setter for Cod
     *
     * @param cod
     */
    fun setCod(cod: Int?) {
        this.cod = cod
    }
}