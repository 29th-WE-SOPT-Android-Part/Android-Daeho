package org.sopt.androidseminar1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import org.sopt.androidseminar1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        initTransactionEvent()

        setContentView(binding.root)
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

