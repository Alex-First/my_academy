package academy.alexfirst.app.util

import academy.alexfirst.app.R
import academy.alexfirst.app.models.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(private val clickListener: OnRecyclerItemClicked) : RecyclerView.Adapter<MovieViewHolder>() {

    private var movies = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.view_holder_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(movies[position])
        holder.itemView.setOnClickListener {
            clickListener.onClick(movies[position])
        }

    }

    override fun getItemCount(): Int = movies.size

    fun bindMovies(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }
}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val like: ImageView = itemView.findViewById(R.id.like)
    private val image: ImageView = itemView.findViewById(R.id.imageView)
    private val ageLimits: TextView = itemView.findViewById(R.id.age_limits)
//    private val ratingBar: TextView = itemView.findViewById(R.id.ratingBar)
    private val reviews: TextView = itemView.findViewById(R.id.reviews)
    private val timeMovie: TextView = itemView.findViewById(R.id.timeMovie)
    private val tag: TextView = itemView.findViewById(R.id.tag)
    private val name: TextView = itemView.findViewById(R.id.name)

    fun onBind(movie: Movie) {
        val likeImage = if (movie.hasLike) R.drawable.grey_like else R.drawable.grey_like

        like.setImageResource(R.drawable.grey_like)
        image.background = ContextCompat.getDrawable(context, movie.image)
        ageLimits.text = context.getString(R.string.age_limits)
        //ratingBar.setImageResource(R.drawable.grey_like)
        reviews.text = context.getString(R.string.reviews)
        timeMovie.text = context.getString(R.string.time)
        tag.text = context.getString(R.string.tag)
        name.text = context.getString(R.string.text_view_name)

    }

}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context

interface OnRecyclerItemClicked {
    fun onClick(movie: Movie)
}