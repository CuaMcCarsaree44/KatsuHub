package com.cua.katsuhub.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecentAnimeAdapter : RecyclerView.Adapter<RecentAnimeAdapter.Handler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Handler {
        val handler:Handler = Handler(parent)

        return handler
    }

    override fun onBindViewHolder(holder: Handler, position: Int) {

    }

    override fun getItemCount(): Int {
        return 0
    }

    inner class Handler(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}
