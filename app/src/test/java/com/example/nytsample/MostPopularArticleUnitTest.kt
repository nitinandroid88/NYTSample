package com.example.nytsample


import com.example.nytsample.model.ArticleModel
import com.example.nytsample.model.MostPopularArticleResponse
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@RunWith(JUnit4::class)
class MostPopularArticleUnitTest {
    @Test
    fun testPopularArticles() {
        val articleEntities: MutableList<ArticleModel> = ArrayList<ArticleModel>()
        val articleModel1 = ArticleModel()
        val articleModel2 = ArticleModel()
        articleEntities.add(articleModel1)
        articleEntities.add(articleModel2)
        val popularArticleResponse = MostPopularArticleResponse().apply {
            mostPopularArticles = articleEntities
        }
        assertEquals(popularArticleResponse.mostPopularArticles?.size, 2)
    }
}