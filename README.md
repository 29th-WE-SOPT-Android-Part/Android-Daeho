# week1 - SOPTHub Login Page

## **실행 예시**

<img src= "https://user-images.githubusercontent.com/69508245/136687390-fd826f0d-4b19-4582-bf0a-343ad0c67858.png" width = "230" height="380"/>  <img src= "https://user-images.githubusercontent.com/69508245/136687398-96449f34-2bde-4cc7-86fa-b60dc4679bf9.png" width = "230" height="380"/>  <img src= "https://user-images.githubusercontent.com/69508245/136687419-50c243cd-0943-4ec5-953d-d63365a366ba.png" width = "230" height="380"/> 

## **Level 1**

  **실행 예시의 Layout을 구현하고 각 Activity 기능을 구현했다.** 
  
  ### SignInActivity 
  
  - 로그인 버튼 눌렀을 때 입력값 유무로 '로그인 실패' Toast 띄우기
  ```kotlin
        binding.btnLogin.setOnClickListener {
            if (binding.etId.text.toString().isEmpty() || binding.etPw.text.toString().isEmpty()){
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
            else {
                startActivity(goHomeActivity)
            }
        }  
  ```
  
  - 회원가입 버튼 누르면 Activity 전환
  ```kotlin
          binding.btnSignup.setOnClickListener{
            startActivity(goSignup)
        }
   ```
   ### SignUpActivity 
   
   - 회원가입 버튼 눌렀을 때 입력값 유무로 '입력되지 않은 정보가 있습니다.' Toast 띄우기
   ```kotlin
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
   
   ```
   
## 배운 것 
1. 안드로이드 스튜디오 세팅법 
2. 안드로이드 App의 기본 구성 
3. Constraint Layout 컴포넌트 생성 후 커스텀 
4. binding 으로 Activity 구현하기 
5. Intent와 finish의 차이 
