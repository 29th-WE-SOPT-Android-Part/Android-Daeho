package org.sopt.androidseminar1

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SignupService {
    @Headers("Content-Type:application/json")
    @POST("user/login")
    fun postSignup(
        @Body body : RequestSignupData
    ) : Call<ResponseSignupData>
}