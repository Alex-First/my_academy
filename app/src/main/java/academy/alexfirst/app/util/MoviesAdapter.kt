package academy.alexfirst.app.util

import academy.alexfirst.app.R
import android.graphics.Outline
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.android.fundamentals.data.models.Move

class MoviesAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private var movies = listOf<Move>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.view_holder_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(movies[position])

    }

    override fun getItemCount(): Int = movies.size

    fun bindMovies(newMovies: List<Move>) {
        movies = newMovies
        notifyDataSetChanged()
    }
}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val ratingStars: List<ImageView> = listOf(
        itemView.findViewById(R.id.star_1),
        itemView.findViewById(R.id.star_2),
        itemView.findViewById(R.id.star_3),
        itemView.findViewById(R.id.star_4),
        itemView.findViewById(R.id.star_5)
    )

    private val image: ImageView =
        itemView.findViewById<ImageView>(R.id.image).apply { setRoundedTopCorners(this) }
    private val like: ImageView = itemView.findViewById(R.id.like)
    private val ageLimits: TextView = itemView.findViewById(R.id.age_limits)
    private val genre: TextView = itemView.findViewById(R.id.genre)
    private val reviews: TextView = itemView.findViewById(R.id.reviews)
    private val name: TextView = itemView.findViewById(R.id.movie_name)
    private val duration: TextView = itemView.findViewById(R.id.duration)

    fun onBind(movie: Movie) {
        val likeImage = if (movie.hasLike) R.drawable.red_like else R.drawable.grey_like
        showStarRating(movie.rating)

        image.background = ContextCompat.getDrawable(context, movie.image)
        like.setImageResource(likeImage)
        ageLimits.text = context.getString(R.string.movie_age_limits_text, movie.ageLimits.toString())
        genre.text = movie.genre
        reviews.text = context.getString(R.string.movie_reviews_text, movie.reviews.toString())
        name.text = movie.name
        duration.text = context.getString(R.string.movie_duration_text, movie.duration.toString())
    }

    private fun showStarRating(rating: Int) {
        for (i in ratingStars.indices){
            if (i < rating)
                ratingStars[i].setImageResource(R.drawable.red_star)
            else
                ratingStars[i].setImageResource(R.drawable.grey_star)
        }
    }

    private fun setRoundedTopCorners(image: ImageView) {
        val curveRadius = 20F

        image.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline?) {
                outline?.setRoundRect(
                    0,
                    0,
                    view.width,
                    (view.height + curveRadius).toInt(),
                    curveRadius
                )
            }
        }
        image.clipToOutline = true
    }
}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context

