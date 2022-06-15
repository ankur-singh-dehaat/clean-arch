package com.example.cleanarchitecture.presentation.ui.main.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.databinding.NewsItemBinding

class NewsViewHolder(
    private val binding: NewsItemBinding,
    private val clickListener: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) clickListener(adapterPosition)
        }
    }

    fun bind(title: String) = with(binding) {
        newsTitle.text = title
    }
}
