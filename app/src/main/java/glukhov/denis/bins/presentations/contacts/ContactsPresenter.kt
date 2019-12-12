package glukhov.denis.bins.presentations.contacts

import glukhov.denis.bins.domain.ContactsUseCase
import glukhov.denis.bins.presentations.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ContactsPresenter(
    private val view: ContactsView,
    private val contactsUseCase: ContactsUseCase
): BasePresenter() {

    private lateinit var data: List<Contact>

    fun load() {
        disposables += contactsUseCase.execute()
            .toObservable()
            .flatMapIterable { it }
            .map { Contact(foto = it.foto, name = it.name, age = it.age,
                    sex = it.sex, time = it.time, msg = it.msg) }
            .toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {view.onShowLoadData()}
            .doAfterTerminate {view.onHideLoadData()}
            .subscribe ({
                data = it
                view.onDataSet(data)
            }) { view.onShowMessage() }
    }

    fun destroy() {
        dispose()
    }

}