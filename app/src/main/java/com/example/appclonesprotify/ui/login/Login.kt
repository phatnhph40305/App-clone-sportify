package com.example.appclonesprotify.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.appclonesprotify.R
import com.example.appclonesprotify.ui.MainActivity
import com.example.appclonesprotify.ui.signup.data.local.database.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Login : AppCompatActivity() {

    private lateinit var emailOrUsernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login1)

        emailOrUsernameEditText = findViewById(R.id.email_or_username_input)
        passwordEditText = findViewById(R.id.password_input)
        loginButton = findViewById(R.id.login_button)

        loginButton.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val emailOrUsername = emailOrUsernameEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if (emailOrUsername.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter your email/username and password", Toast.LENGTH_SHORT).show()
            return
        }

        val userDao = UserDatabase.getDatabase(this).userDao()

        lifecycleScope.launch {
            try {
                val user = userDao.getUserByEmailOrName(emailOrUsername)

                if (user != null && user.password == password) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@Login, "Login successful", Toast.LENGTH_SHORT).show()
                    }
                    startActivity(Intent(this@Login, MainActivity::class.java))
                    finish()
                } else {

                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@Login, "Invalid email/username or password", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@Login, "Error during login", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}