package com.example.movielist.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movielist.data.model.MoviesResponse
import com.example.movielist.data.repository.MovieRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MovieListViewModel: ViewModel() {
    private val repository = MovieRepositoryImpl()
    private val _state = MutableStateFlow(MovieListState())
    val state: StateFlow<MovieListState> = _state.asStateFlow()

    fun getMovies(){
        viewModelScope.launch {
            repository.getMoviesData()
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    print("error")
                }
                .collect { movies ->
                    val newMovies = MoviesResponse(_state.value.moviesResponse.movies + movies.movies)
                    _state.value = _state.value.copy(moviesResponse = newMovies)
                }
        }
    }

}