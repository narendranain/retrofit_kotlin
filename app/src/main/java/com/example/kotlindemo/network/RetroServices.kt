package com.example.kotlindemo.network

import com.example.kotlindemo.model.PoiModel
import com.example.kotlindemo.model.SignUp
import com.example.kotlindemo.model.UpdateUserModel
import retrofit2.Call
import retrofit2.http.*
import java.io.File

interface RetroServices {


    @FormUrlEncoded
    @POST("signup")
     fun signup(
        @Field("name") name:String,
        @Field("email") email:String,
        @Field("device_type") device_type:String,
        @Field("device_token") device_token:String,
        @Field("social_id") social_id:String
     ):Call<SignUp>


     @FormUrlEncoded
     @Headers("Authorization:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyRGF0YSI6eyJpZCI6OTh9LCJpYXQiOjE2MjQzNTY3NjksImV4cCI6MzI0ODkyOTUzOH0.f10bFys6jqbkOg4uxaf9lSX0KIgPFDs_FaJrrJXW158"
     )
     @POST("create-poi")
     fun createpoi(
         @Field("title") title:String,
         @Field("description") description:String,
         @Field("category") category:String,
         @Field("latitude") latitude:String,
         @Field("longitude") longitude:String,
         @Field("address") address:String,
         @Field("audio_duration") audio_duration:String,
         @Field("radius") radius:String,
         @Field("poi_type") poi_type:String
     ):Call<PoiModel>

    @FormUrlEncoded
    @Headers("Authorization:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyRGF0YSI6eyJpZCI6OTh9LCJpYXQiOjE2MjQzNTY3NjksImV4cCI6MzI0ODkyOTUzOH0.f10bFys6jqbkOg4uxaf9lSX0KIgPFDs_FaJrrJXW158"

    )
    @PUT("update-details")
    fun updateuser(
        @Field("name") name:String,
        @Field("email") email:String,
        @Field("about") about:String,
        @Field("latitude") latitude:String,
        @Field("longitude") longitude:String
      //  @Field("profile_image") file: File
    ):Call<UpdateUserModel>




}