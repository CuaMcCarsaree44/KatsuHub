package com.cua.katsuhub.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cua.katsuhub.databinding.FragSearchListBinding
import com.cua.katsuhub.model.animes.DataItem
import com.cua.katsuhub.view.DetailActivity

class AnimeSearchListAdapter constructor(c: Context): RecyclerView.Adapter<AnimeSearchListAdapter.Handler>() {
    private var animes:List<DataItem> = emptyList()
    private val context:Context = c
    fun loadList(animeList: List<DataItem>) {
        animes = animeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeSearchListAdapter.Handler {
        val inflater = LayoutInflater.from(parent.context)
        val binding =  FragSearchListBinding.inflate(inflater, parent, false)
        return Handler(binding)
    }

    override fun getItemCount(): Int {
        return animes.size
    }

    override fun onBindViewHolder(holder: Handler, position: Int) {
        val anim = animes[position]
        holder.apply{
            bind(anim)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.CURRENT_VIEW_PRIMARY_KEY, anim.id.toInt())
            context.startActivity(intent)
        }
    }

    inner class Handler(private val itemBinding: FragSearchListBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(anime: DataItem)
        {
            itemBinding.apply {
                itemBinding.animelist = anime
                executePendingBindings()
            }
        }
    }
}