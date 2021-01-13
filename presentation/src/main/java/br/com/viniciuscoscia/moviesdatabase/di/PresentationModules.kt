package br.com.viniciuscoscia.moviesdatabase.di

import br.com.viniciuscoscia.moviesdatabase.ui.home.moviecatalog.MovieCatalogViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module(override = true) {
    viewModel {
        MovieCatalogViewModel(androidContext(), get())
    }
}