package com.cua.katsuhub.utils

class BindingUtilities {
    fun stringCompress(x:String): String
    {
        lateinit var returners:String
        if(x.length > 76)
        {
            for(i in 0 until 38)
                returners += x[i]

            returners += '\n'

            for(i in 38 until 76 )
                returners += x[i]

            returners += "..."
        }else if(x.length in 38..77)
        {
            for(i in 0 until 38)
                returners += x[i]

            returners += '\n'

            for(i in 38 until x.length)
                returners += x[i]
        }else if(x.length <= 38)
        {
            return x
        }
        return returners
    }

    fun convertToDouble(x:String):Double
    {
        return x.toDouble()
    }

    fun rating_1(x:String):Boolean
    {
        if(convertToDouble(x) >= 15) return true

        return false
    }

    fun rating_2(x:String):Boolean
    {
        if(convertToDouble(x) >= 35) return true

        return false
    }

    fun rating_3(x:String):Boolean
    {
        if(convertToDouble(x) > 60) return true

        return false
    }

    fun rating_4(x:String):Boolean
    {
        if(convertToDouble(x) >= 78) return true

        return false
    }

    fun rating_5(x:String):Boolean
    {
        if(convertToDouble(x) >= 90) return true

        return false
    }

    fun toStringer(x:Int):String
    {
        return x.toString()
    }

    fun getDate(x:String):String
    {
        var date = ""
        for(i in 0 until x.length)
            date += if(x[i].isDigit()) {
                x[i]
            }else if(x[i].equals('-')) {
                x[i]
            }else break
        return date
    }
}