package cn.edu.togethorapp.ui.notifications

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import cn.edu.togethorapp.R
import cn.edu.togethorapp.ui.notifications.CityViewModel
import cn.edu.togethorapp.ui.watch.WatchViewModel
import kotlinx.android.synthetic.main.fragment_notifications.*


class CityFragment : Fragment() {

    lateinit var viewModel: CityViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_notifications)
//        viewModel=ViewModelProvider(this , ViewModelProvider.AndroidViewModelFactory(application)).get(CityViewModel::class.java)
//        viewModel=ViewModelProvider(this , ViewModelProvider.AndroidViewModelFactory(Application())).get(CityViewModel::class.java)
        viewModel = ViewModelProviders.of(this).get(CityViewModel::class.java)
        viewModel.cities.observe(requireActivity(), Observer {

            val cities=it
            val adapter = ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1,cities)
            listView.adapter = adapter
            listView.setOnItemClickListener { _, _, position, _ ->
                val cityCode = cities[position].city_code
                val intent = Intent(requireActivity(), Main2Activity::class.java)
                intent.putExtra("city_code", cityCode)
                startActivity(intent)
            }
        })
    }
}

//package cn.edu.togethorapp.ui.notifications
//
//import android.content.Intent
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ArrayAdapter
//import android.widget.TextView
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.ViewModelProviders
//import cn.edu.togethorapp.R
//import cn.edu.togethorapp.ui.watch.WatchViewModel
//import kotlinx.android.synthetic.main.fragment_notifications.*
//import kotlinx.android.synthetic.main.watch_fragment.*
////import cn.edu.togethorapp.activitytest.*;
//
//class CityFragment : Fragment() {
//
//    private lateinit var viewModel: CityViewModel
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_notifications, container, false)
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
//////        setContentView(R.layout.fragment_notifications)
//////        viewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(application)).get(CityViewModel::class.java)
////        viewModel = ViewModelProviders.of(this).get(CityViewModel::class.java)
////        viewModel.cities.observe(this, Observer {
////            val cities=it
////            val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,cities)
////            listView.adapter = adapter
////            listView.setOnItemClickListener { _, _, position, _ ->
////                val cityCode = cities[position].city_code
////                val intent = Intent(this,Main2Activity::class.java)
////                intent.putExtra("city_code", cityCode)
////                startActivity(intent)
////            }
////        })
//
//        viewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(appliction)).get(CityViewModel::class.java)
//        viewModel.cities.observe(this, Observer {
//            val cities=it
//            val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,cities)
//            listView.adapter = adapter
//            listView.setOnItemClickListener { _, _, position, _ ->
//                val cityCode = cities[position].city_code
//                val intent = Intent(this, Main2Activity::class.java)
//                intent.putExtra("city_code", cityCode)
//                startActivity(intent)
//            }
//        })
//    }
//}
