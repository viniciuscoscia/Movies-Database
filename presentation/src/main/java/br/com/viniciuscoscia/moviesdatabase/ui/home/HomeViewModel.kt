package br.com.viniciuscoscia.moviesdatabase.ui.home

import android.content.Context
import android.util.Log
import androidx.lifecycle.viewModelScope
import br.com.viniciuscoscia.domain.moviesdatabase.usecases.FetchPopularMoviesUseCase
import br.com.viniciuscoscia.moviesdatabase.commons.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val context: Context,
    private val useCase: FetchPopularMoviesUseCase
) : BaseViewModel() {
    fun teste() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Vinicius", useCase.execute().results.toString())
        }
    }
}