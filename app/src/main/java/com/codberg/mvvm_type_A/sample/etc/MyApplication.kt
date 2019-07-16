package com.codberg.mvvm_type_A.sample.etc

import android.app.Application
import com.codberg.mvvm_type_A.sample.di.myDiModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, myDiModule)
    }

}