package com.example.weathercast.Interfaces

import com.example.weathercast.Models.Cast

/**
 * Listener for the Data retrieved
 *
 */
interface OnDataRetrievedListener {
    fun onSuccess(cast:Cast)
    fun onFailure()
    fun connectionFail()
}