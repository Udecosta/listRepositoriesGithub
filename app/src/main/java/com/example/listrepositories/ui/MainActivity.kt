package com.example.listrepositories.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listrepositories.adapters.RepositoriesListAdapter
import com.example.listrepositories.databinding.ActivityMainBinding
import com.example.listrepositories.models.Item
import com.example.listrepositories.models.Pulls
import com.example.listrepositories.viewmodels.UserRepositoryViewModel
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.definition.Kind


private lateinit var binding: ActivityMainBinding
private lateinit var viewAdapter: RecyclerView.Adapter<*>
private val listItemsRepository = mutableListOf<Item>()
private val listPullRequests = mutableListOf<Pulls>()

class MainActivity : AppCompatActivity() {

    private val userViewModel : UserRepositoryViewModel by viewModel()


    companion object{
        const val OWNER = "owner"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        userViewModel.getAllRepositories()
        setupObservers()
    }

    private fun configureListRepositories() {
        binding.rvRepositories.apply {
            viewAdapter = RepositoriesListAdapter(
                context = this@MainActivity,
                listRepositoriesItem = listItemsRepository
            ) { itemRepository ->
                listRepositoriesDetails(itemRepository)
            }
            adapter = viewAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun setupObservers() {
        userViewModel.repositories.observe(this, Observer { listRepositories ->
            listRepositories.map { repositories ->
                repositories.items.map { item ->
                    listItemsRepository.add(item)
                }
            }
            configureListRepositories()
        })

    }

    private fun listRepositoriesDetails(item: Item) {
            val intent = Intent(this,PullRequestDetailsActivity::class.java)
            intent.putExtra(OWNER, item)
            startActivity(intent)
       }

    }


