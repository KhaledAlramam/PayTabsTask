package com.khaled.paytabstask.network

/**
 * Interface for post request signature
 */
interface IPostRequest {
    fun performPostRequest(stringUrl: String, params: Map<String, String>?): String
}