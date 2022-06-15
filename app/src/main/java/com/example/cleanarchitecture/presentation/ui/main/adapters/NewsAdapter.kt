package com.example.cleanarchitecture.presentation.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.databinding.NewsItemBinding

class NewsAdapter(
    var newsList: List<String> = emptyList(),
    private val clickListener: (String) -> Unit
) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = NewsViewHolder(
        NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    ) {
        clickListener(newsList[it])
    }

    override fun onBindViewHolder(
        holder: NewsViewHolder,
        position: Int
    ) = holder.bind(newsList[position])

    override fun getItemCount() = newsList.size
}
