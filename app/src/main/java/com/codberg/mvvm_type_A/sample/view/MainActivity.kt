package com.codberg.mvvm_type_A.sample.view

import android.os.Bundle
import android.view.View
import com.codberg.mvvm_type_A.sample.view.init.initActivity
import com.libs.cutil_kotlin.BasicUtil
import com.libs.cutil_kotlin.ViewUtil

class MainActivity : initActivity()  {

    override fun onRemove(): Int = 3
    override fun onBackground(): Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}