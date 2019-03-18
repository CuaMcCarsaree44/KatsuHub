package com.cua.katsuhub.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.cua.katsuhub.R
import com.cua.katsuhub.viewmodel.CharacterViewModel

class MainMenu : AppCompatActivity(), View.OnClickListener {


    private lateinit var search:Button
    private lateinit var disclaimer:Button
    private lateinit var searchText: TextView
    private var character:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        searchText = findViewById(R.id.searchTextbox)
        search = findViewById(R.id.searchButton)
        disclaimer = findViewById(R.id.disclaimerButton)

        disclaimer.setOnClickListener(this@MainMenu)
        search.setOnClickListener(this@MainMenu)
    }
    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.searchButton -> {
                character = searchText.text.toString()
                val fly = Intent(this@MainMenu, SearchResult::class.java)
                fly.putExtra(SearchResult.CHARACTER_PRIMARY_KEY, character)
                startActivity(fly)
            }
            R.id.disclaimerButton -> {
                var dial: AlertDialog.Builder = AlertDialog.Builder(this@MainMenu)
                dial.setMessage("""The developer knows nothing about anime so
                    | if there's something i need to fix from this app, include the anime anime picture things,
                    | you're welcome. Feel free to criticize :'). This project is for educational purpose only. \n\n
                    | The Developer only know Madobe Nanami which is. . . .
                """.trimMargin())
                dial.setTitle("Disclaimer")
                dial.setPositiveButton("*Okay*", null)
                dial.setCancelable(true)
                dial.create().show()
            }

        }
    }
}
