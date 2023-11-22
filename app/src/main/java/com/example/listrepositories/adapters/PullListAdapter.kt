package com.example.listrepositories.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listrepositories.R
import com.example.listrepositories.models.Item
import com.example.listrepositories.models.PullsItem

class PullListAdapter(
    val context: Context,
    private val listPullRequests: MutableList<PullsItem>,
    private val onItemClickListener: ((pulls: PullsItem) -> Unit)
) : RecyclerView.Adapter<PullListAdapter.MyViewHolder>() {
    inner class  MyViewHolder(itemView: View, private val onItemClickListener: ((pulls: PullsItem) -> Unit)): RecyclerView.ViewHolder(itemView) {

        fun bindView(pulls: PullsItem) {
            itemView.findViewById<TextView>(R.id.tv_repository_name).text = pulls.title
            itemView.findViewById<TextView>(R.id.tv_repository_description).text = pulls.body
            itemView.findViewById<TextView>(R.id.tv_user).text = pulls.user.login
            itemView.findViewById<TextView>(R.id.tv_user_fullname).text = pulls.user.type


            Glide.with(context)
                .load(pulls.user.avatarUrl)
                .into(itemView.findViewById<ImageView>(R.id.iv_owner))

            itemView.setOnClickListener {
                onItemClickListener.invoke(pulls)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pull, parent, false)
        return MyViewHolder(itemView = view, onItemClickListener = onItemClickListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(listPullRequests[position])
    }

    override fun getItemCount(): Int {
       return listPullRequests.size
    }
}