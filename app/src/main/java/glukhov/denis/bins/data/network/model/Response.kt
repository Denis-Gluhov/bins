package glukhov.denis.bins.data.network.model

import com.google.gson.annotations.SerializedName

class Response(
    @SerializedName("has_more")
    val hasMore: Int,

    @SerializedName("user")
    val users: List<User>?,

    @SerializedName("errno")
    val errno: Int?
)