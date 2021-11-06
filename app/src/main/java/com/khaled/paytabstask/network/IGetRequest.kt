package com.khaled.paytabstask.network

/**
 * Interface for get request signature
 */
interface IGetRequest {
    fun performGetRequest(stringUrl: String): String
}