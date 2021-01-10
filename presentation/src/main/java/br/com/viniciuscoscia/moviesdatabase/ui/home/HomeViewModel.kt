package br.com.viniciuscoscia.moviesdatabase.ui.home

import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.viewModelScope
import br.com.viniciuscoscia.domain.moviesdatabase.usecases.FetchPopularMoviesUseCase
import br.com.viniciuscoscia.moviesdatabase.commons.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val context: Context,
    private val useCase: FetchPopularMoviesUseCase
) : BaseViewModel(), LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun test() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Batata", useCase.execute().results.toString())
        }
    }
}