package com.example.movieapp.data.vo


import com.google.gson.annotations.SerializedName

data class Movie(

    @SerializedName("id")
    val id: Int,
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String
)