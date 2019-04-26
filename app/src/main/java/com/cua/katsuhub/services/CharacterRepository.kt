package com.cua.katsuhub.services

import com.cua.katsuhub.model.response.CharacterResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharacterRepository {
    private val api = ApiConnection().getInstance()
    private val compositeDisposable = CompositeDisposable()

    fun getCharacter(x:String, onResult: (CharacterResponse) -> Unit, onError: (Throwable) -> Unit){
        api.getData(x).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: ApiObserver<CharacterResponse>(compositeDisposable){
                override fun onApiSuccess(data: CharacterResponse) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }
}