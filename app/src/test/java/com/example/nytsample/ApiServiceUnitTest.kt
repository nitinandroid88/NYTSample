package com.example.nytsample


import com.example.nytsample.network.ApiConstants
import com.example.nytsample.network.RequestInterceptor
import com.example.nytsample.network.RestApiService
import okhttp3.OkHttpClient
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

@RunWith(JUnit4::class)
class ApiServiceUnitTest {
    private var apiService: RestApiService? = null

    @Before
    fun createService() {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.readTimeout(ApiConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.writeTimeout(ApiConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.addInterceptor(RequestInterceptor())
        apiService = Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build()
                .create(RestApiService::class.java)
    }

    @Test
    open fun getPopularArticles(): Unit {
        try {
            val response: Response<*> = apiService!!.data!!.execute()
            Assert.assertEquals(response.code().toLong(), 200)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}