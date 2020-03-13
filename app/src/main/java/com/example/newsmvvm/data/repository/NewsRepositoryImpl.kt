package com.example.newsmvvm.data.repository

import com.example.newsmvvm.data.mapper.NewsMapper
import com.example.newsmvvm.data.service.GlobalService
import com.example.newsmvvm.domain.NewsDomain
import io.reactivex.Single

class NewsRepositoryImpl(
    private val globalService: GlobalService,
    private val newsMapper: NewsMapper
) : NewsRepository{
    override fun getNews(): Single<List<NewsDomain>> {
        return globalService.getNews().map {
            newsMapper.mapToListDomain(it.articles)
        }
    }

}