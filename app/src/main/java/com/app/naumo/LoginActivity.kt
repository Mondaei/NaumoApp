package com.app.naumo.ui.login

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.naumo.R


class LoginActivity : AppCompatActivity() {
    // UI References
    private var emailEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var rememberMeCheckbox: CheckBox? = null
    private var loginButton: Button? = null
    private var forgotPasswordTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login) // Set the XML layout

        // Bind UI components
        emailEditText = findViewById<EditText>(R.id.emailEditText)
        passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        rememberMeCheckbox = findViewById<CheckBox>(R.id.rememberMeCheckbox)
        loginButton = findViewById<Button>(R.id.loginButton)
        forgotPasswordTextView = findViewById<TextView>(R.id.forgotPasswordTextView)

        // Handle "Log in" button click
        loginButton.setOnClickListener(View.OnClickListener {
            val email = emailEditText.getText().toString()
            val password = passwordEditText.getText().toString()

            // Validate input
            if (email.isEmpty()) {
                emailEditText.setError("Email is required")
                return@OnClickListener
            }
            if (password.isEmpty()) {
                passwordEditText.setError("Password is required")
                return@OnClickListener
            }

            // Perform login logic (e.g., API call)
            if (isValidCredentials(email, password)) {
                Toast.makeText(this@LoginActivity, "Login successful!", Toast.LENGTH_SHORT).show()
                // Redirect to home screen or main activity
                val intent = Intent(
                    this@LoginActivity,
                    HomeActivity::class.java
                )
                startActivity(intent)
                finish() // Optional: Close the login activity
            } else {
                Toast.makeText(this@LoginActivity, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        })

        // Handle "Forgot password?" link
        forgotPasswordTextView.setOnClickListener(View.OnClickListener { // Navigate to forgot password screen
            val intent = Intent(

            )
            startActivity(intent)
        })
    }

    // Dummy method to validate credentials
    private fun isValidCredentials(email: String, password: String): Boolean {
        // Replace with actual validation logic (e.g., API call)
        return email == "user@example.com" && password == "password123"
    }
}