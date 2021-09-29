package com.example.wethercorrect.presentation.BlankFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wethercorrect.R
import com.example.wethercorrect.presentation.weather.WeatherFragment
import kotlinx.android.synthetic.main.fragment_first.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [firstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class firstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_first, container, false)
        view.btn1.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container,WeatherFragment())
                .commit()
        }
        return view
    }


}