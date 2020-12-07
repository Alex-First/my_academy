package academy.alexfirst.app.fragments

import academy.alexfirst.app.R
import academy.alexfirst.app.util.ActorAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesDetails : Fragment() {

    private var recyclerView: RecyclerView? = null

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

        view.findViewById<View>(R.id.path).setOnClickListener {
            getActivity()?.onBackPressed()
        }
    }
}