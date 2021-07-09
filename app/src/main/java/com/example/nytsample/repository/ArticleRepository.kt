package com.example.nytsample.repository

import android.app.Application
import android.os.StrictMode
import androidx.lifecycle.MutableLiveData
import com.example.nytsample.model.ArticleModel
import com.example.nytsample.model.MostPopularArticleResponse
import com.example.nytsample.network.RetrofitInstance
import org.jsoup.Jsoup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class ArticleRepository(application: Application?) {
    private var articleModels = ArrayList<ArticleModel>()
    val mutableLiveData1 = MutableLiveData<List<ArticleModel>>()
    fun getMutableLiveData(): MutableLiveData<List<ArticleModel>> {
        val apiService = RetrofitInstance.apiService
        val call = apiService.data
        call?.enqueue(object : Callback<MostPopularArticleResponse?> {
            override fun onResponse(call: Call<MostPopularArticleResponse?>, response: Response<MostPopularArticleResponse?>) {
                val userWrapper = response.body()
                if (userWrapper != null && userWrapper.mostPopularArticles != null) {
                    articleModels = userWrapper.mostPopularArticles as ArrayList<ArticleModel>
                    mutableLiveData1.value = articleModels
                }
            }

            override fun onFailure(call: Call<MostPopularArticleResponse?>, t: Throwable) {}
        })
        return mutableLiveData1
    }

    fun getDataFromUrl(url: String?): ArticleModel {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val articleModel = ArticleModel()

        val document = Jsoup.connect(url).get()
        articleModel.title = document.title()
        articleModel.content = document.select("p").text()

        return articleModel


    }


}