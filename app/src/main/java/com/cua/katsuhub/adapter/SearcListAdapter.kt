package com.cua.katsuhub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cua.katsuhub.databinding.ListSearchItemBinding
import com.cua.katsuhub.model.Character
import com.cua.katsuhub.model.CharacterData

class SearcListAdapter : RecyclerView.Adapter<SearcListAdapter.ViewHolder>(){

    private var chars: List<CharacterData> = emptyList()

    fun loadChars(newItems: List<CharacterData>) {
        chars = newItems
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = chars.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListSearchItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val char = chars[position].character
        holder.apply {
            bind(char)
        }
    }

    class ViewHolder(
        private val binding: ListSearchItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Character) {
            binding.apply {
                character = item
                executePendingBindings()
            }
        }
    }
}