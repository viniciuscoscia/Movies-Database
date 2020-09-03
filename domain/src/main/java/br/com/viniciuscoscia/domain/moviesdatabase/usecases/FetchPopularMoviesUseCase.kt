package br.com.viniciuscoscia.domain.moviesdatabase.usecases

import br.com.viniciuscoscia.domain.moviesdatabase.entities.MovieCatalog
import br.com.viniciuscoscia.domain.moviesdatabase.repositories.IMoviesDatabaseRepository

class FetchPopularMoviesUseCase(
    private val moviesDatabaseRepository: IMoviesDatabaseRepository
) : BaseUseCase<MovieCatalog>() {
    override suspend fun execute(): MovieCatalog {
        return moviesDatabaseRepository.fetchPopularMovies()
    }
}