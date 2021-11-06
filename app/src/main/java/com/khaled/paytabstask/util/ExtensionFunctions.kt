package com.khaled.paytabstask.util

import java.net.URLEncoder


fun Map<String,String>?.mapToEncodedParameters(): String {
    var reqParams = ""
    this?.let {
        for (k in it.keys) {
            val value = URLEncoder.encode(this[k], "UTF-8")
            reqParams += "${URLEncoder.encode(k, "UTF-8")}=$value&"
        }
        return reqParams.substring(0, reqParams.length - 1)
    }
    return reqParams
}