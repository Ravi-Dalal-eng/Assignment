package com.messaging.urvarassignment.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.messaging.urvarassignment.R
import com.messaging.urvarassignment.adapters.FeedAdapter
import com.messaging.urvarassignment.databinding.FragmentCharchaBinding
import com.messaging.urvarassignment.util.MyViewModel


class CharchaFragment : Fragment() {
    private var _binding:FragmentCharchaBinding?=null
    private val binding get() = _binding!!
   private lateinit var manager: LinearLayoutManager
    private lateinit var myViewModel: MyViewModel
    private  val list= ArrayList<String>()
    private lateinit var recyclerView:RecyclerView
    private var isScrolling = false
    var currentItems = 0
    private var totalItems:Int = 0
    private var scrollOutItems:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_charcha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding= FragmentCharchaBinding.bind(view)
         myViewModel=ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
        recyclerView=binding.recyclerView
        manager=LinearLayoutManager(requireContext())
        recyclerView.layoutManager=manager
        recyclerView.adapter=FeedAdapter(requireActivity(),list)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                currentItems = manager.getChildCount()
                totalItems = manager.getItemCount()
                scrollOutItems = manager.findFirstVisibleItemPosition()
                if (isScrolling && currentItems + scrollOutItems == totalItems) {
                    isScrolling = false
                    getFeed()
                }
            }
        })


        getFeed()
    }

    private fun getFeed() {
        binding.progressBar.visibility=View.VISIBLE
        myViewModel.getFeeds().observe(viewLifecycleOwner){
            list.addAll(it)
            recyclerView.adapter?.notifyDataSetChanged()
            binding.progressBar.visibility=View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}