package academy.alexfirst.app.fragments

import academy.alexfirst.app.R
import academy.alexfirst.app.data.ActorsDataSource
import academy.alexfirst.app.models.Movie
import academy.alexfirst.app.util.ActorAdapter
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FragmentMoviesDetails : Fragment() {

    private var listener: MovieDetailsFragmentClickListener? = null
    private var recyclerView: RecyclerView? = null
    private var movie: Movie? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView_details)
        recyclerView?.adapter = ActorAdapter()
        recyclerView?.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        view.findViewById<TextView>(R.id.name)
                .apply { text = movie?.name }
        view.findViewById<TextView>(R.id.tag)
                .apply { text = movie?.genre }
        view.findViewById<TextView>(R.id.age_limits)
                .apply { text = context.getString(R.string.age_limits) }
        view.findViewById<TextView>(R.id.reviews)
                .apply { text = context.getString(R.string.reviews)}
        view.findViewById<TextView>(R.id.back)
                .setOnClickListener {
                    listener?.backToMoviesListFragment() }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MovieDetailsFragmentClickListener) listener = context
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    override fun onDetach() {
        listener = null
        recyclerView = null
        super.onDetach()
    }

    interface MovieDetailsFragmentClickListener {
        fun backToMoviesListFragment()
    }

    private fun updateData() {
        (recyclerView?.adapter as? ActorAdapter)?.apply {
            bindMovies(ActorsDataSource().getActors())
        }
    }

    companion object{
        private const val PARAM_MOVIE = "movie_movie"

        fun newInstance(movie: Movie): FragmentMoviesDetails {
            val fragment = FragmentMoviesDetails()
            val args = Bundle()
            //args.putParcelable(PARAM_MOVIE, movie)
            fragment.arguments = args
            return fragment
        }
    }

}