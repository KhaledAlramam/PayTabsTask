package com.khaled.paytabstask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.khaled.paytabstask.databinding.ActivityMainBinding
import com.khaled.paytabstask.model.ObjectMapper
import com.khaled.paytabstask.model.User
import com.khaled.paytabstask.network.MyRequestHandler
import com.khaled.paytabstask.util.BASE_URL
import com.khaled.paytabstask.util.MY_PATH

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        fetchData()
    }

    /**
     * Start a background thread to fetch data
     * when data arrives we switch to main thread
     * to update ui
     */
    private fun fetchData() {
        binding.progressBar.isVisible = true
        Thread {
            val fullLink = "$BASE_URL$MY_PATH"
            val response = MyRequestHandler.performGetRequest(fullLink)
            runOnUiThread {
                displayResponse(response)
            }
        }.start()
    }

    private fun displayResponse(response: String) {
        binding.progressBar.isVisible = false
        binding.resultText.text = response
    }
}