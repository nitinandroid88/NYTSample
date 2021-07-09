package com.example.nytsample.network

import com.example.nytsample.model.MostPopularArticleResponse
import retrofit2.Call
import retrofit2.http.GET

interface RestApiService {
    @get:GET("svc/mostpopular/v2/viewed/7.json?")
    val data: Call<MostPopularArticleResponse?>?
}