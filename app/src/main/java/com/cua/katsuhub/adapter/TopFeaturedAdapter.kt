package com.cua.katsuhub.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.cua.katsuhub.databinding.TopFeaturedAnimeBinding
import com.cua.katsuhub.model.animes.DataItem
import com.cua.katsuhub.view.DetailActivity

class TopFeaturedAdapter constructor(c:Context): RecyclerView.Adapter<TopFeaturedAdapter.Handler>() {
    private var animes:List<DataItem> = emptyList()
    private val context:Context = c
    fun loadList(animeList: List<DataItem>) {
        animes = animeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopFeaturedAdapter.Handler {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopFeaturedAnimeBinding.inflate(inflater, parent, false)
        return Handler(binding)
    }

    override fun getItemCount(): Int {
        return animes.size
    }

    override fun onBindViewHolder(holder: TopFeaturedAdapter.Handler, position: Int) {
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

    inner class Handler(private val itemBinding: TopFeaturedAnimeBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(anime:DataItem)
        {
            itemBinding.apply {
                itemBinding.anime = anime
                executePendingBindings()
            }
        }
    }
}