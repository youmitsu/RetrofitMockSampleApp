package jp.co.youmitsu.retrofitmocksampleapp

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import jp.co.youmitsu.retrofitmocksampleapp.di.DaggerAppComponent

open class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .build()
    }
}