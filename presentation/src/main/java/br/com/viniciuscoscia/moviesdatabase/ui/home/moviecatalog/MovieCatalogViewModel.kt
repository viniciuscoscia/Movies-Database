package br.com.viniciuscoscia.moviesdatabase.ui.home.moviecatalog

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.viniciuscoscia.domain.moviesdatabase.entities.Movie
import br.com.viniciuscoscia.domain.moviesdatabase.usecases.FetchPopularMoviesUseCase
import br.com.viniciuscoscia.moviesdatabase.commons.BaseViewModel
import kotlinx.coroutines.launch

class MovieCatalogViewModel(
    private val context: Context,
    private val useCase: FetchPopularMoviesUseCase
) : BaseViewModel() {

    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()
    val movies: LiveData<List<Movie>> = _movies

    fun getPopularMovies() = viewModelScope.launch {
        _movies.value = useCase.execute().results
    }
}