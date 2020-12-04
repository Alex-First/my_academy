package academy.alexfirst.app

import academy.alexfirst.app.models.Actor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter: RecyclerView.Adapter<ActorViewHolder>(){

    private var actors = listOf<Actor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
                .inflate(R.layout.view_holder_actor, parent, false)
        return ActorViewHolder(view)

    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.onBindViewHolder(actors[position])

    }

    override fun getItemCount() =  actors.size

}

class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val image: ImageView = itemView.findViewById(R.id.imageView_actor)
    private val name: TextView = itemView.findViewById(R.id.textView_name)

    fun onBindViewHolder(actor: Actor) {
        image.setImageResource(actor.image)
        name.text = actor.name
    }
}

