package com.cua.katsuhub.services

import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class ApiObserver<T> constructor(private val compositeDisponsible: CompositeDisposable): Observer<T> {
    override fun onComplete() {

    }

    override fun onError(e: Throwable) {
        onApiError(e)
    }

    override fun onNext(t: T) {
        onApiSuccess(t)
    }

    override fun onSubscribe(d: Disposable) {
        compositeDisponsible.add(d)
    }

    abstract fun onApiSuccess(data: T)
    abstract fun onApiError(er: Throwable)
}