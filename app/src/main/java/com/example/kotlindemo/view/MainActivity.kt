package com.example.kotlindemo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlindemo.R
import com.example.kotlindemo.model.SignUp
import com.example.kotlindemo.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.editTextDevice
import kotlinx.android.synthetic.main.activity_main.editTextEmail
import kotlinx.android.synthetic.main.activity_main.editTextName
import kotlinx.android.synthetic.main.activity_main.editTextSocial
import kotlinx.android.synthetic.main.activity_main.editTextToken
import kotlinx.android.synthetic.main.activity_update.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonSignUp.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val devicetype = editTextDevice.text.toString().trim()
            val devicetoken = editTextToken.text.toString().trim()
            val socialid = editTextSocial.text.toString().trim()

            if (name.isEmpty()) {
                editTextName.error = "Please enter Your name"
                editTextName.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                editTextEmail.error = "Please enter Email id"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }


            if (devicetoken.isEmpty()) {
                editTextToken.error = "Enter Token"
                editTextToken.requestFocus()
                return@setOnClickListener
            }

            if (devicetype.isEmpty()) {
                editTextDevice.error = "Enter Device Type"
                editTextDevice.requestFocus()
                return@setOnClickListener
            }

            if (socialid.isEmpty()) {
                editTextSocial.error = "School required"
                editTextSocial.requestFocus()
                return@setOnClickListener
            }
            RetrofitClient.instance.signup(name,email,devicetype,devicetoken,socialid)
                .enqueue(object : Callback<SignUp> {
                    override fun onFailure(call: Call<SignUp>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<SignUp>, response: Response<SignUp>) {
                        Toast.makeText(applicationContext, response.body()?.msg, Toast.LENGTH_LONG)
                            .show()
                    }

                })

        }
        buttonpoi.setOnClickListener {
            val intent = Intent(this, UpdateUser::class.java)
            startActivity(intent)
        }
        buttonpoi.setOnClickListener {
            val intent = Intent(this, CreatePOI::class.java)
            startActivity(intent)
        }
        buttonupdateuser.setOnClickListener {
            val intent =Intent(this,UpdateUser::class.java)
            startActivity(intent)
        }


    }




}