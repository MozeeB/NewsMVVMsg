package com.example.newsmvvm.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsmvvm.R
import com.example.newsmvvm.helper.view.NewsItemView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.android.ext.android.inject

class NewsFragment : Fragment() {

    private val vm:NewsViewModel by inject()
    private val newsAdapter = GroupAdapter<ViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        vm.newsState.observe(viewLifecycleOwner, observable)
        vm.getNews()

        setRv()


    }

    override fun onResume() {
        super.onResume()
        shimmerFrameLayout.startShimmer()

    }

    override fun onPause() {
        shimmerFrameLayout.stopShimmer()
        super.onPause()

    }

    private fun setRv(){
        val linearLayout = LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
        rvNews.apply {
            layoutManager = linearLayout
            adapter = newsAdapter
        }
    }

    private val observable = Observer<NewsState>{  newState ->
        when(newState){
            is NewsDataLoaded ->{
                shimmerFrameLayout.stopShimmer()
                shimmerFrameLayout.visibility = View.GONE
                rvNews.visibility = View.VISIBLE

                newsAdapter.clear()
                newState.newsDomain.map {
                    newsAdapter.add(NewsItemView(it))
                }
            }
            is NoDataLoaded ->{
                shimmerFrameLayout.visibility = View.GONE
            }
            is ErrorState ->{
                shimmerFrameLayout.visibility = View.GONE
            }
        }
    }
}