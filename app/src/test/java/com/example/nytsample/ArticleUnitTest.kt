package com.example.nytsample

import com.example.nytsample.model.ArticleModel
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ArticleUnitTest {
    @Test
    fun testId() {
        val articleModel = ArticleModel().apply {
            id(1000)
        }
        assertEquals(articleModel.id, 1000)
    }

    @Test
    fun testTitle() {
        val articleModel = ArticleModel()
        with(articleModel) {
            title = "test"
        }
        assertEquals(articleModel.title, "test")
    }

    @Test
    fun testContent() {
        val articleModel = ArticleModel().apply {
            content = "test"
        }
        assertEquals(articleModel.content, "test")
    }

    @Test
    fun testPublishDate() {
        val articleModel = ArticleModel().apply {
            publishedDate = "test"
        }
        assertEquals(articleModel.publishedDate, "test")
    }

    @Test
    fun testAuthors() {
        val articleModel = ArticleModel().apply {
            authors = "test"
        }
        assertEquals(articleModel.authors, "test")
    }
}

private operator fun Long.invoke(i: Int) {

}
