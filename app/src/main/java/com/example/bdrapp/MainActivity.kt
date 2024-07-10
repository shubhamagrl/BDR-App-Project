package com.example.bdrapp

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var image: ImageView = findViewById(R.id.idmeter)

        var arr = listOf(R.drawable.connected, R.drawable.disconnected)
        var index = 0

        image.setOnClickListener{
            index = (index+1)%2
            image.setImageResource(arr[index])
        }
    }
}