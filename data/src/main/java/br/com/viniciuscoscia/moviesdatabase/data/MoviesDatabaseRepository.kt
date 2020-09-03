package br.com.viniciuscoscia.moviesdatabase.data

import br.com.viniciuscoscia.domain.moviesdatabase.entities.MovieCatalog
import br.com.viniciuscoscia.domain.moviesdatabase.repositories.IMoviesDatabaseRepository
import br.com.viniciuscoscia.moviesdatabase.data.remote.api.MoviesDatabaseAPI
import br.com.viniciuscoscia.moviesdatabase.data.remote.mapper.MovieCatalogMapper

class MoviesDatabaseRepository(
    private val moviesDatabaseAPI: MoviesDatabaseAPI
) : IMoviesDatabaseRepository {

    override suspend fun fetchPopularMovies(): MovieCatalog {
        return MovieCatalogMapper.map(moviesDatabaseAPI.getPopularMovies())
    }
}