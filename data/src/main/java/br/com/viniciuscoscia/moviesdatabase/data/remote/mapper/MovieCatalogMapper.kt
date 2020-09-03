package br.com.viniciuscoscia.moviesdatabase.data.remote.mapper

import br.com.viniciuscoscia.domain.moviesdatabase.entities.Movie
import br.com.viniciuscoscia.domain.moviesdatabase.entities.MovieCatalog
import br.com.viniciuscoscia.moviesdatabase.data.remote.model.movies.MoviesResponse

object MovieCatalogMapper {
    fun map(movieCatalog: MoviesResponse): MovieCatalog = MovieCatalog(
        page = movieCatalog.page,
        results = movieCatalog.results.map {
            Movie(
                id = it.id,
                originalLanguage = it.originalLanguage,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                video = it.video,
                voteAverage = it.voteAverage
            )
        },
        totalPages = movieCatalog.totalPages,
        totalResults = movieCatalog.totalResults
    )
}