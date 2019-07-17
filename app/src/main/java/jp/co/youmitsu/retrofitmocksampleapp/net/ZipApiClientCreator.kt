package jp.co.youmitsu.retrofitmocksampleapp.net

import jp.co.youmitsu.retrofitmocksampleapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ZipApiClientCreator {

    fun create(): ZipApiClient {
        val client = OkHttpClient.Builder()
            .apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                }
            }.build()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://zipcloud.ibsnet.co.jp/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ZipApiClient::class.java)
    }
}