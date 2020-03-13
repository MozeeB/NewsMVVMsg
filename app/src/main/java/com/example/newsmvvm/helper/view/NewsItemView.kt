package com.example.newsmvvm.helper.view

import com.example.newsmvvm.R
import com.example.newsmvvm.domain.NewsDomain
import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_news.view.*

class NewsItemView (private val newsDomain: NewsDomain) : Item(){
    override fun bind(viewHolder: ViewHolder, position: Int) {
        val image = viewHolder.itemView.thumbnailNewsFragmentIV
        val title = viewHolder.itemView.judulNewsFragmentTV

        Picasso.get().load(newsDomain.urlToImage).into(image)
        title.text = newsDomain.title

    }

    override fun getLayout(): Int = R.layout.item_news

}