package com.codberg.mvvm_type_A.sample.view

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.libs.cutil_kotlin.ViewUtil
import com.codberg.mvvm_type_A.R
import com.codberg.mvvm_type_A.sample.viewmodel.ViewModel
import org.jetbrains.anko.*

class PopupViewManager(rUtil : ViewUtil?, rViewModel : ViewModel, rCon : AppCompatActivity) {

    var con = rCon
    var util = rUtil
    var viewModel = rViewModel

}


