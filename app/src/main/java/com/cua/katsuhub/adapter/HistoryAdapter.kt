package com.cua.katsuhub.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cua.katsuhub.databinding.HistoryPageBinding
import com.cua.katsuhub.model.room_package.Anime
import com.cua.katsuhub.view.DetailActivity

class HistoryAdapter(c:Context): RecyclerView.Adapter<HistoryAdapter.Handler>() {
    private val context:Context = c
    private var histories:List<Anime> = emptyList()

    fun loadHistory(x:List<Anime>){
        histories = x
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter.Handler {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HistoryPageBinding.inflate(inflater, parent, false)
        return Handler(binding)
    }

    override fun getItemCount(): Int {
        return histories.size
    }

    override fun onBindViewHolder(holder: HistoryAdapter.Handler, position: Int) {
        val anime:Anime = histories[position]
        holder.apply{
            bind(anime)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.CURRENT_VIEW_PRIMARY_KEY, anime.url.toInt())
            context.startActivity(intent)
        }
    }

    class Handler(private val itemBinding: HistoryPageBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(history:Anime){
            itemBinding.apply{
                itemBinding.sejarah = history
                executePendingBindings()
            }
        }

    }
}