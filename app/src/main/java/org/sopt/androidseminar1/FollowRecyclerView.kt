package org.sopt.androidseminar1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidseminar1.databinding.FragmentFollowRecyclerViewBinding


class FollowRecyclerView : Fragment() {
    private lateinit var followerAdapter: FollowerAdapter

    private var _binding: FragmentFollowRecyclerViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFollowRecyclerViewBinding.inflate(layoutInflater, container, false)

        initAdapter()

        return binding.root
    }

    private fun initAdapter(){
        followerAdapter = FollowerAdapter()

        binding.rvFollower.adapter = followerAdapter

        followerAdapter.userList.addAll(
            listOf(
                UserData(name = "김대호", introduction = "나는 김대호"),
                UserData(name = "남대호", introduction = "나는 남대호"),
                UserData(name = "담대호", introduction = "나는 담대호")
            )
        )

        followerAdapter.notifyDataSetChanged()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}