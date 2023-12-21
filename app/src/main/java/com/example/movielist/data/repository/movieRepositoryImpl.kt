package com.example.movielist.data.repository

import com.example.movielist.data.api.MovieApi
import com.example.movielist.data.api.MovieService
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl: MovieRepository {
    private val retrofit = MovieApi().getRetrofitInstance()
    private val endpoint = retrofit.create(MovieService::class.java)
    override fun getMoviesData() = flow {
        page += 1
        emit(endpoint.getMovieList(page = page))
    }
    companion object{
        var page = 0
    }
}