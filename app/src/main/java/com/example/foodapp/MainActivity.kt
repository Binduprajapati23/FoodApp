package com.example.foodapp

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity<EditTextEmailAddress> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


            val editTextEmail: EditText = findViewById(R.id.editTextTextEmailAddress)
            val editTextPassword: EditText = findViewById(R.id.editTextNumberPassword)
            val btnLogin: Button = findViewById(R.id.button3)

            btnLogin.setOnClickListener {
                val email = editTextEmail.text.toString().trim()
                val password = editTextPassword.text.toString().trim()

                if (validateInput(email, password)) {
                    loginUser(email, password)
                }
            }
        }

         fun validateInput(email: String, password: String): Boolean {
            return when {
                email.isEmpty() -> {
                    print("Email cannot be empty")
                    false
                }

                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    print("Please enter a valid email")
                    false
                }

                password.isEmpty() -> {
                    print("Password cannot be empty")
                    false
                }

                else -> true
            }
        }

         fun loginUser(email: String, password: String) {
            if (email == "user@example.com" && password == "password123") {
                print("Login successful!")
                // Navigate to another activity or perform your next action
            } else {
                print("Invalid email or password")
            }
        }

         fun showToast(message: String) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun loginUser(email: String, password: String) {

    }

    private fun validateInput(email: String, password: String): Boolean {


    }
}




