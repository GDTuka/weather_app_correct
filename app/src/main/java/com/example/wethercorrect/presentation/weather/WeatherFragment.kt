package com.example.wethercorrect.presentation.weather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.wethercorrect.R
import com.example.wethercorrect.data.entites.WeatherResponse
import com.example.wethercorrect.domain.Adapter
import kotlinx.android.synthetic.main.items.*
import kotlinx.android.synthetic.main.weather_fragment.*
import kotlinx.android.synthetic.main.weather_fragment.view.*


class WeatherFragment : Fragment() {

    companion object {

        fun newInstance() = WeatherFragment()
    }
    var adapter = Adapter()

    private lateinit var viewModel: WeatherViewModel
    var someList = listOf<WeatherResponse>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.weather_fragment, container, false)
        view.recyclet_view.adapter = adapter
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        viewModel.weatherLiveData.observe(viewLifecycleOwner, {
            render(it)
            adapter.items += it
        })
        val cityList = listOf<String>("moscow","berlin")
        var i = 0
        var a = 2

        viewModel.getWeather(cityList[0])
        viewModel.getWeather(cityList[1])
    }

    private fun render(state: WeatherScreenState){
        if (state.error != null) {
        }

        if (state.success != null){
        }
    }


}