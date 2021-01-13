package br.com.viniciuscoscia.moviesdatabase.ui.home.moviecatalog

import android.os.Bundle
import android.view.View
import br.com.viniciuscoscia.domain.moviesdatabase.entities.Movie
import br.com.viniciuscoscia.moviesdatabase.R
import br.com.viniciuscoscia.moviesdatabase.commons.BaseFragment
import br.com.viniciuscoscia.moviesdatabase.databinding.MovieCatalogFragmentBinding
import br.com.viniciuscoscia.moviesdatabase.ui.home.moviecatalog.adapter.MovieCatalogAdapter
import kotlinx.android.synthetic.main.movie_catalog_fragment.*

class MovieCatalogFragment : BaseFragment<MovieCatalogViewModel, MovieCatalogFragmentBinding>(
    layoutRes = R.layout.movie_catalog_fragment
) {
    var adapter: MovieCatalogAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeObservers()
    }

    private fun setupRecyclerView(movies: List<Movie>) {
        adapter = MovieCatalogAdapter(movies)

        with(binding.rvMovies) {
            this.adapter = this@MovieCatalogFragment.adapter
        }
    }

    private fun initializeObservers() {
        viewModel.movies.observe(viewLifecycleOwner) { movies ->
            movies?.run {
                setMovies(this)
            }
        }

        teste.setOnClickListener {
            viewModel.getPopularMovies()
        }
    }

    private fun setMovies(movies: List<Movie>) {
        if (adapter == null) {
            setupRecyclerView(movies)
        } else {
            adapter!!.setMovies(movies)
        }
    }
}