package com.cua.katsuhub.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cua.katsuhub.databinding.RecentViewedAnimeBinding
import com.cua.katsuhub.model.factory.AnimeHistory
import com.cua.katsuhub.view.DetailActivity

class RecentAnimeAdapter constructor(c: Context) : RecyclerView.Adapter<RecentAnimeAdapter.Handler>() {
    private var animes:List<AnimeHistory> = emptyList()
    private val context:Context = c

    fun loadList(animeList: List<AnimeHistory>) {
        animes = animeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Handler {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecentViewedAnimeBinding.inflate(inflater, parent, false)
        return Handler(binding)
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

    override fun getItemCount(): Int {
        return animes.size
    }

    inner class Handler(private val itemBinding: RecentViewedAnimeBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(anime:AnimeHistory)
        {
            itemBinding.apply {
                itemBinding.anime = anime
                executePendingBindings()
            }
        }
    }
}
