package org.sopt.androidseminar1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.androidseminar1.databinding.SignUpBinding


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: SignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSignupComplete.setOnClickListener {
                val userName: String= etSignupName.text.toString()
                val userId: String = etSignupId.text.toString()
                val userPw: String = etSignupPw.text.toString()

                if (userName.isEmpty() || userId.isEmpty() || userPw.isEmpty()){
                    Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT ).show()
                }
                else {
                    finish()
                }
            }
        }
    }
}