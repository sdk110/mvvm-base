package com.codberg.mvvm_type_A.sample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.libs.cutil_kotlin.BaseKotlinViewModel


import com.codberg.mvvm_type_A.sample.model.request.request_testApi
import com.codberg.mvvm_type_A.sample.model.response.singleTypeData_Response
import com.codberg.mvvm_type_A.sample.model.response.listTypeData_Response
import com.codberg.mvvm_type_A.sample.model.service.networkServiece
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class ViewModel(private val model: networkServiece) : BaseKotlinViewModel(), AnkoLogger {

    private val TAG = "ViewModel"
    companion object  { val POST = 0; val GET  = 1 }

    //리스트 타입 예시
    val _listType_ResponseLiveData = MutableLiveData<List<listTypeData_Response>>()
    val listType_ResponseLiveData:LiveData<List<listTypeData_Response>> get() = _listType_ResponseLiveData

    //단일 데이터 예시
    private val _singleDataType_ResponseLiveData = MutableLiveData<singleTypeData_Response>()
    val singleDataType_ResponseLiveData:LiveData<singleTypeData_Response> get() = _singleDataType_ResponseLiveData

    fun notifyListTypeData(requestType : Int) {

        when(requestType)  {

            GET ->  {
                addDisposable(model.testApi_GET("header_GET","1","desc",1,100)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        {
                            _listType_ResponseLiveData.postValue(it)
                        },
                        {
                            it.printStackTrace()
                        }
                    )
                )
            }

            POST -> {
                var request : request_testApi = request_testApi("1","ASC",3,300)

                addDisposable(model.testApi_POST("header_POST",request)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        {
                            _listType_ResponseLiveData.postValue(it)
                        },
                        {
                            it.printStackTrace()
                        }
                    )
                )
            }

        }

    }

    fun notifySingleData(requestType : Int)  {

        when(requestType)  {

            GET -> {
                addDisposable(model.testApi2_GET("header_GET","1","desc",1,100)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        {
                            info("${it.name} - singleType")
                            _singleDataType_ResponseLiveData.postValue(it)
                        },
                        {
                            it.printStackTrace()
                        }
                    )
                )
            }

            POST -> {
                var request : request_testApi = request_testApi("1","ASC",3,300)

                addDisposable(model.testApi2_POST("header_POST",request)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        {
                            info("${it.name} - singleType")
                            _singleDataType_ResponseLiveData.postValue(it)
                        },
                        {
                            it.printStackTrace()
                        }
                    )
                )
            }

        }

    }

}