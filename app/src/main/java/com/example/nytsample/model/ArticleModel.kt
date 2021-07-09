package com.example.nytsample.model

import com.google.gson.annotations.SerializedName

class ArticleModel {
    @SerializedName("id")
    var id: Long = 0

    @SerializedName("title")
    var title: String? = null

    @SerializedName("byline")
    var authors: String? = null

    @SerializedName("published_date")
    var publishedDate: String? = null

    @SerializedName("url")
    var url: String? = null
    var content: String? = null

}