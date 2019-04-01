package com.cua.katsuhub.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cua.katsuhub.R

class DetailActivity : AppCompatActivity() {
    companion object {
        const val CURRENT_VIEW_PRIMARY_KEY:String = "DATA"
    }

    private val id by lazy{
        intent.getIntExtra(CURRENT_VIEW_PRIMARY_KEY, 0)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}
