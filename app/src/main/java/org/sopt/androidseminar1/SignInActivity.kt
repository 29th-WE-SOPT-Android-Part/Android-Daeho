package org.sopt.androidseminar1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.androidseminar1.databinding.SignInBinding
import retrofit2.Call
import retrofit2.Response

class SignInActivity: AppCompatActivity() {
    private lateinit var  binding: SignInBinding // 고정적인 Class 값은 아니다.
                                                        // activity_main -> ActivityMain
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SignInBinding.inflate(layoutInflater)

        binding.btnLogin.setOnClickListener {
            initNetwork()
        }
        setContentView(binding.root) // setContentView : xml을 그려주는 함수
        /*
                                                            // intent 변경

        val goHomeActivity: Intent = Intent(this, HomeActivity::class.java )

        // 로그인 버튼
        binding.btnLogin.setOnClickListener {
            initNetwork()

            if (binding.etId.text.toString().isEmpty() || binding.etPw.text.toString().isEmpty()){
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
            else {
                startActivity(goHomeActivity)
            }
        }
        */

        val goSignup: Intent = Intent(this, SignUpActivity::class.java)
        // 회원가입
        binding.btnSignup.setOnClickListener{
            startActivity(goSignup)
        }
        setContentView(binding.root)
    }
    private fun initNetwork(){
        val requestLoginData = RequestLoginData(
            id = binding.etId.text.toString(),
            password = binding.etPw.text.toString()
        )

        val call : Call<ResponseLoginData> = ServiceCreator.sampleService.postLogin(requestLoginData)

        call.enqueue(object : retrofit2.Callback<ResponseLoginData>{

            override fun onResponse (
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if (response.isSuccessful){
                    val data = response.body()?.data

                    Toast.makeText(this@SignInActivity, "${data?.name}님 반갑습니다!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignInActivity, HomeActivity::class.java) )
                }else {
                    Toast.makeText(this@SignInActivity, "로그인에 실패하셨습니다", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable){
                Log.e("NetworkTest", "error: $t")
            }
        })
    }
}

