package com.pot.weatherapp.logic.model

import com.google.gson.annotations.SerializedName

/**
 * 按照API中的返回的JSON格式来定义的数据类
 */

data class PlaceResponse(val status: String, val places: List<Place>)

data class Place(val name: String, val location: Location,
                 @SerializedName("formatted_address") val address: String)

data class Location(val lng: String, val lat: String)