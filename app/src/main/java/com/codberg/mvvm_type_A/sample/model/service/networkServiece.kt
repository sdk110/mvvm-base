package com.codberg.mvvm_type_A.sample.model.service

import com.codberg.mvvm_type_A.sample.model.request.request_testApi
import com.codberg.mvvm_type_A.sample.model.response.listTypeData_Response
import com.codberg.mvvm_type_A.sample.model.response.singleTypeData_Response
import io.reactivex.Single
import retrofit2.http.*


interface networkServiece {

    @GET("json.php")
    fun testApi_GET( @Header("data") auth:String, @Query("json") query:String, @Query("sort") sort:String, @Query("page") page:Int, @Query("size") size:Int ) : Single<List<listTypeData_Response>>

    @POST("json.php")
    fun testApi_POST( @Header("data") auth:String, @Body jsonObject:request_testApi ) : Single<List<listTypeData_Response>>

    @GET("json.php")
    fun testApi2_GET( @Header("data") auth:String, @Query("json") query:String, @Query("sort") sort:String, @Query("page") page:Int, @Query("size") size:Int ) : Single<singleTypeData_Response>

    @POST("json.php")
    fun testApi2_POST( @Header("data") auth:String, @Body jsonObject:request_testApi ) : Single<singleTypeData_Response>

}