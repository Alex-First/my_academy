package academy.alexfirst.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.fundamentals.data.models.Move

class CustomAdapter: RecyclerView.Adapter<ActorsViewHolder>(){

    private var moves: List<Move> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
                .inflate(R.layout.view_holder_actor, parent, false)
        return ActorsViewHolder(view)

    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
       // holder.onBindViewHolder(moves[position])

    }

    override fun getItemCount() =  moves.size

}

abstract class ActorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

/*private val RecyclerView.ViewHolder.context
    get() = this.itemView.context*/

