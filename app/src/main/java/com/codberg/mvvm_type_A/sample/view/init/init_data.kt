package com.codberg.mvvm_type_A.sample.view.init

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.widget.HorizontalScrollView
import com.codberg.mvvm_type_A.R

data class init_data(var mCon : Context) : init_view(mCon) {

    val DATA_NONE   = -2
    val CUSTOM   = -1
    val TYPE_A =  0
    val TYPE_B =  1
    val TYPE_C =  2
    val TYPE_D =  3

    val HORIZONTAL =  4
    val VERTICAL =  5

    /** [common] **/
    var layout_config = 0 // 0, 1, 2, 3
    var layout_transition_type = TYPE_A

    /** [splash] ---------------------------------------------------------**/

        //타입
        var splash_view_type = TYPE_A // TYPE-A, customView
        var splash_anmation_type = TYPE_A // TYPE-A, customView

        //backround
        var splash_background = DATA_NONE //배경이미지
        var splash_backgroundColor = Color.parseColor("#444444") //배경이미지

        //이미지뷰
        var splash_img  = R.drawable.ic_launcher_foreground // R.drawble.00000
        var splash_img_scaleX = 0.5f// 0.3f
        var splash_img_scaleY = 0.5f// 0.3f
        var splash_img_positionX  = 0.25f// 0.3f
        var splash_img_positionY  = 0.25f// 0.3f

        //텍스트뷰
        var splash_text_color = Color.parseColor("#E2D9CD")
        var splash_text_scaleX = 0.6f// 0.3f
        var splash_text_scaleY = 0.1f// 0.3f
        var splash_text_positionX = 0.205f//0.3f
        var splash_text_positionY = 0.01f//0.8f
        var splash_text_size = 18.0f// 14
        var splash_text = "MAXIZER"// Codberg.co
        var splash_delay_time = 2500

    /**------------------------------------------------------------------**/


    /** [Login] ---------------------------------------------------------**/

        //타입
        var login_view_type = TYPE_A// TYPE-A, customView
        var login_anmation_type = TYPE_A // TYPE-A, customView

        //layout
        var login_parrent_background = DATA_NONE
        var login_parrent_backgroundColor = Color.parseColor("#222222")

        //이미지(external)
        var login_parrent_image_src = DATA_NONE// 이미지
        var login_parrent_image_scaleX = 0.0f// 0.3f
        var login_parrent_image_scaleY = 0.0f// 0.3f
        var login_parrent_image_positionX = 0.0f// 0.3f
        var login_parrent_image_positionY = 0.0f// 0.3f

        //텍스트(external)
        var login_parrent_text_background = ""// 이미지
        var login_parrent_text_scaleX = 0.0f// 0.3f
        var login_parrent_text_scaleY = 0.0f// 0.3f
        var login_parrent_text_positionX = 0.0f// 0.3f
        var login_parrent_text_positionY = 0.0f// 0.3f

        //서브 레이아웃
        var login_sub_parent_1_background = DATA_NONE//배경이미지
        var login_sub_parent_1_backgroundColor = Color.parseColor("#444444")//배경이미지
        var login_sub_parent_1_scaleX  = 0.85f// 0.3f
        var login_sub_parent_1_scaleY  = 0.65f// 0.3f
        var login_sub_parent_1_positionX = 0.075f// 0.3f
        var login_sub_parent_1_positionY = 0.06f// 0.3f

        //이미지(internal)
        var login_sub_parent_1_image_src = R.drawable.ic_launcher_foreground// 이미지
        var login_sub_parent_1_image_scaleX = 0.5f// 0.3f
        var login_sub_parent_1_image_scaleY = 0.5f// 0.3f
        var login_sub_parent_1_image_positionX = 0.33f// 0.3f
        var login_sub_parent_1_image_positionY = -0.035f// 0.3f

        //텍스트1(internal)
        var login_sub_parent_1_text1_str = "MAXIZER Serviece"
        var login_sub_parent_1_text1_typeface = Typeface.SANS_SERIF
        var login_sub_parent_1_text1_scaleX = 0.7f// 0.3f
        var login_sub_parent_1_text1_scaleY = 0.16f// 0.3f
        var login_sub_parent_1_text1_positionX = 0.055f// 0.3f
        var login_sub_parent_1_text1_positionY = 0.09f// 0.3f
        var login_sub_parent_1_text1_textSize  = 24f// 0.3f
        var login_sub_parent_1_text1_textColor = Color.parseColor("#E2D9CD")// 0.3f

