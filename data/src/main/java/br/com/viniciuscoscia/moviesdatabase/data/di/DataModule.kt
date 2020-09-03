package br.com.viniciuscoscia.moviesdatabase.data.di

import br.com.viniciuscoscia.domain.moviesdatabase.repositories.IMoviesDatabaseRepository
import br.com.viniciuscoscia.moviesdatabase.data.MoviesDatabaseRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule = module {
    factory<IMoviesDatabaseRepository> {
        MoviesDatabaseRepository(
            moviesDatabaseAPI = get()
        )
    }
}

val dataModules: List<Module> = listOf(remoteDataSourceModule, repositoryModule, cacheDataModule)