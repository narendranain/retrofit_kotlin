package com.example.kotlindemo.model

import com.google.gson.annotations.SerializedName
import java.io.File

data class UpdatedUser(
    @SerializedName("name") val name: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("email") val email: String?,
    @SerializedName("device_type") val device_type: String?,
    @SerializedName("device_token") val device_token: String?,
    @SerializedName("social_id") val social_id: String?,
    @SerializedName("create_date") val create_date: String?,
    @SerializedName("about") val about: String?,
    @SerializedName("profile_image") val profile_image: String?,
    @SerializedName("latitude") val latitude: String?,
    @SerializedName("longitude") val longitude: String?



)
