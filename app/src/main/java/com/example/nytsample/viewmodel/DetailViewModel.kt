package com.example.nytsample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.nytsample.model.ArticleModel
import com.example.nytsample.repository.ArticleRepository

class DetailViewModel(application: Application) : AndroidViewModel(application) {
    private val articleRepository: ArticleRepository?
    var url: String? = null
    private var articleModelMutableLiveData = MutableLiveData<ArticleModel>()
    fun getarticleModelMutableLiveData(): MutableLiveData<ArticleModel> {
        return articleModelMutableLiveData
    }

    fun setarticleModelMutableLiveData(articleModelMutableLiveData: MutableLiveData<ArticleModel>) {
        this.articleModelMutableLiveData = articleModelMutableLiveData
    }

    fun loadArticleDetails() {
        if (null != articleRepository) {
            try {
                articleModelMutableLiveData.value = articleRepository.getDataFromUrl(url)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    init {
        articleRepository = ArticleRepository(application)
    }
}