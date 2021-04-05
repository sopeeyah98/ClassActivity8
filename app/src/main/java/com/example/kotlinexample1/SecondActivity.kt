package com.example.kotlinexample1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinexample1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var textViewGreeting: TextView
    private lateinit var buttonHistory: Button
    private final val baseUrl = "https://www.behindthename.com/name/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textViewGreeting = binding.textViewGreeting
        val message = intent.getStringExtra("name")
        textViewGreeting.text = "Hello, " + message

        buttonHistory = binding.buttonHistory;
        buttonHistory.text = "History about " + message
        buttonHistory.setOnClickListener {
            if (message != null) {
                launchBrowser(message)
            }
        }
    }

    // when button is clicked,
    // send an implicit intent with the name passed through the intent
    // https://www.behindthename.com/name/NAME
    private fun launchBrowser(name: String){
        // uri to parse actual url
        // start activity with action view
        val queryURL: Uri = Uri.parse("${baseUrl}${name}")
        val intent = Intent(Intent.ACTION_VIEW, queryURL)
        startActivity(intent)
    }
}