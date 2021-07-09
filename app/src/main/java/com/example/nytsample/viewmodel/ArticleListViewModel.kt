package com.example.nytsample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.nytsample.model.ArticleModel
import com.example.nytsample.repository.ArticleRepository

class ArticleListViewModel(application: Application) : AndroidViewModel(application) {
    private val articleRepository: ArticleRepository
    val data: LiveData<List<ArticleModel>>
        get() = articleRepository.getMutableLiveData()

    init {
        articleRepository = ArticleRepository(application)
    }
}