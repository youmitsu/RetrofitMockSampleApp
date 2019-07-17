package jp.co.youmitsu.retrofitmocksampleapp

class Repository {

    fun searchZipCode(entry: String?, onSuccess: (result: List<ZipData>) -> Unit, onFailed: (message: String) -> Unit) {
        val result = listOf(
            ZipData(
                "", "", "", "", "", "", "", ""
            )
        )
        onSuccess(result)
    }
}