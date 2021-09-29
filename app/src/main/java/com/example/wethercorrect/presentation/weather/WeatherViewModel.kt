package com.example.wethercorrect.presentation.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wethercorrect.data.entites.WeatherResponse
import com.example.wethercorrect.domain.Adapter
import com.example.wethercorrect.domain.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.logging.Handler

data class WeatherScreenState(
    val success: WeatherResponse? = null,
    val loading: Boolean = true,
    val error: Throwable? = null
)

class WeatherViewModel : ViewModel() {

    private val repository = Repository()
    val weatherLiveData = MutableLiveData(WeatherScreenState())
    private val disposable = CompositeDisposable()

    fun getWeather(cityName:String) {
        weatherLiveData.value = WeatherScreenState(
            loading = true
        )

        disposable.add(
            repository.getDataService(cityName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    weatherLiveData.value = WeatherScreenState(
                        success = it,
                        loading = false,
                        error = null
                    )
                    disposable.clear()
                }, {
                    weatherLiveData.value = WeatherScreenState(
                        loading = false,
                        error = it
                    )
                })

        )

    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }

    companion object {

        private const val TAG = "WeatherViewModel"
    }
}