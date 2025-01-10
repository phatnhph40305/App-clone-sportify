
package com.example.appclonesprotify.ui.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.appclonesprotify.R
import com.example.appclonesprotify.ui.signup.data.local.model.User
import com.example.appclonesprotify.ui.signup.data.local.database.UserDatabase
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpActivity1 : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var nextButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup1)

        emailInput = findViewById(R.id.email_input)
        nextButton = findViewById(R.id.next_button)

        nextButton.setOnClickListener {
            val email = emailInput.text.toString()
            val intent = Intent(this, SignUpActivity2::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }
}

class SignUpActivity2 : AppCompatActivity() {

    private lateinit var passwordInput: EditText
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup2)

        passwordInput = findViewById(R.id.password_input)
        nextButton = findViewById(R.id.next_button)

        nextButton.setOnClickListener {
            val email = intent.getStringExtra("email") ?: ""
            val password = passwordInput.text.toString()
            val intent = Intent(this, SignUpActivity3::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            startActivity(intent)
        }
    }
}

class SignUpActivity3 : AppCompatActivity() {

    private lateinit var maleCheckBox: CheckBox
    private lateinit var femaleCheckBox: CheckBox
    private lateinit var otherCheckBox: CheckBox
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup3)

        maleCheckBox = findViewById(R.id.cb_male)
        femaleCheckBox = findViewById(R.id.cb_female)
        otherCheckBox = findViewById(R.id.cb_other)
        nextButton = findViewById(R.id.next_button)

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
            val name = intent.getStringExtra("name") ?: ""

            val intent = Intent(this, SignUpActivity4::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("name", name)
            intent.putExtra("gender", gender)
            startActivity(intent)
        }
    }
}

class SignUpActivity4 : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var newsCheckBox: CheckBox
    private lateinit var marketingCheckBox: CheckBox
    private lateinit var createAccountButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup4)

        nameInput = findViewById(R.id.nameEditText)
        newsCheckBox = findViewById(R.id.newsCheckBox)
        marketingCheckBox = findViewById(R.id.marketingCheckBox)
        createAccountButton = findViewById(R.id.createAccountButton)

        createAccountButton.setOnClickListener {
            val email = intent.getStringExtra("email") ?: ""
            val password = intent.getStringExtra("password") ?: ""
            val name = nameInput.text.toString()
            val gender = intent.getStringExtra("gender") ?: ""

            if (name.isBlank() || !newsCheckBox.isChecked || !marketingCheckBox.isChecked) {
                return@setOnClickListener
            }

            val user = User(email, password, name, gender)
            val db = UserDatabase.getDatabase(this)
            val userDao = db.userDao()

            CoroutineScope(Dispatchers.IO).launch {
                userDao.insert(user)
            }
        }
        }
    }


