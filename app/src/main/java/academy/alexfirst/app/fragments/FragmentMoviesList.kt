package academy.alexfirst.app.fragments

import academy.alexfirst.app.R
import academy.alexfirst.app.data.MoviesDataSource
import academy.alexfirst.app.models.Movie
import academy.alexfirst.app.util.MoviesAdapter
import academy.alexfirst.app.util.OnRecyclerItemClicked
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesList : Fragment() {

    private var listener: MoviesListFragmentClickListener? = null
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView_list)
        recyclerView.adapter = MoviesAdapter(clickListener)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        //recyclerView.addItemDecoration(MoviesItemDecoration(30, 2))

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MoviesListFragmentClickListener) listener = context
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    private fun updateData() {
        (recyclerView.adapter as? MoviesAdapter)?.apply {
            bindMovies(MoviesDataSource().getMovies())
        }
    }

    private val clickListener = object : OnRecyclerItemClicked {
        override fun onClick(movie: Movie) {
            listener?.moveToMovieDetailsFragment(movie)
        }
    }

    interface MoviesListFragmentClickListener {
        fun moveToMovieDetailsFragment(movie: Movie)
    }
}





