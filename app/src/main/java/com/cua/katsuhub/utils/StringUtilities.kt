package com.cua.katsuhub.utils

class StringUtilities {
    fun stringCompress(x:String): String
    {
        lateinit var returners:String
        if(x.length > 34)
        {
            for(i in 0 until 17)
                returners += x[i]

            returners += '\n'

            for(i in 17 until 27 )
                returners += x[i]

            returners += "..."
        }else if(x.length in 18..33)
        {
            for(i in 0 until 17)
                returners += x[i]

            returners += '\n'

            for(i in 17 until x.length)
                returners += x[i]
        }else if(x.length <= 17)
        {
            return x
        }
        return returners
    }

    fun convertToDouble(x:String):Double
    {
        return x.toDouble()
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