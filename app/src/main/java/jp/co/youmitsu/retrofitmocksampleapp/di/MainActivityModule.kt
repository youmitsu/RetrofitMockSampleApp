package jp.co.youmitsu.retrofitmocksampleapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.co.youmitsu.retrofitmocksampleapp.MainActivity

@Module
internal abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}