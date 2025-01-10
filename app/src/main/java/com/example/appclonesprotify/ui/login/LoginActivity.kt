package com.example.appclonesprotify.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appclonesprotify.R
import com.example.appclonesprotify.ui.signup.SignUpActivity1 // Import SignUpActivity1

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val signupButton = findViewById<Button>(R.id.signup_button)
        signupButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity1::class.java) // Start SignUpActivity1
            startActivity(intent)
        }
    }
}