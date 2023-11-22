package com.example.listrepositories.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listrepositories.adapters.PullListAdapter
import com.example.listrepositories.databinding.ActivityPullRequestDetailsBinding
import com.example.listrepositories.models.Item
import com.example.listrepositories.models.PullsItem
import com.example.listrepositories.viewmodels.PullsRepositoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


private lateinit var binding: ActivityPullRequestDetailsBinding
private lateinit var viewAdapter: RecyclerView.Adapter<*>
private val listPullRequests = mutableListOf<PullsItem>()


class PullRequestDetailsActivity : AppCompatActivity() {

    private val pullsRepositoryViewModel: PullsRepositoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPullRequestDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val item = intent.getParcelableExtra<Item>(MainActivity.OWNER)

        if (item != null) {
            pullsRepositoryViewModel.gelAllPulls(item.owner.login, item.name.toString())
        }

        setupObservers()
    }

    private fun setupObservers() {
        pullsRepositoryViewModel.pulls.observe(this, Observer { pullRequest ->
            if (pullRequest == null) return@Observer
            pullRequest.map { pullItem ->
                listPullRequests.add(pullItem)
                configureListPullRequests()
            }
        })

    }

    private fun configureListPullRequests() {
        binding.rvPulls.apply {
            viewAdapter = PullListAdapter(
                context = this@PullRequestDetailsActivity,
                listPullRequests = listPullRequests
            ) { itemPull ->
                listPullDetails(itemPull)
            }
            adapter = viewAdapter
            layoutManager =
                LinearLayoutManager(
                    this@PullRequestDetailsActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
    }

    private fun listPullDetails(itemPull: PullsItem) {

    }
}