package com.messaging.urvarassignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.messaging.urvarassignment.R
import com.messaging.urvarassignment.databinding.CommentItemBinding
import com.messaging.urvarassignment.databinding.FeedItemBinding

class CommentsAdapter (private val context: Context, private val count:Int):
    RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsAdapter.ViewHolder {
        val binding = CommentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.likeImage.setOnClickListener {
            if( holder.itemBinding.likeImage.tag.equals("unset")){
                holder.itemBinding.likeImage.setImageResource(R.drawable.notlike)
                holder.itemBinding.likeImage.setTag("set")
            }
            else{
                holder.itemBinding.likeImage.setImageResource(R.drawable.like)
                holder.itemBinding.likeImage.setTag("unset")
            }
        }

    }

    override fun getItemCount() = count

    class ViewHolder(val itemBinding: CommentItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

}