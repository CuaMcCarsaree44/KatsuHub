package com.cua.katsuhub.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.cua.katsuhub.databinding.TopFeaturedAnimeBinding
import com.cua.katsuhub.model.animes.DataItem
import com.cua.katsuhub.view.DetailActivity

class TopFeaturedAdapter: RecyclerView.Adapter<TopFeaturedAdapter.Handler>() {
    private var animes:List<DataItem> = emptyList()
    private lateinit var context: Context
    fun loadList(animeList: List<DataItem>, conteks: Context)
    {
        animes = animeList
        this.context = conteks
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
            intent.putExtra(DetailActivity.CURRENT_VIEW_PRIMARY_KEY, anim.id)
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