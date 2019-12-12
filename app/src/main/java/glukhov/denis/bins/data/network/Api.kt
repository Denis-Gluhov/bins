package glukhov.denis.bins.data.network

import glukhov.denis.bins.data.network.model.Response
import io.reactivex.Single
import retrofit2.http.GET

interface Api {

    @GET("/bins/1bkt3r")
    fun contacts(): Single<Response>

}