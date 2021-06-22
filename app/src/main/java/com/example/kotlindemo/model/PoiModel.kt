package com.example.kotlindemo.model

import com.google.gson.annotations.SerializedName

data class PoiModel(
    @SerializedName("status") val status: Int?,
    @SerializedName("msg") val msg: String?
)
