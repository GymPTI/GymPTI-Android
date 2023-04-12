package com.example.gympti

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.gympti.login.Fragment.LoginFragment

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn : Button = findViewById(R.id.btn1)

        btn.setOnClickListener{
            val intent = Intent(this, LoginFragment::class.java)
            startActivity(intent)
        }
    }
}