package glukhov.denis.bins.presentations.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter {

    protected val disposables = CompositeDisposable()

    operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
        disposables.add(disposable)
    }

    protected fun dispose() {
        disposables.dispose()
        disposables.clear()
    }

}