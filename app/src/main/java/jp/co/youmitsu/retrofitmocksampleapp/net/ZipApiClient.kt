package jp.co.youmitsu.retrofitmocksampleapp.net

import io.reactivex.Observable
import jp.co.youmitsu.retrofitmocksampleapp.ZipDataList
import retrofit2.http.GET
import retrofit2.http.Query

interface ZipApiClient {
    @GET("search")
    fun search(@Query("zipcode") zipcode: String): Observable<ZipDataList>
}