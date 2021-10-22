package org.sopt.androidseminar1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.androidseminar1.databinding.SignInBinding

class SignInActivity: AppCompatActivity() {
    private lateinit var  binding: SignInBinding // 고정적인 Class 값은 아니다.
                                                        // activity_main -> ActivityMain
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SignInBinding.inflate(layoutInflater) // layoutInflater : xml을 불러주는 정도
        setContentView(binding.root) // setContentView : xml을 그려주는 함수


        // intent 변경
        val goSignup: Intent = Intent(this, SignUpActivity::class.java)
        val goHomeActivity: Intent = Intent(this, HomeActivity::class.java )

        // 로그인 버튼
        binding.btnLogin.setOnClickListener {
            if (binding.etId.text.toString().isEmpty() || binding.etPw.text.toString().isEmpty()){
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
            else {
                startActivity(goHomeActivity)
            }
        }

        // 회원가입
        binding.btnSignup.setOnClickListener{
            startActivity(goSignup)
        }

        setContentView(binding.root)
    }
}