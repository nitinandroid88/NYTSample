package com.example.nytsample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nytsample.R
import com.example.nytsample.adapter.ArticleListAdapter
import com.example.nytsample.adapter.OnItemClickListener
import com.example.nytsample.model.ArticleModel
import com.example.nytsample.viewmodel.ArticleListViewModel

class ArticleListFragment : Fragment() {
    var recyclerView: RecyclerView? = null
    internal lateinit var view: View
    var articleListAdapter: ArticleListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val articleListViewModel = ViewModelProviders.of(this).get(ArticleListViewModel::class.java)
        articleListViewModel.data.observe(this, Observer { articleModelListList -> setRecyclerView(articleModelListList) })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.list_fragment, container, false)
        recyclerView = view.findViewById(R.id.rv)
        return view
    }

    private fun setRecyclerView(articleModelList: List<ArticleModel>?) {
        articleListAdapter = ArticleListAdapter(articleModelList, object : OnItemClickListener {
            override fun onItemClick(item: ArticleModel?) {
                val args = Bundle()
                args.putString("articleUrl", item?.url)
                Navigation.findNavController(view!!).navigate(R.id.action_listFragment_to_detailFragment, args)
            }
        }
        )
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.adapter = articleListAdapter
        articleListAdapter!!.notifyDataSetChanged()
    }
}