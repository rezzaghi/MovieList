package com.example.movielist.view

import com.example.movielist.data.model.Movies
import com.example.movielist.data.model.MoviesResponse

data class MovieListState(
    var moviesResponse: MoviesResponse = MoviesResponse(movies = emptyList())
)
