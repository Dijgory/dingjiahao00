package cn.edu.togethorapp.ui.watch

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WatchViewModel : ViewModel() {
    private var _seconds: MutableLiveData<Int> = MutableLiveData()
    private var running=false
    val seconds: LiveData<Int> = _seconds
    var wasRunning=false
    init {
        runTimer()
    }
    fun start(){
        running=true
    }
    fun stop(){
        running=false
    }
    fun restart(){
        running=true
        _seconds.value=0
    }
    fun runTimer(){
        val handler = Handler()
        val runnable = object :Runnable{
            override fun run() {

//                textView.text = String.format("%02d:%02d:%02d",hours,minutes,sec)
                if(running){
                    val sec = _seconds.value?:0
                    _seconds.value= sec+1
                }
                handler.postDelayed(this,1000)
            }
        }
        handler.post(runnable)
    }
}
