package com.example.kotlindemo.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.R
import com.example.kotlindemo.model.UpdateUserModel
import com.example.kotlindemo.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_update.*
import kotlinx.android.synthetic.main.activity_update.editTextEmail
import kotlinx.android.synthetic.main.activity_update.editTextName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class UpdateUser :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        val name = editTextName.text.toString().trim()
        val email = editTextEmail.text.toString().trim()

        val about = editTextabout.text.toString().trim()
        val latitute = editTextlatitute.text.toString().trim()
        val longitute = editTextlongitute.text.toString().trim()
        buttonupdate.setOnClickListener {

            RetrofitClient.instance.updateuser(name,email,about,latitute,longitute)
                .enqueue(object : Callback<UpdateUserModel> {
                    override fun onFailure(call: Call<UpdateUserModel>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<UpdateUserModel>, response: Response<UpdateUserModel>) {
                        if (response.body()!=null) {
                            Toast.makeText(
                                applicationContext,
                                response.body()?.msg,
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }
                    }

                })
        }
    }
}