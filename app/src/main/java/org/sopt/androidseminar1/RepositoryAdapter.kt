package org.sopt.androidseminar1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar1.databinding.ItemRepositoryGridBinding

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {
    val userList = mutableListOf<RepoData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): RepositoryViewHolder {
        val binding = ItemRepositoryGridBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    override fun getItemCount(): Int = userList.size


    class RepositoryViewHolder(private val binding: ItemRepositoryGridBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: RepoData) {
            binding.tvRepo.text = data.name
            binding.tvRepoEx.text = data.explanation
        }
    }
}

