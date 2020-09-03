package br.com.viniciuscoscia.domain.moviesdatabase.usecases

abstract class BaseUseCaseWithParams<ReturnType, in Params> {
    abstract suspend fun execute(params: Params): ReturnType
}

abstract class BaseUseCase<ReturnType> {
    abstract suspend fun execute(): ReturnType
}