        //텍스트2(internal)
        var login_sub_parent_1_text2_str = ""
        var login_sub_parent_1_text2_typeface = Typeface.SANS_SERIF
        var login_sub_parent_1_text2_scaleX = 0.0f// 0.3f
        var login_sub_parent_1_text2_scaleY = 0.0f// 0.3f
        var login_sub_parent_1_text2_positionX = 0.0f// 0.3f
        var login_sub_parent_1_text2_positionY = 0.0f// 0.3f
        var login_sub_parent_1_text2_textSIze = 32f// 0.3f
        var login_sub_parent_1_text2_textColor = Color.parseColor("#777777")// 0.3f

        //입력 레이아웃
        var login_sub_parent_2_background = DATA_NONE//배경이미지
        var login_sub_parent_2_backgroundColor = Color.parseColor("#ffffff")//배경이미지
        var login_sub_parent_2_scaleX  = 0.85f// 0.3f
        var login_sub_parent_2_scaleY  = 0.65f// 0.3f
        var login_sub_parent_2_positionX = 0.117f// 0.3f
        var login_sub_parent_2_positionY = 0.29f// 0.3f

        //텍스트(input)
        var login_sub_parent_2_text1_str = "LOGIN"
        var login_sub_parent_2_text1_typeface = Typeface.SANS_SERIF
        var login_sub_parent_2_text1_scaleX = 0.6f// 0.3f
        var login_sub_parent_2_text1_scaleY = 0.15f// 0.3f
        var login_sub_parent_2_text1_positionX = 0.11f// 0.3f
        var login_sub_parent_2_text1_positionY = 0.07f// 0.3f
        var login_sub_parent_2_text1_textSize = 32f// 0.3f
        var login_sub_parent_2_text1_textColor = Color.parseColor("#777777")// 0.3f

        //입력뷰(ID)
        var login_sub_parent_2_input_id_hint = "아이디 입력"
        var login_sub_parent_2_input_id_hintColor = Color.parseColor("#aaaaaa")
        var login_sub_parent_2_input_id_textSize = 16.0f
        var login_sub_parent_2_input_id_textColor = Color.parseColor("#222222")
        var login_sub_parent_2_input_id_scaleX  = 0.6f// 0.3f
        var login_sub_parent_2_input_id_scaleY  = 0.09f// 0.3f
        var login_sub_parent_2_input_id_positionX = 0.1f// 0.3f
        var login_sub_parent_2_input_id_positionY = -0.02f// 0.3f

        //입력뷰(PW)
        var login_sub_parent_2_input_pw_hint = "비밀번호 입력"
        var login_sub_parent_2_input_pw_hintColor = Color.parseColor("#aaaaaa")
        var login_sub_parent_2_input_pw_textSize = 16.0f
        var login_sub_parent_2_input_pw_textColor = Color.parseColor("#222222")
        var login_sub_parent_2_input_pw_scaleX  = 0.6f// 0.3f
        var login_sub_parent_2_input_pw_scaleY  = 0.09f// 0.3f
        var login_sub_parent_2_input_pw_positionX = 0.1f// 0.3f
        var login_sub_parent_2_input_pw_positionY = -0.02f// 0.3f

        //외부 기타 텍스트
        var login_sub_parent_2_text2_str = ""//
        var login_sub_parent_2_text2_scaleX = 0.6f
        var login_sub_parent_2_text2_scaleY = 0.15f
        var login_sub_parent_2_text2_positionX = 0.28f//
        var login_sub_parent_2_text2_positionY = 0.92f//
        var login_sub_parent_2_text2_textSize = 25f
        var login_sub_parent_2_text2_textColor = Color.parseColor("#ffffff")
        var login_sub_parent_2_text2_background = DATA_NONE
        var login_sub_parent_2_text2_backgroundColor = DATA_NONE

        //로그인 공통
        var login_sub_parent_2_signIn_group_orientation = VERTICAL // VERTICAL , HORIAONTAL
        var login_sub_parent_2_signIn_group_nomal_active = true
        var login_sub_parent_2_signIn_group_kakao_active = false
        var login_sub_parent_2_signIn_group_faceBook_active = false
        var login_sub_parent_2_signIn_group_naver_active = false
        var login_sub_parent_2_signIn_group_item_marginTop = 15 //15 , 10
        var login_sub_parent_2_signIn_group_item_marginLeft = 0 //0 , 0
        var login_sub_parent_2_signIn_group_item_marginRight = 0 //0 , 25
        var login_sub_parent_2_signIn_group_item_marginBottom = 0 //0 , 0
        var login_sub_parent_2_signIn_group_item_scaleX = 0.6f //0.6f , 0.18f
        var login_sub_parent_2_signIn_group_item_scaleY = 0.05f //0.05f , 0.1f
        var login_sub_parent_2_signIn_group_item_positionX = 0.105f// 0.105f , 0.115f
        var login_sub_parent_2_signIn_group_item_positionY = -0.02f// -0.02f , -0.02f
        var login_sub_parent_2_signIn_group_text_str = "Codberg. CO"//
        var login_sub_parent_2_signIn_group_text_scaleX = 0.2f
        var login_sub_parent_2_signIn_group_text_scaleY = 0.1f
        var login_sub_parent_2_signIn_group_text_positionX = 0.33f//
        var login_sub_parent_2_signIn_group_text_positionY = 0.18f//
        var login_sub_parent_2_signIn_group_text_textSize = 11f
        var login_sub_parent_2_signIn_group_text_textColor = Color.parseColor("#222222")
        var login_sub_parent_2_signIn_group_text_background = DATA_NONE
        var login_sub_parent_2_signIn_group_text_backgroundColor = DATA_NONE

