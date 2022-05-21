package com.messaging.urvarassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.messaging.urvarassignment.adapters.CommentsAdapter
import com.messaging.urvarassignment.databinding.ActivityCommentBinding

class CommentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
       val url=intent.getStringExtra("key")
        Glide.with(this).load(url).placeholder(R.drawable.loadimages).into(binding.post)
        binding.back.setOnClickListener {
            finish()
        }
        val recyclerView=binding.commentecyclerview
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=CommentsAdapter(this,10)
    }
}