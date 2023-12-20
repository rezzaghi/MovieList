package com.example.movielist.data.model

import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("title")
    val title: String = "",
    @SerializedName("poster_path")
    val posterPath: String = "",
)
data class MoviesResponse(
    @SerializedName("results")
    var movies: List<Movies>
)
