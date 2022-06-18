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

    /*
    首先，
    当外部调用PlaceViewModel的searchPlaces()方法来获取用户数据时，并不会发起任何请求或者
    函数调用，只会将传入的query值设置到searchLiveData当中。一旦searchLiveData的
    数据发生变化，那么观察searchLiveData的switchMap()方法就会执行，并且调用我们编
    写的转换函数。然后在转换函数中调用Repository.searchPlaces(query)方法获取真正的用户数据。
    同时，switchMap()方法会将Repository.searchPlaces(query)方法返回的LiveData对象转换成一
    个可观察的LiveData对象placeLiveData，对于Activity而言，只要去观察这个LiveData对象就可以了。
     */

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String){
        searchLiveData.value = query
    }

}