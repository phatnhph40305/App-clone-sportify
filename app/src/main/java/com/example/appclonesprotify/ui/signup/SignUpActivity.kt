package com.example.appclonesprotify.ui.signup


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appclonesprotify.R
import com.example.appclonesprotify.ui.login.LoginActivity
import com.example.appclonesprotify.ui.signup.data.local.database.UserDatabase
import com.example.appclonesprotify.ui.signup.data.local.model.User
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpActivity1 : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var nextButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup1)

        emailInput = findViewById(R.id.email_input)
        nextButton = findViewById(R.id.btn_next)
        backButton = findViewById(R.id.btn_back1)

        nextButton.setOnClickListener {
            val email = emailInput.text.toString()

            if (isValidEmail(email)) {
                val intent = Intent(this, SignUpActivity2::class.java)
                intent.putExtra("email", email)
                startActivity(intent)
            } else {
                emailInput.error = "Please enter a valid email address"
            }
        }

        backButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    private fun isValidEmail(email: String): Boolean {
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailRegex.toRegex())
    }
}

class SignUpActivity2 : AppCompatActivity() {

    private lateinit var passwordInput: EditText
    private lateinit var nextButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup2)

        passwordInput = findViewById(R.id.password_input)
        nextButton = findViewById(R.id.btn_next)
        backButton = findViewById(R.id.btn_back2)

        nextButton.setOnClickListener {
            val email = intent.getStringExtra("email") ?: ""
            val password = passwordInput.text.toString()
            if (isValidPassword(password)) {
                val intent = Intent(this, SignUpActivity3::class.java)
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                startActivity(intent)
            } else {
                passwordInput.error = "Password must be at least 8 characters long"
//                Toast.makeText(this, "Password must be at least 8 characters long", Toast.LENGTH_SHORT).show()
            }
        }
        backButton.setOnClickListener {
            finish()
        }
    }
    private fun isValidPassword(password: String): Boolean {
        return password.length >= 8;
    }

}

class SignUpActivity3 : AppCompatActivity() {

    private lateinit var maleCheckBox: CheckBox
    private lateinit var femaleCheckBox: CheckBox
    private lateinit var otherCheckBox: CheckBox
    private lateinit var nextButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup3)

        maleCheckBox = findViewById(R.id.cb_male)
        femaleCheckBox = findViewById(R.id.cb_female)
        otherCheckBox = findViewById(R.id.cb_other)
        nextButton = findViewById(R.id.btn_next)
        backButton = findViewById(R.id.btn_back3)

        maleCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                femaleCheckBox.isChecked = false
                otherCheckBox.isChecked = false
            }
        }

        femaleCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                maleCheckBox.isChecked = false
                otherCheckBox.isChecked = false
            }
        }

        otherCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                maleCheckBox.isChecked = false
                femaleCheckBox.isChecked = false
            }
        }

        nextButton.setOnClickListener {
            if (!maleCheckBox.isChecked && !femaleCheckBox.isChecked && !otherCheckBox.isChecked) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Please select a gender",
                    Snackbar.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val gender = when {
                maleCheckBox.isChecked -> "Male"
                femaleCheckBox.isChecked -> "Female"
                otherCheckBox.isChecked -> "Other"
                else -> ""
            }
            val email = intent.getStringExtra("email") ?: ""
            val password = intent.getStringExtra("password") ?: ""

            val intent = Intent(this, SignUpActivity4::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gender", gender)
            startActivity(intent)
        }



        backButton.setOnClickListener {
            finish()
        }
    }
}

class SignUpActivity4 : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var newsCheckBox: CheckBox
    private lateinit var marketingCheckBox: CheckBox
    private lateinit var createAccountButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup4)

        nameInput = findViewById(R.id.nameEditText)
        newsCheckBox = findViewById(R.id.newsCheckBox)
        marketingCheckBox = findViewById(R.id.marketingCheckBox)
        createAccountButton = findViewById(R.id.createAccountButton)
        backButton = findViewById(R.id.btn_back4)

        createAccountButton.setOnClickListener {
            val email = intent.getStringExtra("email") ?: ""
            val password = intent.getStringExtra("password") ?: ""
            val name = nameInput.text.toString()
            val gender = intent.getStringExtra("gender") ?: ""

            val specialCharRegex = Regex("[^a-zA-Z0-9 ]")

            val user = User(email, password, name, gender)
            val db = UserDatabase.getDatabase(this)
            val userDao = db.userDao()

            if (name.isBlank()) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Please enter your name",
                    Snackbar.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            if (specialCharRegex.containsMatchIn(name)) {
                nameInput.error = "Name cannot contain special characters"
                return@setOnClickListener
            }


            if (!newsCheckBox.isChecked || !marketingCheckBox.isChecked) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Please agree to both terms",
                    Snackbar.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    userDao.insert(user)

                    runOnUiThread {
                        Snackbar.make(
                            findViewById(android.R.id.content),
                            "Account created successfully!",
                            Snackbar.LENGTH_SHORT
                        ).show()
                        val intent = Intent(this@SignUpActivity4, ChooseArtists::class.java)
                        startActivity(intent)
                        finish()
                    }

                } catch (e: Exception) {
                    runOnUiThread {
                        Snackbar.make(
                            findViewById(android.R.id.content),
                            "Account creation failed. Please try again.",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                    e.printStackTrace()
                }
            }

            backButton.setOnClickListener {
                finish()
            }
        }
    }
}