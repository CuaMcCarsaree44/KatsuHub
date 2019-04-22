package com.cua.katsuhub.viewmodel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cua.katsuhub.model.CharacterData
import com.cua.katsuhub.model.response.CharacterResponse
import com.cua.katsuhub.services.AnimeRepository
import com.cua.katsuhub.services.ApiConnection
import com.cua.katsuhub.services.ApiServices
import com.cua.katsuhub.services.CharacterRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {
    val characterList = MutableLiveData<List<CharacterData>>()
    private val repos:CharacterRepository= CharacterRepository()
    fun getCharacter(characterName: String){
        repos.getCharacter(characterName, {
            characterList.postValue(it.data)
        },{
            it.printStackTrace()
        })
    }

}