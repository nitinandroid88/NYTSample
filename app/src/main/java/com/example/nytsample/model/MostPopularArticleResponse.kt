package com.example.nytsample.model

import com.google.gson.annotations.SerializedName

class MostPopularArticleResponse {
    @SerializedName("results")
    var mostPopularArticles: List<ArticleModel>? = null

}