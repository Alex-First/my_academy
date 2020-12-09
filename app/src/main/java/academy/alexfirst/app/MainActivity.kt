package academy.alexfirst.app

import academy.alexfirst.app.fragments.FragmentMoviesDetails
import academy.alexfirst.app.fragments.FragmentMoviesList
import academy.alexfirst.app.models.Movie
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),
        FragmentMoviesList.MoviesListFragmentClickListener,
        FragmentMoviesDetails.MovieDetailsFragmentClickListener {

    private var fragmentMoviesList: FragmentMoviesList? = null
    private var fragmentMoviesDetails: FragmentMoviesDetails? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            fragmentMoviesList = FragmentMoviesList()
            fragmentMoviesList?.apply {
                supportFragmentManager.beginTransaction()
                        .add(R.id.fragments_container, this, MOVIES_LIST_FRAGMENT_FLAG)
                        .commit()
            }
        }  else {
            fragmentMoviesList = supportFragmentManager
                    .findFragmentByTag(MOVIES_LIST_FRAGMENT_FLAG) as? FragmentMoviesList

            fragmentMoviesDetails = supportFragmentManager
                    .findFragmentByTag(MOVIE_DETAILS_FRAGMENT_FLAG) as? FragmentMoviesDetails
        }

    }

    override fun moveToMovieDetailsFragment(movie: Movie) {
        fragmentMoviesDetails = FragmentMoviesDetails.newInstance(movie)
        fragmentMoviesDetails?.apply {
            supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.fragments_container, this, MOVIE_DETAILS_FRAGMENT_FLAG)
                    .commit()
        }
    }

    override fun backToMoviesListFragment() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        }
    }

    companion object {
        const val MOVIES_LIST_FRAGMENT_FLAG = "listFragment"
        const val MOVIE_DETAILS_FRAGMENT_FLAG = "detailsFragment"
    }

}