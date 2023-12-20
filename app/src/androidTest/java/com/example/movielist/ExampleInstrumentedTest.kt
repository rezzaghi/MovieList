package com.example.movielist

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.movielist.data.api.MovieApi
import com.example.movielist.data.api.MovieService
import com.example.movielist.data.model.Movies
import com.example.movielist.data.model.MoviesResponse
import kotlinx.coroutines.runBlocking

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() = runBlocking{
        val t = MovieApi().getRetrofitInstance()
        val endpoint = t.create(MovieService::class.java)
        assertEquals(MoviesResponse(listOf(Movies(title = "k", posterPath = "c"))), endpoint.getMovieList())
    }
}