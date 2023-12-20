package com.example.movielist.data.repository

import com.example.movielist.data.model.MoviesResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMoviesData(): Flow<MoviesResponse>
}