package com.example.kotlindemo.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.R
import com.example.kotlindemo.model.PoiModel
import com.example.kotlindemo.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_poi.*
import kotlinx.android.synthetic.main.activity_update.*
import kotlinx.android.synthetic.main.activity_update.buttonupdate
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CreatePOI : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poi)

        val title = editTexttitle.text.toString().trim()
        val description = editTextdescription.text.toString().trim()
        val category = editTextcategory.text.toString().trim()
        val latitute = editTextlatitude.text.toString().trim()
        val longitute = editTexlongitude.text.toString().trim()
        val address = editTextaddress.text.toString().trim()
        val audioduration = editTaudio_duration.text.toString().trim()
        val radius = editTextradius.text.toString().trim()
        val polltype = editTextpoll_type.text.toString().trim()
        buttonupdate.setOnClickListener {


            RetrofitClient.instance.createpoi(title,description,category,latitute,longitute,address,audioduration,radius,polltype )

                .enqueue(object : Callback<PoiModel> {
                    override fun onFailure(call: Call<PoiModel>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<PoiModel>, response: Response<PoiModel>) {
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