package jp.co.youmitsu.retrofitmocksampleapp.di

import dagger.Module
import dagger.Provides
import jp.co.youmitsu.retrofitmocksampleapp.net.ZipApiClient
import jp.co.youmitsu.retrofitmocksampleapp.net.ZipApiClientCreator

@Module
class AppModule {
    //
//    @Provides
//    @Singleton
//    fun provideOkHttpClient(): OkHttpClient =
//        OkHttpClient.Builder()
//            .apply {
//                if (BuildConfig.DEBUG) {
//                    addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
//                }
//            }.build()
//
//    @Provides
//    @Singleton
//    fun provideRetrofit(client: OkHttpClient): Retrofit =
//        Retrofit.Builder()
//            .baseUrl("http://zipcloud.ibsnet.co.jp/api/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .client(client)
//            .build()
    @Provides
    fun provideZipApiClient(): ZipApiClient {
        return ZipApiClientCreator.create()
    }
}