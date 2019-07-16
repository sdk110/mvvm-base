package com.codberg.mvvm_type_A.sample.view.init

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.*
import org.jetbrains.anko.*

open class init_view(mCon : Context) {

    /** [splash - TYPE_A] ----------------------------------------------**/
    lateinit var splash_contentVIew_Type_A : LinearLayout
    lateinit var splash_contentVIew_Type_A_img : ImageView
    lateinit var splash_contentVIew_Type_A_text : TextView

    fun getSplash_TYPE_A(mCon : Context) : View {
        return mCon.UI {
            splash_contentVIew_Type_A = verticalLayout  {
                splash_contentVIew_Type_A_img = imageView()  {
                }
                splash_contentVIew_Type_A_text = textView()  {
                    gravity = Gravity.CENTER
                }
            }
        }.view
    }

    /**----------------------------------------------------------------**/



    /** [login - TYPE_A] ----------------------------------------------**/

    lateinit var login_Type_A_parrent : FrameLayout
    lateinit var login_Type_A_parrent_image : ImageView
    lateinit var login_Type_A_parrent_text : TextView
    lateinit var login_Type_A_sub_parent_1 : FrameLayout
    lateinit var login_Type_A_sub_parent_2 : LinearLayout
    lateinit var login_Type_A_sub_parent_2_info_group : LinearLayout

    lateinit var login_Type_A_sub_parent_2_signIn_group : LinearLayout
    lateinit var login_Type_A_sub_parent_2_signIn_group_nomal_login : TextView
    lateinit var login_Type_A_sub_parent_2_signIn_group_login_kakao : TextView
    lateinit var login_Type_A_sub_parent_2_signIn_group_login_faceBook : TextView
    lateinit var login_Type_A_sub_parent_2_signIn_group_login_naver : TextView

    lateinit var login_Type_A_sub_parent_1_image : ImageView
    lateinit var login_Type_A_sub_parent_1_text1 : TextView
    lateinit var login_Type_A_sub_parent_1_text2 : TextView
    lateinit var login_Type_A_sub_parent_2_text1 : TextView
    lateinit var login_Type_A_sub_parent_2_input_id : EditText
    lateinit var login_Type_A_sub_parent_2_input_pw : EditText
    lateinit var login_Type_A_sub_parent_2_info_group_sign_up : TextView
    lateinit var login_Type_A_sub_parent_2_info_group_space : ImageView
    lateinit var login_Type_A_sub_parent_2_info_group_find_pw : TextView
    lateinit var login_Type_A_sub_parent_2_text2 : TextView
    lateinit var login_Type_A_parrent_text2 : TextView

    fun getLogin_TYPE_A(mCon : Context) : View  {

        return mCon.UI {
            login_Type_A_parrent = frameLayout {
                login_Type_A_parrent_image = imageView { }
                login_Type_A_parrent_text  = textView  { }
                login_Type_A_sub_parent_1 = frameLayout {
                    login_Type_A_sub_parent_1_image = imageView { }
                    login_Type_A_sub_parent_1_text1 = textView { }
                    login_Type_A_sub_parent_1_text2 = textView { }
                }
                login_Type_A_sub_parent_2 = verticalLayout {
                    login_Type_A_sub_parent_2_text1 = textView { }
                    login_Type_A_sub_parent_2_input_id = editText {  }
                    login_Type_A_sub_parent_2_input_pw = editText {  }
                    login_Type_A_sub_parent_2_signIn_group = linearLayout {
                        gravity = Gravity.LEFT
                        login_Type_A_sub_parent_2_signIn_group_nomal_login      = textView  { gravity = Gravity.CENTER }
                        login_Type_A_sub_parent_2_signIn_group_login_kakao      = textView  { gravity = Gravity.CENTER }
                        login_Type_A_sub_parent_2_signIn_group_login_faceBook   = textView  { gravity = Gravity.CENTER }
                        login_Type_A_sub_parent_2_signIn_group_login_naver      = textView  { gravity = Gravity.CENTER }
                    }.lparams(wrapContent, wrapContent)
                    login_Type_A_sub_parent_2_info_group = linearLayout {
                        login_Type_A_sub_parent_2_info_group_sign_up = textView { gravity = Gravity.CENTER }
                        login_Type_A_sub_parent_2_info_group_space   = imageView{ }
                        login_Type_A_sub_parent_2_info_group_find_pw = textView { gravity = Gravity.CENTER }
                    }.lparams(matchParent, wrapContent)
                    login_Type_A_sub_parent_2_text2 = textView { }
                }
                login_Type_A_parrent_text2 = textView { }
            }
        }.view

    }

    /**----------------------------------------------------------------**/

    fun getLogin_TYPE_B(mCon : Context) : View {
        return mCon.UI {
            verticalLayout {
                backgroundColor = Color.parseColor("#ffffff")
            }
        }.view
    }

    fun getMain_TYPE_A(mCon:Context) : View {
        return mCon.UI {
            verticalLayout {
                backgroundColor = Color.parseColor("#ffffff")
            }
        }.view
    }

}