package glukhov.denis.bins.data.network.model

import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("foto")
    val foto: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("sex")
    val sex: Int?,

    @SerializedName("age")
    val age: Int?,

    @SerializedName("message")
    val message: Message?
)