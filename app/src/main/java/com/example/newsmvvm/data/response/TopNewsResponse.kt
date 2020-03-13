package com.example.newsmvvm.data.response

import com.example.newsmvvm.data.model.NewsModel

data class TopNewsResponse(
    val status:String,
    val totalResults:String,
    val articles:List<NewsModel>
)