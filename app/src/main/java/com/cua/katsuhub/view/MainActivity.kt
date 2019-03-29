package com.cua.katsuhub.view

import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.cua.katsuhub.R

class MainActivity : AppCompatActivity(), View.OnFocusChangeListener {
    private lateinit var rViewTop:RecyclerView
    private lateinit var rViewMid:RecyclerView
    private lateinit var searchAnime:EditText
    @RequiresApi(Build.VERSION_CODES.O)
    private lateinit var calibri:Typeface
    @RequiresApi(Build.VERSION_CODES.O)
    private lateinit var default:Typeface
    
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calibri = resources.getFont(R.font.calibri)
        default = resources.getFont(R.font.neofobia_regular)

        searchAnime = findViewById(R.id.searchAnime)

        searchAnime.clearFocus()
        searchAnime.onFocusChangeListener = this@MainActivity
        searchAnime.setOnKeyListener { view: View, i: Int, keyEvent: KeyEvent ->
            if(keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER)
                searchTrigger()
            return@setOnKeyListener true
        }
    }

    fun searchTrigger()
    {
        Toast.makeText(this@MainActivity, "LAMBDA EXPRESSION EVERYBADEH!!!!", Toast.LENGTH_LONG).show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        when(v?.id)
        {
            R.id.searchAnime ->{
                if(hasFocus === false)
                {
                    searchAnime.typeface = default
                }else if(hasFocus === true)
                {
                    searchAnime.typeface = calibri
                }
            }   
        }
    }
}
