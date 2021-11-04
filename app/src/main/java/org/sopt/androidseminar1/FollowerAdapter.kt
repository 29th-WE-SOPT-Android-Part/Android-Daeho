package org.sopt.androidseminar1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar1.databinding.ItemFollowListBinding

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {
    val userList = mutableListOf<UserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): FollowerViewHolder {
        val binding = ItemFollowListBinding.inflate(LayoutInflater.from(parent.context),
        parent, false)

        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(userList[position])
    }


    override fun getItemCount(): Int = userList.size

    class FollowerViewHolder (private val binding: ItemFollowListBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun onBind(data : UserData){
            binding.tvName.text = data.name
            binding.tvIntroduce.text = data.introduction
        }
    }
}