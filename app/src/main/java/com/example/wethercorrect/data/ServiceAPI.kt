package com.example.wethercorrect.data

import com.example.wethercorrect.data.entites.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceAPI{

    @GET("data/2.5/weather?&units=metric&APPID=04a42b96398abc8e4183798ed22f9485")
    fun getWeather(
        @Query("q") cityName: String
    ): Single<WeatherResponse>
}