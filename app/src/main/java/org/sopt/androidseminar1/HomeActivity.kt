package org.sopt.androidseminar1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.bumptech.glide.Glide
import org.sopt.androidseminar1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        initTransactionEvent()
        initImage()

        setContentView(binding.root)
    }

    private fun initImage(){
        Glide.with(this).load("https://avatars.githubusercontent.com/u/89780201?s=200&v=4")
            .circleCrop().into(binding.ivProfile)

    }


    private fun initTransactionEvent(){
        val fragment1 = FollowRecyclerView ()
        val fragment2 = RepositoryRecyclerView()

        supportFragmentManager.beginTransaction().add(R.id.container_main, fragment1).commit()

        binding.btnFollow.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            transaction.replace(R.id.container_main, fragment1)

            transaction.commit()
        }

        binding.btnRepo.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            transaction.replace(R.id.container_main, fragment2)

            transaction.commit()
        }

    }

}

