package jp.co.youmitsu.retrofitmocksampleapp

import com.google.gson.annotations.SerializedName

data class ZipDataList(
    @SerializedName("message")
    val message: String?,
    @SerializedName("results")
    val results: MutableList<ZipData>?,
    @SerializedName("status")
    val status: Int
)