package org.sopt.androidseminar1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.androidseminar1.databinding.SignUpBinding
import retrofit2.Call
import retrofit2.Response


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: SignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SignUpBinding.inflate(layoutInflater)

        binding.btnSignupComplete.setOnClickListener {
            initNetwork()
        }
        setContentView(binding.root)
        /*
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
        */
    }
    private fun initNetwork(){
        val requestSignupData = RequestSignupData(
            id = binding.etSignupId.text.toString(),
            password = binding.etSignupPw.text.toString(),
            name = binding.etSignupName.text.toString()
        )

        val call : Call<ResponseSignupData> = SignupCreator.signupService.postSignup(requestSignupData)

        call.enqueue(object : retrofit2.Callback<ResponseSignupData>{
            override fun onResponse(
                call: Call<ResponseSignupData>,
                response: Response<ResponseSignupData>
            ) {
                if (response.isSuccessful){
                    val data = response.body()?.data
                    Toast.makeText(this@SignUpActivity, "${data?.name}님 회원가입에 성공하셨습니다", Toast.LENGTH_SHORT).show()
                    finish()
                }else {
                    Toast.makeText(this@SignUpActivity, "회원가입에 실패하셨습니다", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseSignupData>, t: Throwable) {
                Log.e("NetworkTest", "error: $t")
            }

        })
    }


}



