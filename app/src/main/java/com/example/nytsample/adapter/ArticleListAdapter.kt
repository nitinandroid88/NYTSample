package com.example.nytsample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nytsample.R
import com.example.nytsample.adapter.ArticleListAdapter.ArticleViewHolder
import com.example.nytsample.databinding.RowItemBinding
import com.example.nytsample.model.ArticleModel

class ArticleListAdapter(private val articleModelList: List<ArticleModel>?, private val listener: OnItemClickListener) : RecyclerView.Adapter<ArticleViewHolder>() {
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articleModel = articleModelList!![position]
        holder.adapterRowItemBinding.mostpopular = articleModel
        holder.bind(articleModel, listener)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ArticleViewHolder {
        val adapterRowItemBinding: RowItemBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.context),
                R.layout.row_item, viewGroup, false)
        return ArticleViewHolder(adapterRowItemBinding)
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    override fun getItemCount(): Int {
        return if (articleModelList != null && articleModelList.size > 0) {
            articleModelList.size
        } else {
            0
        }
    }

    inner class ArticleViewHolder(val adapterRowItemBinding: RowItemBinding) : RecyclerView.ViewHolder(adapterRowItemBinding.root) {
        fun bind(item: ArticleModel?, listener: OnItemClickListener) {
            itemView.setOnClickListener {
                try {
                    listener.onItemClick(item)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

    }

}