package com.cua.katsuhub.services

import com.cua.katsuhub.model.anime.AnimeRoot
import com.cua.katsuhub.model.animes.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AnimeRepository {
    private val api = ApiConnection().getInstance()
    private val compositeDisposable = CompositeDisposable()

    fun getTrending(onResult: (Response) -> Unit, onError: (Throwable) -> Unit){
        api.getTrending().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: ApiObserver<Response>(compositeDisposable){
                override fun onApiSuccess(data: Response) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }

            })
    }

    fun getSpecific(x:Int, onResult: (AnimeRoot) -> Unit, onError: (Throwable) -> Unit){
        api.getSpecific(x).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: ApiObserver<AnimeRoot>(compositeDisposable){
                override fun onApiSuccess(data: AnimeRoot) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }

            })
    }

    fun getTitle(x:String, onResult: (Response) -> Unit, onError: (Throwable) -> Unit){
        api.getTitle(x).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: ApiObserver<Response>(compositeDisposable){
                override fun onApiSuccess(data: Response) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }

            })
    }

    fun onDestroy(){
        compositeDisposable.clear()
    }
}