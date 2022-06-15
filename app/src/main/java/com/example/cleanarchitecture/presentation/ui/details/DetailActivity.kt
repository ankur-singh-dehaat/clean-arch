package com.example.cleanarchitecture.presentation.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecture.ActivityArgs
import com.example.cleanarchitecture.databinding.ActivityDetailBinding
import com.example.cleanarchitecture.utils.activityViewBinding

class DetailActivity : AppCompatActivity() {

    private val binding by activityViewBinding(ActivityDetailBinding::inflate)
    private lateinit var args: Args

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        args = from(intent.extras)

        actionBar.apply {
            title = args.title
        }
    }


    companion object {
        const val TITLE_TAG = "TITLE_TAG"

        private fun from(bundle: Bundle?) = Args(
            title = bundle?.getString(TITLE_TAG) ?: ""
        )

        data class Args(
            val title: String
        ) : ActivityArgs {

            override fun getIntent(context: Context) = Intent(
                context,
                DetailActivity::class.java
            ).apply {
                putExtra(TITLE_TAG, title)
            }

        }
    }
}
