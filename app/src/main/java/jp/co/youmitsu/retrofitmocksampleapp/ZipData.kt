package jp.co.youmitsu.retrofitmocksampleapp

import com.google.gson.annotations.SerializedName

data class ZipData(
    @SerializedName("address1")
    val address1: String,
    @SerializedName("address2")
    val address2: String,
    @SerializedName("address3")
    val address3: String,
    @SerializedName("kana1")
    val kana1: String,
    @SerializedName("kana2")
    val kana2: String,
    @SerializedName("kana3")
    val kana3: String,
    @SerializedName("zipcode")
    val zipCode: String,
    @SerializedName("prefcode")
    val prefCode: String
) {
    constructor() : this(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    )
}