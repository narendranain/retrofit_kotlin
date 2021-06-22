package com.example.kotlindemo.model

import com.google.gson.annotations.SerializedName

data class SigninUser(

    @SerializedName("name") val name: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("device_type") val device_type: String?,
    @SerializedName("device_token") val device_token: String?,
    @SerializedName("social_id") val social_id: String?,
    @SerializedName("token") val token: String?

)
