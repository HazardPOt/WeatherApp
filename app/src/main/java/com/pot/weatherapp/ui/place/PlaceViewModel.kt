package com.pot.weatherapp.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.pot.weatherapp.logic.Repository
import com.pot.weatherapp.logic.model.Place

class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    // 如果ViewModel中的某个LiveData对象是调用另外的方法获取的，那么我们就可以借助
    // switchMap()方法，将这个LiveData对象转换成另外一个可观察的LiveData对象。
    // 将Repository.seatchPlace(query) 转化为 searchLiveData
    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String){
        searchLiveData.value = query
    }

}