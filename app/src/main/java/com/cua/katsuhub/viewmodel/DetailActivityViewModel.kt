package com.cua.katsuhub.viewmodel

import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel

class DetailActivityViewModel : ViewModel() {
    private var value:Double = 0.0
    private fun <E> nullErrorPointer(e: E?):Boolean{
        try{
            e!!.toString()
            return true
        }catch(f:Exception){
            f.printStackTrace()
        }
        return false
    }

    fun rating1(x:String?):Boolean{
        if(nullErrorPointer(x)) {
            value = x!!.toDouble()

            if(value >= 15.0) return true
        }

        return false
    }

    fun rating2(x:String?):Boolean{
        if(nullErrorPointer(x)) {
            value = x!!.toDouble()

            if(value >= 35.0) return true
        }

        return false
    }

    fun rating3(x:String?):Boolean{
        if(nullErrorPointer(x)) {
            value = x!!.toDouble()

            if(value >= 65.0) return true
        }

        return false
    }

    fun rating4(x:String?):Boolean{
        if(nullErrorPointer(x)) {
            value = x!!.toDouble()

            if(value >= 80.0) return true
        }

        return false
    }

    fun rating5(x:String?):Boolean{
        if(nullErrorPointer(x)) {
            value = x!!.toDouble()

            if(value > 90.0) return true
        }

        return false
    }


    fun stringCompress(x:String?):Float{
        var size = 64.0f
        if(nullErrorPointer(x)) {
            when {
                x!!.length >= 30 -> size = 38.0f
                x.length >= 38 -> size = 19.0f
                x.length >= 47 -> size = 8.0f
            }
        }
        return size
    }
}