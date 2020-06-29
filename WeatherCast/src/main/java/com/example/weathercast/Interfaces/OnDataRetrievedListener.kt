package com.example.weathercast.Interfaces

import com.example.weathercast.Models.Cast

interface OnDataRetrievedListener {
    fun onSuccess(cast:Cast)
    fun onFailure()
    fun conexionFail()
}