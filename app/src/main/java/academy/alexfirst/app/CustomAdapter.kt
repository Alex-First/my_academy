package academy.alexfirst.app

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.fundamentals.data.models.Move

class CustomAdapter: RecyclerView.Adapter<ActorsViewHolder>(){

    private var moves: List<Move> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        holder.onBind(moves[position])
    }

    override fun getItemCount() =  moves.size


}

abstract class ActorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)