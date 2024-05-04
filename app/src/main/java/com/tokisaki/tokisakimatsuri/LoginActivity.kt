package com.tokisaki.tokisakimatsuri

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout
import com.tokisaki.tokisakimatsuri.model.response.LoginResponse
import com.tokisaki.tokisakimatsuri.provider.ApiClient.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //view variable initialization
        val loginButton = findViewById<Button>(R.id.login_button)
        val emailTextInput = findViewById<TextInputLayout>(R.id.email_text_input)
        val passwordTextInput = findViewById<TextInputLayout>(R.id.password_text_input)

        //validation input function
        fun validateInput(): Boolean {
            var isValid = true

            // Validate email address
            val email = emailTextInput.editText?.text.toString()
            if (email.isEmpty()) {
                emailTextInput.error = "Email address is required"
                isValid = false
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailTextInput.error = "Invalid email address"
                isValid = false
            } else {
                emailTextInput.error = null
            }

            // Validate password
            val password = passwordTextInput.editText?.text.toString()
            if (password.isEmpty()) {
                passwordTextInput.error = "Password is required"
                isValid = false
            } else {
                passwordTextInput.error = null
            }

            return isValid
        }



        loginButton.setOnClickListener {
            if (validateInput()) {
                val email = emailTextInput.editText?.text.toString()
                val password = passwordTextInput.editText?.text.toString()
                val call = apiService.login(email, password)

                call.enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if (response.isSuccessful) {
                            // Get the token from the response
                            val token = response.body()?.authorization?.token

                            // Store the token or perform other necessary actions
                            val toast = Toast.makeText(this@LoginActivity, "Token: $token", Toast.LENGTH_SHORT)
                            toast.show()
                        } else {
                            val toast = Toast.makeText(this@LoginActivity, "Token: error1", Toast.LENGTH_SHORT)
                            toast.show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        val toast = Toast.makeText(this@LoginActivity, "Token: $email $password", Toast.LENGTH_SHORT)
                        toast.show()
                    }
                })

//                val intent = Intent(this, HomeUserActivity::class.java)
//                startActivity(intent)
            } else {
                // Show error messages
            }

        }
    }
}