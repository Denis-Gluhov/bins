package glukhov.denis.bins.domain

import glukhov.denis.bins.data.network.Api
import glukhov.denis.bins.data.network.model.User
import io.reactivex.Single
import java.text.SimpleDateFormat
import java.util.*

class ContactsUseCase(
    private val api: Api
) {

    fun execute(): Single<List<Params>> {
        return api.contacts()
            .flatMap {
                if (!it.users.isNullOrEmpty()) Single.just(it.users)
                else Single.error(ResponseServerException())
            }
            .toObservable()
            .flatMapIterable { it }
            .map { map(it) }
            .toList()
    }

    private fun map(user: User): Params {
        val params = Params()

        if (!user.foto.isNullOrEmpty())
            params.foto = user.foto

        if (!user.name.isNullOrEmpty())
            params.name = user.name

        if (user.sex != null)
            params.sex = user.sex

        if (user.age != null)
            params.age = user.age

        if (user.message != null) {
            params.time = castDateToStr(Date(user.message.time!!))
            params.msg = user.message.msg!!
        }

        return params
    }

    private fun castDateToStr(date: Date): String {
        val pattern = "dd.MM, HH:mm"
        val castDate = SimpleDateFormat(pattern, Locale.US)
        return castDate.format(date)
    }

    inner class Params(
        var foto: String = "",
        var name: String = "",
        var sex: Int = 0,
        var age: Int = 0,
        var time: String = "",
        var msg: String = ""
    )

}