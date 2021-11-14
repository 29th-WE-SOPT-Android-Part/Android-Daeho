package org.sopt.androidseminar1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar1.databinding.FragmentFollowRecyclerViewBinding
import org.sopt.androidseminar1.databinding.FragmentRepositoryRecyclerViewBinding


class RepositoryRecyclerView : Fragment() {
    private lateinit var repositoryAdapter: RepositoryAdapter

    private var _binding: FragmentRepositoryRecyclerViewBinding? = null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryRecyclerViewBinding.inflate(layoutInflater,container,false)

        initAdapter()

        return binding.root
    }

    private fun initAdapter(){
        repositoryAdapter = RepositoryAdapter()

        binding.rvRepo.adapter = repositoryAdapter

        repositoryAdapter.userList.addAll(
            listOf(
                RepoData(name = "안드로이드\n과제 레포지토리", explanation = "안드로이드 파트 과제"),
                RepoData(name = "ios 과제\n레포지토리", explanation = "ios 파트 과제"),
                RepoData(name = "서버 과제\n레포지토리", explanation = "서버 파트 과제"),
                RepoData(name = "웹 과제\n레포지토리", explanation = "웹 파트 과제")
            )
        )

        repositoryAdapter.notifyDataSetChanged()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




