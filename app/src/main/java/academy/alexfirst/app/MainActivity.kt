package academy.alexfirst.app

import academy.alexfirst.app.fragments.FragmentMoviesDetails
import academy.alexfirst.app.fragments.FragmentMoviesList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private val fragmentMoviesList = FragmentMoviesList()
    private val fragmentMoviesDetails = FragmentMoviesDetails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            showFragment(fragmentMoviesList)
        }

    }

    fun showFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
                .apply {
                    add(R.id.fragments_container, fragment)
                    commit()
                }
    }

}