package academy.alexfirst.app.fragments

import academy.alexfirst.app.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentMoviesList: Fragment(){

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.imageView).
            setOnClickListener{
                jumpFragmentMovieDetails()
            }
    }

    fun jumpFragmentMovieDetails(){
        val supportFragmentManager = activity?.supportFragmentManager
        supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragments_container, FragmentMoviesDetails())
                ?.addToBackStack("FragmentMoviesDetails")
                ?.commit()
    }
}

// RV должен отображать по 2 колонки


