package com.example.listrepositories.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with
import com.example.listrepositories.R
import com.example.listrepositories.models.AppGlideModules
import com.example.listrepositories.models.Item

class RepositoriesListAdapter(
    val context: Context,
    var listRepositoriesItem: MutableList<Item>,
    private val onItemClickListener: ((item: Item) -> Unit)
) :
    RecyclerView.Adapter<RepositoriesListAdapter.MyViewHolder>() {

    inner class MyViewHolder(
        itemView: View,
        private val onItemClickListener: ((item: Item) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Item) {

            itemView.findViewById<TextView>(R.id.tv_name_repository).text = item.fullName
            itemView.findViewById<TextView>(R.id.tv_description_repository).text = item.description
            itemView.findViewById<TextView>(R.id.tv_forks).text = item.forks.toString()
            itemView.findViewById<TextView>(R.id.tv_stars_repository).text = item.stargazersCount.toString()
            itemView.findViewById<TextView>(R.id.tv_username).text = item.fullName
            itemView.findViewById<TextView>(R.id.tv_lastname).text = item.fullName

            with(context)
                .load(item.owner?.avatarUrl)
                .into(itemView.findViewById<ImageView>(R.id.iv_avatar_repository))

            itemView.setOnClickListener {
                onItemClickListener.invoke(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repository, parent, false)
        return MyViewHolder(itemView = view, onItemClickListener = onItemClickListener)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(item = listRepositoriesItem[position])
    }

    override fun getItemCount(): Int {
        return listRepositoriesItem.size
    }

}