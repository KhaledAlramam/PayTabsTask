package com.khaled.paytabstask.model

import org.json.JSONObject

/**
 * Tried to implement my own modeling function but I guess
 * it didn't go well
 */
object ObjectMapper {

    inline fun <reified MODEL> stringToModel(jsonString: String): MODEL {
        val jsonObject = JSONObject(jsonString)
        val fieldsArray = ArrayList<Any>()
        MODEL::class.members.forEach { i ->
            fieldsArray.add(jsonObject.get(i.name))
        }
        return MODEL::class.constructors.first().call(fieldsArray)
    }
}