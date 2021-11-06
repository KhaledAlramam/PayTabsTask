package com.khaled.paytabstask.network

import com.khaled.paytabstask.util.mapToEncodedParameters
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

object MyRequestHandler : IGetRequest, IPostRequest {

    override fun performGetRequest(stringUrl: String): String {
        var response = ""
        val url = URL(stringUrl)
        with(url.openConnection() as HttpURLConnection) {
            inputStream.bufferedReader().use {
                val bufferResponse = StringBuffer()
                var inputLine = it.readLine()
                while (inputLine != null) {
                    bufferResponse.append(inputLine)
                    println(inputLine)
                    inputLine = it.readLine()
                }
                it.close()
                println("Response : $bufferResponse")
                response = bufferResponse.toString()
            }
        }

        return response
    }

    override fun performPostRequest(stringUrl: String, params: Map<String, String>?): String {
        var response = ""
        val url = URL(stringUrl)
        val encodedParameters = params.mapToEncodedParameters()
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json")
            doOutput = true
            val writer = BufferedWriter(
                OutputStreamWriter(outputStream, "UTF-8")
            )
            params?.let { writer.write(encodedParameters) }
            outputStream.flush();
            println("URL : $url")
            println("Response Code : $responseCode")
            inputStream.bufferedReader().use {
                val bufferResponse = StringBuffer()
                var inputLine = it.readLine()
                while (inputLine != null) {
                    bufferResponse.append(inputLine)
                    println(inputLine)
                    inputLine = it.readLine()
                }
                it.close()
                println("Response : $bufferResponse")
                response = bufferResponse.toString()
            }
        }
        return response
    }


}