        //일반 로그인 버튼
        var login_sub_parent_2_signIn_group_nomal_login_str = "로그인"
        var login_sub_parent_2_signIn_group_nomal_login_textSize = 15f
        var login_sub_parent_2_signIn_group_nomal_login_textColor = Color.parseColor("#222222")
        var login_sub_parent_2_signIn_group_nomal_login_background = R.drawable.round
        var login_sub_parent_2_signIn_group_nomal_login_backgroundColor = DATA_NONE

        //카카오 로그인 버튼
        var login_sub_parent_2_signIn_group_kakao_login_str = "카카오 로그인"
        var login_sub_parent_2_signIn_group_kakao_login_textSize = 15f
        var login_sub_parent_2_signIn_group_kakao_login_textColor = Color.parseColor("#222222")
        var login_sub_parent_2_signIn_group_kakao_login_background = R.drawable.round_yellow
        var login_sub_parent_2_signIn_group_kakao_login_backgroundColor = DATA_NONE

        //페이스북 로그인 버튼
        var login_sub_parent_2_signIn_group_faceBook_login_str = "페이스북 로그인"
        var login_sub_parent_2_signIn_group_faceBook_login_textSize = 15f
        var login_sub_parent_2_signIn_group_faceBook_login_textColor = Color.parseColor("#eeeeee")
        var login_sub_parent_2_signIn_group_faceBook_login_background = R.drawable.round_blue
        var login_sub_parent_2_signIn_group_faceBook_login_backgroundColor = DATA_NONE

        //네이버 로그인 버-튼
        var login_sub_parent_2_signIn_group_naver_login_str = "네이버 로그인"
        var login_sub_parent_2_signIn_group_naver_login_textSize = 15f
        var login_sub_parent_2_signIn_group_naver_login_textColor = Color.parseColor("#ffffff")
        var login_sub_parent_2_signIn_group_naver_login_background = R.drawable.round_green
        var login_sub_parent_2_signIn_group_naver_login_backgroundColor = DATA_NONE

        //회원가입 & 비번찾기 공통
        var login_sub_parent_2_info_group_orientation = HORIZONTAL
        var login_sub_parent_2_info_group_background = DATA_NONE
        var login_sub_parent_2_info_group_backgroundColor = Color.parseColor("#999999")
        var login_sub_parent_2_info_group_space_scaleX = 0.01f
        var login_sub_parent_2_info_group_space_scaleY = 0.02f
        var login_sub_parent_2_info_group_space_positionX = 0.14f//
        var login_sub_parent_2_info_group_space_positionY = 0.007f//

        //회원가입 버튼
        var login_sub_parent_2_info_group_signUP_text = "회원가입"
        var login_sub_parent_2_info_group_signUP_textSize = 15f
        var login_sub_parent_2_info_group_signUP_textColor = Color.parseColor("#222222")
        var login_sub_parent_2_info_group_signUP_scaleX = 0.2f
        var login_sub_parent_2_info_group_signUP_scaleY = 0.03f
        var login_sub_parent_2_info_group_signUP_positionX = 0.14f// 0.3f
        var login_sub_parent_2_info_group_signUP_positionY = 0.00f// 0.3f


        //비번찾기 버튼
        var login_sub_parent_2_info_group_findPW_text = "아이디/비번찾기"
        var login_sub_parent_2_info_group_findPW_textSize = 15f
        var login_sub_parent_2_info_group_findPW_textColor = Color.parseColor("#222222")
        var login_sub_parent_2_info_group_findPW_scaleX = 0.4f
        var login_sub_parent_2_info_group_findPW_scaleY = 0.03f
        var login_sub_parent_2_info_group_findPW_positionX = 0.1f// 0.3f
        var login_sub_parent_2_info_group_findPW_positionY = 0.00f// 0.3f

    /**------------------------------------------------------------------**/

    /** [mainView] ------------------------------------------------------**/

        //타입
        var main_view_type = CUSTOM // main_type_A or CUSTOM

    /**------------------------------------------------------------------**/

}