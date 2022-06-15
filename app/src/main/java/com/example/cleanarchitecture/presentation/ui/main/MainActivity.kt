package com.example.cleanarchitecture.presentation.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.presentation.ui.details.DetailActivity
import com.example.cleanarchitecture.presentation.ui.main.adapters.NewsAdapter
import com.example.cleanarchitecture.utils.activityViewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by activityViewBinding(ActivityMainBinding::inflate)

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = NewsAdapter {
            startActivity(
                DetailActivity.Companion.Args(it).getIntent(this)
            )
        }
        binding.newsRecyclerView.adapter = adapter
        viewModel.getTopNews()
        addObservers()
        addCollectors()
    }

    private fun addObservers() = with(viewModel) {
        topNews.observe(this@MainActivity, ::updateAdapter)
    }

    private fun addCollectors() = lifecycleScope.launch {
        viewModel.loadingProgressIndicator.collectLatest {
            if (it) {
                updateAdapter()
                binding.progressCircular.isVisible = true
            } else {
                binding.progressCircular.isGone = true
            }
        }
    }

    private fun updateAdapter(list: List<String> = emptyList()) = adapter.apply {
        newsList = list
        notifyDataSetChanged()
    }
}
