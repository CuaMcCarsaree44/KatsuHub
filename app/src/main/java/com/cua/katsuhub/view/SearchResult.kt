package com.cua.katsuhub.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.cua.katsuhub.R
import com.cua.katsuhub.databinding.ActivitySearchResultBinding
import com.cua.katsuhub.model.Data
import com.cua.katsuhub.model.DataItem
import com.cua.katsuhub.services.ApiServices
import com.cua.katsuhub.services.Converter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchResult : AppCompatActivity() {
    private lateinit var search:String
    private lateinit var bind: ActivitySearchResultBinding

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
        val conv: Converter = Converter()

        var api: ApiServices = conv.getInstance()
        val data: Call<Data> = api.getData(x)

        data.enqueue(object: Callback<Data> {
            override fun onFailure(call: Call<Data>, t: Throwable) {

            }

            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                val status:Boolean = response.isSuccessful
                var feed = response.body()!!
                if(status){
                    bindData(feed.data!!.get(0)!!)
                }else
                {
                }
            }
        })
    }

    fun bindData(x: DataItem)
    {
        if(x == null)
        {
            Toast.makeText(this@SearchResult, "No Data here", Toast.LENGTH_LONG).show()
        }else {
            bind = DataBindingUtil.setContentView(this, R.layout.activity_search_result)
            bind.apply {
                datas = x
                bind.faceImage.setImageURI(Uri.parse(datas!!.attributes!!.image!!.original))
            //bind.nameTextbox.text = data!!.attributes.names.en

            }
        }
    }
}
