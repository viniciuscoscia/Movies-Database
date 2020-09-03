package br.com.viniciuscoscia.domain.moviesdatabase.entities

import java.io.Serializable

data class MovieCatalog(
    val page: Int = 0,
    val results: List<Movie> = listOf(),
    val totalPages: Int = 0,
    val totalResults: Int = 0
) : Serializable

data class Movie(
    val id: Int = 0,
    val originalLanguage: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val posterPath: String = "",
    val releaseDate: String = "",
    val title: String = "",
    val video: Boolean = false,
    val voteAverage: Double = 0.0,
) : Serializable