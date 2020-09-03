package br.com.viniciuscoscia.domain.moviesdatabase.di

import br.com.viniciuscoscia.domain.moviesdatabase.usecases.FetchPopularMoviesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { FetchPopularMoviesUseCase(moviesDatabaseRepository = get()) }
}

val domainModule = listOf(useCaseModule)