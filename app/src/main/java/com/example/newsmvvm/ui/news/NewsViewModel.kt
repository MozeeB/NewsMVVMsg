package com.example.newsmvvm.ui.news

import androidx.lifecycle.MutableLiveData
import com.example.newsmvvm.data.repository.NewsRepository
import com.example.newsmvvm.domain.NewsDomain
import com.example.newsmvvm.helper.RxUtils
import com.example.newsmvvm.ui.base.BaseViewModel


sealed class NewsState
data class ErrorState(val message:String?) : NewsState()
data class NewsDataLoaded(val newsDomain: List<NewsDomain>) : NewsState()
object NoDataLoaded : NewsState()
class NewsViewModel (private val repository: NewsRepository) : BaseViewModel(){

    val newsState = MutableLiveData<NewsState>()

    fun getNews(){
        compositeDisposable.add(
            repository.getNews()
                .compose(RxUtils.applySingleAsync())
                .subscribe({ result ->
                    if (result.isNotEmpty()){
                        newsState.value = NewsDataLoaded(result)
                    }
                }, this::onError)
        )
    }
    override fun onError(error: Throwable) {
        newsState.value = ErrorState(error.localizedMessage)
    }

}