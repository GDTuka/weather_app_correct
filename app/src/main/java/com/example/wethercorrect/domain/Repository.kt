package com.example.wethercorrect.domain

import com.example.wethercorrect.data.entites.APIService
import com.example.wethercorrect.data.entites.WeatherResponse
import io.reactivex.Single



    class Repository {

        fun getDataService(cityName: String): Single<WeatherResponse> {
            return APIService.api.getWeather(cityName)
        }
    }
