package com.messaging.urvarassignment.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.messaging.urvarassignment.fragments.BazaarFragment
import com.messaging.urvarassignment.fragments.CharchaFragment
import com.messaging.urvarassignment.fragments.ProfileFragment


class TabLayoutAdapter(context: Context, fragmentManager: FragmentManager, totalTabs: Int) :
     FragmentPagerAdapter(fragmentManager){
    var mContext: Context
    var mTotalTabs: Int

    init {
        mContext = context
        mTotalTabs = totalTabs
    }


    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> CharchaFragment()
            1 -> BazaarFragment()
            2 -> ProfileFragment()
          else -> CharchaFragment()
        }
    }

    override fun getCount(): Int {
        return mTotalTabs
    }

}