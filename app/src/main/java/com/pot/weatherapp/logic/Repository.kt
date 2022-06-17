package com.pot.weatherapp.logic

import androidx.lifecycle.liveData
import com.pot.weatherapp.logic.model.Place
import com.pot.weatherapp.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

object Repository {
    // Dispatchers.IO 开启子线程，Android中不允许在主线程中进行网络请求
    // liveData()函数可以自动构建并返回又给LiveData对象 liveData的匿名类实现
    fun searchPlaces(query: String) = liveData(Dispatchers.IO){
        val result = try{
            // PlaceResponse的Data类
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if(placeResponse.status == "ok"){
                val places = placeResponse.places
                Result.success(places)
            }
            else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }
        catch(e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }

}