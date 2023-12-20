package com.example.movielist.data.api

import com.example.movielist.data.model.Movies
import com.example.movielist.data.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface MovieService {
    @Headers(
        "Accept: application/json",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NWQ5MzNkMDYwMzA5NGIyYzI1MWQwNWE0MDA4YzQ4NCIsInN1YiI6IjY1ODIxZGU3MmY4ZDA5MDhkNWE4ZGNmNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.__RUucs52Aof5VPO6vNqsT_Kshb0Lt6_KX2oFC8Z6EI"
    )
    @GET("3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc")
    suspend fun getMovieList(): MoviesResponse
}