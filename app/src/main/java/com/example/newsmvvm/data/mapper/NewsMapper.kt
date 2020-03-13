package com.example.newsmvvm.data.mapper

import com.example.newsmvvm.data.model.NewsModel
import com.example.newsmvvm.domain.NewsDomain

class NewsMapper : BaseMapper<NewsModel, NewsDomain> {
    override fun mapToDomain(model: NewsModel): NewsDomain {
        return NewsDomain(
            model.author,
            model.title,
            model.description,
            model.url,
            model.urlToImage,
            model.publishedAt,
            model.content
        )
    }

    override fun mapToModel(domain: NewsDomain): NewsModel {
       return NewsModel(
           domain.author,
           domain.title,
           domain.description,
           domain.url,
           domain.urlToImage,
           domain.publishedAt,
           domain.content
       )
    }
}