package com.example.newsmvvm.data.service

import com.example.newsmvvm.data.response.TopNewsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface GlobalService {

    @GET("top-headlines?country=sg&apiKey=7659de32d86f41bfbf3864f433c6252b")
    fun getNews() : Single<TopNewsResponse>

}