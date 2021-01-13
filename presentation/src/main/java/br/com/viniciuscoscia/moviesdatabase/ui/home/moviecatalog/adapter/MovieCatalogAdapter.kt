package br.com.viniciuscoscia.moviesdatabase.ui.home.moviecatalog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.viniciuscoscia.domain.moviesdatabase.entities.Movie
import br.com.viniciuscoscia.moviesdatabase.databinding.MovieLayoutBinding

class MovieCatalogAdapter(
    movies: List<Movie>
) : RecyclerView.Adapter<MovieCatalogAdapter.ViewHolder>() {

    private var _movies = movies

    fun setMovies(movies: List<Movie>) {
        notifyDataSetChanged()
        _movies = movies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(_movies[position])
    }

    override fun getItemCount(): Int = _movies.size

    class ViewHolder(
        private val movieLayoutBinding: MovieLayoutBinding
    ) : RecyclerView.ViewHolder(movieLayoutBinding.root) {

        fun bind(movie: Movie) {
            movieLayoutBinding.movie = movie
            movieLayoutBinding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MovieLayoutBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}