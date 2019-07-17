package jp.co.youmitsu.retrofitmocksampleapp

import android.annotation.SuppressLint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jp.co.youmitsu.retrofitmocksampleapp.net.ZipApiClient
import javax.inject.Inject

class Repository @Inject constructor() {

    @Inject
    lateinit var zipApiClient: ZipApiClient

    companion object {
        const val errorMessage = "エラーが発生しました"
    }

    @SuppressLint("CheckResult")
    fun searchZipCode(entry: String?, onSuccess: (result: List<ZipData>) -> Unit, onFailed: (message: String) -> Unit) {
        zipApiClient.search(entry ?: "")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result: ZipDataList ->
                onSuccess(result?.results ?: listOf(ZipData()))
            }, { _ ->
                onFailed(errorMessage)
            })
    }
}