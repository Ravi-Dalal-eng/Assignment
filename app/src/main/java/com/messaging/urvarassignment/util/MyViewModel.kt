package com.messaging.urvarassignment.util


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MyViewModel: ViewModel() {
private var feeds= MutableLiveData<List<String>>()


    fun getFeeds(): LiveData<List<String>> {
        loadFeeds()
        return feeds
    }

    private fun loadFeeds() {
        feeds.postValue(DataRepository.getData())
    }

}