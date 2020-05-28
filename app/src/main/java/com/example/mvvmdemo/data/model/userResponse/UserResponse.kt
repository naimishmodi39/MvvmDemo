package com.example.mvvmdemo.data.model.userResponse


import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("ad")
    val ad: Ad,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)