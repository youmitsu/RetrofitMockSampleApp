package jp.co.youmitsu.retrofitmocksampleapp

class Repository {

    fun searchZipCode(entry: String?, onSuccess: (result: List<ZipData>) -> Unit, onFailed: (message: String) -> Unit) {
        val result = listOf(
            ZipData(
                "hoge",
                "hoge",
                "hgoe",
                "hoge",
                "hgoe",
                "hoge",
                "1201011",
                "ja-01"
            )
        )
        onSuccess(result)
    }
}