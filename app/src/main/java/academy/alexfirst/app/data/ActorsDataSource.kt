package academy.alexfirst.app.data

import academy.alexfirst.app.R
import academy.alexfirst.app.models.Actor

class ActorsDataSource {
    fun getActors(): List<Actor>{
        return listOf(
            Actor(R.drawable.robert, "Robert Downey Jr."),
            Actor(R.drawable.mark, "Mark Ruffalo"),
            Actor(R.drawable.chris, "Chris Evans"),
            Actor(R.drawable.chris2, "Chris Hemsworth"),
            Actor(R.drawable.robert, "Robert Downey Jr."),
            Actor(R.drawable.mark, "Mark Ruffalo"),
            Actor(R.drawable.chris, "Chris Evans"),
            Actor(R.drawable.chris2, "Chris Hemsworth")
        )
    }
}