package com.codberg.mvvm_type_A.sample.di

import com.libs.cutil_kotlin.BuildConfig
import com.libs.cutil_kotlin.GeneralPerposeRecyclerViewAdapter
import com.codberg.mvvm_type_A.sample.model.service.networkServiece
import com.codberg.mvvm_type_A.sample.viewmodel.ViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


var retrofitPart = module {

    //single -> 하나의 객체만을 생성하여 전역적으로 사용
    single  {

        val interceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG)  interceptor.level = HttpLoggingInterceptor.Level.BODY
            else                    interceptor.level = HttpLoggingInterceptor.Level.BODY //DATA_NONE (사용배포시 DATA_NONE 반영)

        Retrofit.Builder()
            .baseUrl("http://design.designcodberg.co.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(OkHttpClient.Builder().addNetworkInterceptor(interceptor).build())
            .build()
            .create(networkServiece::class.java)

    }

}

var adapterPart = module {
    factory { GeneralPerposeRecyclerViewAdapter(get()) }
}

var viewModelPart = module {
    viewModel { ViewModel(get()) }
}

var myDiModule = listOf(retrofitPart, viewModelPart, adapterPart)