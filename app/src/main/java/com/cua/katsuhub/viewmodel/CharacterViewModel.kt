package com.cua.katsuhub.viewmodel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cua.katsuhub.model.CharacterData
import com.cua.katsuhub.model.response.CharacterResponse
import com.cua.katsuhub.services.ApiConnection
import com.cua.katsuhub.services.ApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {
    val character = MutableLiveData<List<CharacterData>>()

    private val api: ApiServices = ApiConnection().getInstance()

    fun getCharacter(characterName: String){
        api.getData(characterName)
            .enqueue(object: Callback<CharacterResponse>{
                override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                    Log.d("CALL API", "RESPONSE FAILURE")
                }

                override fun onResponse(call: Call<CharacterResponse>, response: Response<CharacterResponse>) {
                    if(response.isSuccessful){
                        Log.d("CALL API", "RESPONSE SUCC")
                        response.body()?.let {
                            Log.d("CALL API", "RESPONSE DATA ${it.data.size}")
                            character.postValue(it.data)
                        }
                    }else{
                        Log.d("CALL API", "RESPONSE FAILURE")
                    }
                }

            })
    }

}