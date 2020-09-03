package br.com.viniciuscoscia.moviesdatabase.data.remote.api

import br.com.viniciuscoscia.moviesdatabase.data.BuildConfig
import br.com.viniciuscoscia.moviesdatabase.data.remote.model.movies.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesDatabaseAPI {
    @GET("$MOVIE$POPULAR")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("language") language: String = "pt-BR"
    ): MoviesResponse

    companion object {
        private const val MOVIE = "movie/"
        private const val POPULAR = "popular/"
    }
}