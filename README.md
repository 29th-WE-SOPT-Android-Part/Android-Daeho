# week4 

## **실행 예시**

<img src= "https://user-images.githubusercontent.com/69508245/141456018-1e19ad7f-b19a-4551-85c3-1c32bff98abf.png" width = "250" height="450"/>  <img src= "https://user-images.githubusercontent.com/69508245/141456057-1d738e79-39c2-4fad-be55-db98df519ee9.png" width = "250" height="450"  /> 
<img src = "https://user-images.githubusercontent.com/69508245/141456721-f28e3f58-ff0c-405e-9a42-c561eec71377.png"  width = "250" height="450"/>


## **Level 1**

**Retorfit2 를 사용하여 Login / Signup 구현하기**

- Signup Request Data class
   
```kotlin
data class RequestSignupData(
    @SerializedName("email")
    val id : String,
    val name: String,
    val password : String
)
```

- Signup Response Data class 
```kotlin
data class ResponseSignupData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : Data
){
    data class Data(
        val id : Int,
        val name : String,
        val email : String
    )
}
```

- Signup page retrofit2 적용 
```kotlin
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
```

   
## 배운 것 
1. Call / Callback 사용방법 
2. Request / Response 사용을 위한 Data class 제작 
3. Postman 사용해보기 

## 미해결 
1. 회원가입 버튼을 누르면 '회원가입 실패' Toast는 뜨지만 Response 값으로 'NULL' 이 온다.  
