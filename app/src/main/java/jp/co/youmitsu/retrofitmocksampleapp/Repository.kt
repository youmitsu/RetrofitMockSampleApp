package jp.co.youmitsu.retrofitmocksampleapp

import android.annotation.SuppressLint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jp.co.youmitsu.retrofitmocksampleapp.net.ZipApiClientCreator

class Repository {

    companion object {
        const val errorMessage = "エラーが発生しました"
    }

    @SuppressLint("CheckResult")
    fun searchZipCode(entry: String?, onSuccess: (result: List<ZipData>) -> Unit, onFailed: (message: String) -> Unit) {
        val client = ZipApiClientCreator.create()
        client.search(entry ?: "")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result: ZipDataList ->
                onSuccess(result?.results ?: listOf(ZipData()))
            }, { _ ->
                onFailed(errorMessage)
            })
    }
}