package com.khaled.paytabstask

import com.khaled.paytabstask.model.ObjectMapper
import com.khaled.paytabstask.model.User
import org.junit.Assert.*
import org.junit.Test

class ObjectMapperTest{

    @Test
    fun jsonToModelTest() {
        val jsonString = "{userId: 1, id: 1, title: delectus aut autem, completed: false}"
        val modelObject = ObjectMapper.stringToModel<User>(jsonString)
        val expectedModel = User(false, 1, "delectus aut autem",1)
        assertEquals(expectedModel, modelObject)
    }

}