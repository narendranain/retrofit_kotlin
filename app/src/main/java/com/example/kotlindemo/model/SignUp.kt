package com.example.kotlindemo.model

import com.google.gson.annotations.SerializedName

data class SignUp(

    @SerializedName("status") val status: Int?,
    @SerializedName("msg") val msg: String?,
    val result: SigninUser?
)
