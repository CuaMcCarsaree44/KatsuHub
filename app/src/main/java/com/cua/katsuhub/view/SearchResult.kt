package com.cua.katsuhub.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cua.katsuhub.R
import com.cua.katsuhub.services.DUMMY
import com.cua.katsuhub.viewmodel.CharacterViewModel

class SearchResult : AppCompatActivity() {
    private lateinit var search:String

    companion object {
        val CHARACTER_PRIMARY_KEY:String = "Character"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)
        var get:Intent = getIntent()
        search = get.getStringExtra(CHARACTER_PRIMARY_KEY)

        getData(search)
    }

    fun getData(x:String)
    {
        val vmodel:CharacterViewModel = CharacterViewModel()
        if(vmodel.search(search) === null)
            Toast.makeText(this@SearchResult, DUMMY, Toast.LENGTH_LONG).show()
        else Toast.makeText(this@SearchResult, "Data Found", Toast.LENGTH_LONG).show()

    }
}
