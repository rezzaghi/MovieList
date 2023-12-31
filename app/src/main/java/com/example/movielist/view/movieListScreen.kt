package com.example.movielist.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun MovieListScreen(){
    val viewModel = viewModel<MovieListViewModel>()
    val movies = viewModel.state.collectAsState().value.moviesResponse.movies

    Column {
        Box(modifier = Modifier.weight(0.9f)){
            LazyColumn(){
                itemsIndexed(movies){ _, item ->
                    Text(text = item.title)
                    Image(
                        modifier = Modifier.size(128.dp),
                        painter = rememberAsyncImagePainter(model = "https://image.tmdb.org/t/p/original${item.posterPath}") ,
                        contentDescription = null
                    )
                }

            }
        }
        Box(modifier = Modifier.weight(0.1f)){
            Button(
                onClick = {viewModel.getMovies()}){
                Text(text ="request" )
            }
        }
    }
}