package glukhov.denis.bins.data.network.model

import com.google.gson.annotations.SerializedName

class Message(
    @SerializedName("muid")
    val muid: Long?,

    @SerializedName("ts")
    val ts: Long?,

    @SerializedName("time")
    val time: Long?,

    @SerializedName("type")
    val type: Int?,

    @SerializedName("status")
    val status: Int?,

    @SerializedName("msg")
    val msg: String?
)