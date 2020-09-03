package br.com.viniciuscoscia.moviesdatabase.data.di

import br.com.viniciuscoscia.moviesdatabase.data.remote.api.MoviesDatabaseAPI
import br.com.viniciuscoscia.moviesdatabase.data.remote.source.MoviesRemote
import br.com.viniciuscoscia.moviesdatabase.data.remote.source.MoviesRemoteImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val MOVIES_DATABASE_BASE_URL = "https://api.themoviedb.org/3/"

val remoteDataSourceModule = module {
    factory { providesOkHttpClient() }

    single {
        createWebService<MoviesDatabaseAPI>(
            okHttpClient = get(),
            url = MOVIES_DATABASE_BASE_URL
        )
    }

    factory<MoviesRemote> { MoviesRemoteImpl(moviesDatabaseAPI = get()) }
}

fun providesOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(url)
        .client(okHttpClient)
        .build()
        .create(T::class.java)
}
