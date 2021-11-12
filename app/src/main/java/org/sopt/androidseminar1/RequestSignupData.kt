package org.sopt.androidseminar1

import com.google.gson.annotations.SerializedName

data class RequestSignupData(
    @SerializedName("email")
    val id : String,
    val name: String,
    val password : String
)
