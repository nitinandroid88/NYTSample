package com.example.nytsample.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.nytsample.R
import com.example.nytsample.databinding.ArticleDetailsFragmentBinding
import com.example.nytsample.model.ArticleModel
import com.example.nytsample.viewmodel.DetailViewModel

class DetailFragment : Fragment() {
    internal lateinit var fragmentArticleDetailsBinding: ArticleDetailsFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val detailViewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        val url = DetailFragmentArgs.fromBundle(requireArguments()).articleUrl
        detailViewModel.url = url
        detailViewModel.loadArticleDetails()
        detailViewModel.getarticleModelMutableLiveData().observe(this, Observer { articleModel: ArticleModel? ->
            if (null != articleModel) {
                fragmentArticleDetailsBinding!!.articleDetailViewModel = articleModel
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentArticleDetailsBinding = DataBindingUtil.inflate(
                inflater, R.layout.article_details_fragment, container, false)
        return this.fragmentArticleDetailsBinding.getRoot()
    }
}