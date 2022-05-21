package com.messaging.urvarassignment.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.messaging.urvarassignment.CommentActivity
import com.messaging.urvarassignment.R
import com.messaging.urvarassignment.databinding.FeedItemBinding

class FeedAdapter (private val context:Context,private val list:List<String>):
    RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedAdapter.ViewHolder {
        val binding = FeedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(list[position])
            .placeholder(R.drawable.loadimages).into(holder.itemBinding.post)
        holder.itemBinding.likeImage.setOnClickListener {
            if(holder.itemBinding.likeImage.tag.equals("unset")){
                holder.itemBinding.likeImage.setImageResource(R.drawable.notlike)
                holder.itemBinding.likeCount.setText("122 likes")
                holder.itemBinding.likeImage.setTag("set")
            }
            else{
                holder.itemBinding.likeImage.setImageResource(R.drawable.like)
                holder.itemBinding.likeCount.setText("121 likes")
                holder.itemBinding.likeImage.setTag("unset")
            }
        }
        holder.itemBinding.commentLayout.setOnClickListener{
            val intent=Intent(context,CommentActivity::class.java)
            intent.putExtra("key",list[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = list.size

    class ViewHolder(val itemBinding: FeedItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

}