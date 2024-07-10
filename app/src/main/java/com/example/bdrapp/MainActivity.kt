package com.example.bdrapp

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bdrapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        var arr = listOf(R.drawable.connected, R.drawable.disconnected)
        var index = 0

        binding.apply {
            idmeter.setOnClickListener {
                index = (index + 1) % 2
                idmeter.setImageResource(arr[index])
            }
        }
    }
}