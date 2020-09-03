package br.com.viniciuscoscia.domain.moviesdatabase.repositories

import br.com.viniciuscoscia.domain.moviesdatabase.entities.MovieCatalog

interface IMoviesDatabaseRepository {
    suspend fun fetchPopularMovies(): MovieCatalog
}