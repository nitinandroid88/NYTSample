package com.example.nytsample.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    private var retrofit: Retrofit? = null
    val apiService: RestApiService
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(ApiConstants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient)
                        .build()
            }
            return retrofit!!.create(RestApiService::class.java)
        }

    private val httpClient: OkHttpClient
        private get() {
            val okHttpClient = OkHttpClient.Builder()
            okHttpClient.connectTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
            okHttpClient.readTimeout(ApiConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS)
            okHttpClient.writeTimeout(ApiConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            okHttpClient.addInterceptor(RequestInterceptor())
            return okHttpClient.build()
        }
}