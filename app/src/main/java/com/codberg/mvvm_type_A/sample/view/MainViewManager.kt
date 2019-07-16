package com.codberg.mvvm_type_A.sample.view

import android.graphics.Color
import android.view.Gravity
import android.view.View
import com.codberg.mvvm_type_A.R
import com.codberg.mvvm_type_A.sample.view.init.initActivity
import com.codberg.mvvm_type_A.sample.view.init.initViewManager
import com.codberg.mvvm_type_A.sample.view.init.init_data
import com.codberg.mvvm_type_A.sample.viewmodel.ViewModel
import com.google.android.material.snackbar.Snackbar
import com.libs.cutil_kotlin.BasicUtil

import com.libs.cutil_kotlin.ViewUtil
import org.jetbrains.anko.*

class MainViewManager : initViewManager {

    constructor(rUtil : ViewUtil?, rViewModel : ViewModel, rCon : initActivity, rinit : init_data) : super(rUtil, rViewModel, rCon, rinit)

    /** [로그인화면] 로그인 버튼 클릭 시 호출 **/
    override fun onLoginClick_LoginScene(input_ID : String , input_PW : String , rUtil: ViewUtil?, rViewModel: ViewModel, rCon: initActivity) : Boolean {
        BasicUtil.DelayExecute(BasicUtil.DelayExecuteLitener {  Snackbar.make(rCon.contentView!!,"로그인 성공", 2000)}, 500)
        return true
    }

    /** [로그인화면] 회원가입 버튼 클릭 시 호출 **/
    override fun onSignUpClick_LoginScene(rUtil: ViewUtil?, rViewModel: ViewModel, rCon: initActivity)  {
        Snackbar.make(rCon.contentView!!,"회원가입 클릭",Snackbar.LENGTH_LONG).show()
    }

    /** [로그인화면] 아이디/비번찾기 버튼 클릭 시 호출 **/
    override fun onFindInfoClick_LoginScene(rUtil: ViewUtil?, rViewModel: ViewModel, rCon: initActivity)  {
        Snackbar.make(rCon.contentView!!,"비번찾기 클릭",Snackbar.LENGTH_LONG).show()
    }

    /** [로그인화면] login_view_type = TYPE_A, login_anmation_type = CUSTOM 설정 시 호출 (애니메이션 정의 시 활용) **/
    override fun onPlayCustomAnimation_Login_TypeA(v: View, v1: View, v2: View, v3: View, v4: View, v5: View, v6: View) {

    }

    /** [시작화면] splash_view_type = TYPE_A, splash_anmation_type = CUSTOM 설정 시 호출 (애니메이션 정의 시 활용) **/
    override fun onPlayCustomAnimation_Splash_TypeA(v: View, v1: View) {

    }

    /** [시작화면] splash_view_type = CUSTOM 설정 시 호출(직접정의한 뷰 사용 시 활용) **/
    override fun onDraw_CUSTUM_VIEW_SPLASH(rUtil: ViewUtil?, rViewModel: ViewModel, rCon: initActivity, rinit : init_data) : View? {
        return rCon.UI {
            verticalLayout {
                gravity= Gravity.CENTER
                backgroundColor= Color.parseColor("#566684")
                alpha =0.8f
                linearLayout {
                    backgroundColor= Color.parseColor("#ffffff")
                    gravity= Gravity.CENTER
                    imageView {
                        id = R.id.test_item_img
                        imageResource = R.drawable.ic_image_black_24dp
                    }
                    textView  {
                        id = R.id.test_item_text
                        text = "스플래시(CUSTOM)"
                    }
                }
            }
        }.view
    }

    /** [로그인화면] splash_view_type = CUSTOM 설정 시 호출(직접정의한 뷰 사용 시 활용) **/
    override fun onDraw_CUSTUM_VIEW_LOGIN(rUtil: ViewUtil?, rViewModel: ViewModel, rCon: initActivity, rinit : init_data) : View? {
        return rCon.UI {
            verticalLayout {
                gravity= Gravity.CENTER
                backgroundColor= Color.parseColor("#566684")
                alpha =0.8f
                linearLayout {
                    backgroundColor= Color.parseColor("#ffffff")
                    gravity= Gravity.CENTER
                    imageView {
                        id = R.id.test_item_img
                        imageResource = R.drawable.ic_image_black_24dp
                    }
                    textView  {
                        id = R.id.test_item_text
                        text = "로그인(CUSTOM)"
                    }
                }
            }
        }.view
    }

    /** [메인화면] main_view_type = CUSTOM 설정 시 호출(직접정의한 뷰 사용 시 활용) **/
    override fun onDraw_CUSTUM_VIEW_MAIN(rUtil: ViewUtil?, rViewModel: ViewModel, rCon: initActivity, rinit : init_data): View? {
        return rCon.UI {
            verticalLayout {
                gravity= Gravity.CENTER
                backgroundColor= Color.parseColor("#566684")
                alpha =0.8f
                linearLayout {
                    backgroundColor= Color.parseColor("#ffffff")
                    gravity= Gravity.CENTER
                    imageView {
                        id = R.id.test_item_img
                        imageResource = R.drawable.ic_image_black_24dp
                    }
                    textView  {
                        id = R.id.test_item_text
                        text = "메인(CUSTOM)"
                    }
                }
            }
        }.view
    }

}