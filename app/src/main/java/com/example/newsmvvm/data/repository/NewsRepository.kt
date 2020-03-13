package com.example.newsmvvm.data.repository

import com.example.newsmvvm.domain.NewsDomain
import io.reactivex.Single

interface NewsRepository {
    fun getNews() : Single<List<NewsDomain>>
}