package com.online.staticfragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_count_down.view.*


class CountDownFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       val fragmentView =  inflater.inflate(R.layout.fragment_count_down, container, false)

        var count = 0
        fragmentView.btnAdd.setOnClickListener{
            count--
            fragmentView.tvCounter.text= count.toString()
        }
        return fragmentView

    }


}
