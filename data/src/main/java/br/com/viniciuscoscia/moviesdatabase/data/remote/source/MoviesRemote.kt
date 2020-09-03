package br.com.viniciuscoscia.moviesdatabase.data.remote.source

import br.com.viniciuscoscia.moviesdatabase.data.remote.api.MoviesDatabaseAPI
import br.com.viniciuscoscia.moviesdatabase.data.remote.model.movies.MoviesResponse

interface MoviesRemote {
    suspend fun fetchPopularMovies(): MoviesResponse
}

class MoviesRemoteImpl(private val moviesDatabaseAPI: MoviesDatabaseAPI) : MoviesRemote {
    override suspend fun fetchPopularMovies(): MoviesResponse {
        return moviesDatabaseAPI.getPopularMovies()
    }
}