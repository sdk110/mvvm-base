package com.codberg.mvvm_type_A.sample.view.init

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.animation.ValueAnimator.REVERSE
import android.annotation.SuppressLint
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.*
import androidx.core.animation.addListener
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import com.libs.cutil_kotlin.ViewUtil
import com.codberg.mvvm_type_A.sample.viewmodel.ViewModel
import com.libs.cutil_kotlin.BasicUtil
import com.libs.cutil_kotlin.ImageLoader
import org.jetbrains.anko.*

abstract class initViewManager(rUtil : ViewUtil?, rViewModel : ViewModel, rCon : initActivity, rinit : init_data) : AnkoLogger {

    var con = rCon
    var util = rUtil
    var viewModel = rViewModel
    var init = rinit
    var cutomView_LOGIN : View? = null
    var customView_SPLASH : View? = null
    var customView_MAIN : View? = null
    var devWidth  = BasicUtil.getDeviceSize(con)[0]
    var devHeight = BasicUtil.getDeviceSize(con)[1]

    init  {
        if(init.splash_view_type == init.CUSTOM)    customView_SPLASH = onDraw_CUSTUM_VIEW_SPLASH(rUtil, rViewModel, rCon, rinit)
        if(init.login_view_type == init.CUSTOM)     cutomView_LOGIN   = onDraw_CUSTUM_VIEW_LOGIN(rUtil, rViewModel, rCon, rinit)
        if(init.main_view_type == init.CUSTOM)      customView_MAIN   = onDraw_CUSTUM_VIEW_MAIN(rUtil, rViewModel, rCon, rinit)
    }

    /** [공통_START]------------------**/

    fun checkData(data : Int) : Boolean = data != init.DATA_NONE
    fun checkCustomData(data : Int) : Boolean = data  == init.CUSTOM
    fun loadImage(wRate:Float, hRate:Float, path:Int,imgView:ImageView)  {
        ImageLoader().init(con, (devWidth.toFloat() * wRate).toInt(), (devHeight.toFloat() * hRate).toInt()).setPath(path).setImage(imgView)
    }
    fun loadImage(wRate:Float, hRate:Float, path:String,imgView:ImageView)  {
        ImageLoader().init(con, (devWidth.toFloat() * wRate).toInt(), (devHeight.toFloat() * hRate).toInt()).setPath(path).setImage(imgView)
    }

    /** [공통_END]------------------**/


    /** [시작화면_START]---------------------------------------------------------------------------------------------------------------------------------------------------**/

    fun setSplash()  {

        if(checkCustomData(init.splash_view_type))  return

        //part1
        setParrent_SPLASH()
        setText_SPLASH()
        setImage_SPLASH()
        setAnimation_SPLASH()

    }

    fun setParrent_SPLASH()  {
        init.splash_contentVIew_Type_A.apply {
            layoutParams = FrameLayout.LayoutParams(matchParent,matchParent)
            if(checkData(init.splash_background))         backgroundResource = init.splash_background
            if(checkData(init.splash_backgroundColor))    backgroundColor = init.splash_backgroundColor
        }
    }

    fun setText_SPLASH()  {
        init.splash_contentVIew_Type_A_text.apply {
            alpha = 0.0f
            text = init.splash_text
            textSize = init.splash_text_size
            layoutParams = LinearLayout.LayoutParams( (devWidth.toFloat() * init.splash_text_scaleX).toInt(),(devHeight.toFloat() * init.splash_text_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.splash_text_positionX)
            translationY = (devHeight.toFloat() * init.splash_text_positionY)
            textColor = init.splash_text_color
        }
    }

    fun setImage_SPLASH()  {
        loadImage(init.splash_img_scaleX, init.splash_img_scaleY, init.splash_img, init.splash_contentVIew_Type_A_img)
        init.splash_contentVIew_Type_A_img.apply {
            alpha = 0.0f
            layoutParams = LinearLayout.LayoutParams( (devWidth.toFloat() * init.splash_img_scaleX).toInt(),(devHeight.toFloat() * init.splash_img_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.splash_img_positionX)
            translationY = (devHeight.toFloat() * init.splash_img_positionY)
        }
    }

    fun setAnimation_SPLASH()  {
        when(init.splash_anmation_type)  {
            init.TYPE_A -> playAnimation_SPLASH(init.splash_contentVIew_Type_A_img , init.splash_contentVIew_Type_A_text)
            init.CUSTOM -> onPlayCustomAnimation_Splash_TypeA(init.splash_contentVIew_Type_A_img , init.splash_contentVIew_Type_A_text)
        }
    }

    fun playAnimation_SPLASH(img : ImageView, text : TextView)  {

        var set = AnimatorSet()

        var ani_A : ValueAnimator  = ObjectAnimator.ofFloat( img,  "ScaleX", 1.0f, 1.2f )
        ani_A.duration = 350
        ani_A.interpolator = LinearInterpolator()
        ani_A.repeatMode = REVERSE
        ani_A.startDelay = 300
        ani_A.repeatCount = 1

        var ani_B : ValueAnimator  = ObjectAnimator.ofFloat( img,  "ScaleY", 1.0f, 1.2f )
        ani_B.duration = 350
        ani_B.interpolator = LinearInterpolator()
        ani_B.repeatMode = REVERSE
        ani_B.startDelay = 400
        ani_B.repeatCount = 1

        var ani_C : ValueAnimator  = ObjectAnimator.ofFloat( img,  "alpha", 0.0f, 1.0f )
        ani_C.duration = 250
        ani_C.startDelay = 200
        ani_C.interpolator = FastOutLinearInInterpolator()

        var ani_D : ValueAnimator  = ObjectAnimator.ofFloat( text,  "alpha", 0.0f, 1.0f )
        ani_D.duration = 400
        ani_D.startDelay = 500
        ani_D.interpolator = FastOutLinearInInterpolator()

        set.play(ani_A).with(ani_B).with(ani_C).with(ani_D)
        set.start()

    }

    /** [시작화면_END]-----------------------------------------------------------------------------------------------------------------------------------------------------------**/




    @SuppressLint("ClickableViewAccessibility")

    /** [로그인화면_START]---------------------------------------------------------------------------------------------------------------------------------------------------**/

    fun setLogin(init : init_data)  {

        if(checkCustomData(init.login_view_type))  return

        //part1
        setParrent_LOGIN()
        setParrentImage_LOGIN()
        setParrentText_LOGIN()
        setParrentText2_LOGIN()

        //part2
        setSubParrent_LOGIN()
        setSubParrentImage_LOGIN()
        setSubParrentText_LOGIN()
        setSubParrentText1_LOGIN()

        //part3
        setSubParrent1_LOGIN()
        setSubParrent1_Input_Id_LOGIN()
        setSubParrent1_Input_pw_LOGIN()
        setSubParrent1_signIn_group_LOGIN()
        setSubParrent1_signIn_group_nomalLogin()
        setSubParrent1_signIn_group_kakaoLogin()
        setSubParrent1_signIn_group_naverLogin()
        setSubParrent1_signIn_group_facebookLogin()

        //part4
        setSubParrent2_text1_LOGIN()
        setSubParrent2_text2_LOGIN()
        setSubParrent2_infoGroup_LOGIN()
        setSubParrent2_infoGroup_contents_LOGIN()
        setSubParrent2_infoGroupSpace_LOGIN()
        setAnimation_LOGIN()

    }

    fun setParrent_LOGIN()  {
        init.login_Type_A_parrent.layoutParams = FrameLayout.LayoutParams(matchParent,matchParent)
        if(checkData(init.login_parrent_background))         init.login_Type_A_parrent.backgroundResource = init.login_parrent_background
        if(checkData(init.login_parrent_backgroundColor))    init.login_Type_A_parrent.backgroundColor = init.login_parrent_backgroundColor
    }

    fun setParrentImage_LOGIN()  {
        loadImage(init.login_parrent_image_scaleX, init.login_parrent_image_scaleY, init.login_parrent_image_src, init.login_Type_A_parrent_image)
        init.login_Type_A_parrent_image.apply {
            layoutParams = FrameLayout.LayoutParams((devWidth.toFloat() * init.login_parrent_image_scaleX).toInt(), (devHeight.toFloat() * init.login_parrent_image_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.login_parrent_image_positionX)
            translationY = (devHeight.toFloat() * init.login_parrent_image_positionY)
        }
    }

    fun setParrentText_LOGIN()  {
        init.login_Type_A_parrent_text.apply {
            text = init.login_parrent_text_background
            layoutParams = FrameLayout.LayoutParams((devWidth.toFloat() * init.login_parrent_text_scaleX).toInt(), (devHeight.toFloat() * init.login_parrent_text_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.login_parrent_text_positionX)
            translationY = (devHeight.toFloat() * init.login_parrent_text_positionY)
        }
    }

    fun setSubParrent_LOGIN()  {
        init.login_Type_A_sub_parent_1.apply {
            layoutParams =  FrameLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_1_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_1_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.login_sub_parent_1_positionX)
            translationY = (devHeight.toFloat() * init.login_sub_parent_1_positionY)
            if(checkData(init.login_sub_parent_1_background))       backgroundResource   = init.login_sub_parent_1_background
            if(checkData(init.login_sub_parent_1_backgroundColor))  backgroundColor      = init.login_sub_parent_1_backgroundColor
        }
    }

    fun setSubParrentImage_LOGIN() {
        loadImage(init.login_sub_parent_1_image_scaleX, init.login_sub_parent_1_image_scaleY, init.login_sub_parent_1_image_src, init.login_Type_A_sub_parent_1_image)
        init.login_Type_A_sub_parent_1_image.apply {
            layoutParams = FrameLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_1_image_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_1_image_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.login_sub_parent_1_image_positionX)
            translationY = (devHeight.toFloat() * init.login_sub_parent_1_image_positionY)
        }
    }

    fun setSubParrentText_LOGIN() {
        init.login_Type_A_sub_parent_1_text1.apply {
            text = init.login_sub_parent_1_text1_str
            typeface = init.login_sub_parent_1_text1_typeface
            textSize = init.login_sub_parent_1_text1_textSize
            textColor = init.login_sub_parent_1_text1_textColor
            layoutParams = FrameLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_1_text1_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_1_text1_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.login_sub_parent_1_text1_positionX)
            translationY = (devHeight.toFloat() * init.login_sub_parent_1_text1_positionY)
        }
    }

    fun setSubParrentText1_LOGIN() {
        init.login_Type_A_sub_parent_1_text2.apply {
            text = init.login_sub_parent_1_text2_str
            typeface = init.login_sub_parent_1_text2_typeface
            textSize = init.login_sub_parent_1_text2_textSIze
            textColor = init.login_sub_parent_1_text2_textColor
            layoutParams = FrameLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_1_text2_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_1_text2_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.login_sub_parent_1_text2_positionX)
            translationY = (devHeight.toFloat() * init.login_sub_parent_1_text2_positionY)
        }
    }

    fun setSubParrent1_LOGIN() {
        init.login_Type_A_sub_parent_2.apply {
            layoutParams =  FrameLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_2_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_2_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.login_sub_parent_2_positionX)
            translationY = (devHeight.toFloat() * init.login_sub_parent_2_positionY)
            if(checkData(init.login_sub_parent_1_background))       backgroundResource   = init.login_sub_parent_2_background
            if(checkData(init.login_sub_parent_1_backgroundColor))  backgroundColor      = init.login_sub_parent_2_backgroundColor
        }
    }

    fun setSubParrent1_Input_Id_LOGIN() {
        init.login_Type_A_sub_parent_2_input_id.apply {
            hint = init.login_sub_parent_2_input_id_hint
            textSize = init.login_sub_parent_2_input_id_textSize
            hintTextColor = init.login_sub_parent_2_input_id_hintColor
            textColor = init.login_sub_parent_2_input_id_textColor
            layoutParams =  LinearLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_2_input_id_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_2_input_id_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.login_sub_parent_2_input_id_positionX)
            translationY = (devHeight.toFloat() * init.login_sub_parent_2_input_id_positionY)
        }
    }

    fun setSubParrent1_Input_pw_LOGIN() {
        init.login_Type_A_sub_parent_2_input_pw.apply {
            hint = init.login_sub_parent_2_input_pw_hint
            textSize = init.login_sub_parent_2_input_pw_textSize
            hintTextColor = init.login_sub_parent_2_input_pw_hintColor
            textColor = init.login_sub_parent_2_input_pw_textColor
            layoutParams =  LinearLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_2_input_pw_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_2_input_pw_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.login_sub_parent_2_input_pw_positionX)
            translationY = (devHeight.toFloat() * init.login_sub_parent_2_input_pw_positionY)
        }
    }

    fun setSubParrent1_signIn_group_LOGIN() {

        init.login_Type_A_sub_parent_2_signIn_group.translationX = (devWidth.toFloat() * init.login_sub_parent_2_signIn_group_item_positionX)
        init.login_Type_A_sub_parent_2_signIn_group.translationY = (devHeight.toFloat() * init.login_sub_parent_2_signIn_group_item_positionY)

        when(init.login_sub_parent_2_signIn_group_orientation)  {
            init.HORIZONTAL -> init.login_Type_A_sub_parent_2_signIn_group.orientation = LinearLayout.HORIZONTAL
            init.VERTICAL   -> init.login_Type_A_sub_parent_2_signIn_group.orientation = LinearLayout.VERTICAL
        }

        when(init.login_sub_parent_2_signIn_group_kakao_active)  {
            true  -> init.login_Type_A_sub_parent_2_signIn_group_login_kakao.visibility = View.VISIBLE
            false -> init.login_Type_A_sub_parent_2_signIn_group_login_kakao.visibility = View.GONE
        }

        when(init.login_sub_parent_2_signIn_group_faceBook_active)  {
            true  -> init.login_Type_A_sub_parent_2_signIn_group_login_faceBook.visibility = View.VISIBLE
            false -> init.login_Type_A_sub_parent_2_signIn_group_login_faceBook.visibility = View.GONE
        }

        when(init.login_sub_parent_2_signIn_group_naver_active)  {
            true  -> init.login_Type_A_sub_parent_2_signIn_group_login_naver.visibility = View.VISIBLE
            false -> init.login_Type_A_sub_parent_2_signIn_group_login_naver.visibility = View.GONE
        }

        when(init.login_sub_parent_2_signIn_group_nomal_active)  {
            true -> {
                init.login_Type_A_sub_parent_2_signIn_group_nomal_login.visibility = View.VISIBLE
                init.login_Type_A_sub_parent_2_input_id.visibility = View.VISIBLE
                init.login_Type_A_sub_parent_2_input_pw.visibility = View.VISIBLE
                init.login_Type_A_sub_parent_2_info_group_sign_up.visibility = View.VISIBLE
                init.login_Type_A_sub_parent_2_info_group_find_pw.visibility = View.VISIBLE
            }
            false -> {
                init.login_Type_A_sub_parent_2_signIn_group_nomal_login.visibility = View.GONE
                init.login_Type_A_sub_parent_2_input_id.visibility = View.GONE
                init.login_Type_A_sub_parent_2_input_pw.visibility = View.GONE
                init.login_Type_A_sub_parent_2_info_group_sign_up.visibility = View.GONE
                init.login_Type_A_sub_parent_2_info_group_find_pw.visibility = View.GONE
            }
        }

    }

    @SuppressLint("ClickableViewAccessibility")
    fun setSubParrent1_signIn_group_nomalLogin() {
        init.login_Type_A_sub_parent_2_signIn_group_nomal_login.apply {
            text = init.login_sub_parent_2_signIn_group_nomal_login_str
            textSize = init.login_sub_parent_2_signIn_group_nomal_login_textSize
            textColor = init.login_sub_parent_2_signIn_group_nomal_login_textColor
            if(checkData(init.login_sub_parent_2_signIn_group_nomal_login_background))          backgroundResource = init.login_sub_parent_2_signIn_group_nomal_login_background
            if(checkData(init.login_sub_parent_2_signIn_group_nomal_login_backgroundColor))     backgroundColor = init.login_sub_parent_2_signIn_group_nomal_login_backgroundColor

            var parma : LinearLayout.LayoutParams =  LinearLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_2_signIn_group_item_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_2_signIn_group_item_scaleY).toInt() )
            parma.setMargins(init.login_sub_parent_2_signIn_group_item_marginLeft,init.login_sub_parent_2_signIn_group_item_marginTop,init.login_sub_parent_2_signIn_group_item_marginRight,init.login_sub_parent_2_signIn_group_item_marginBottom)
            layoutParams = parma

            setOnTouchListener(con.getViewUtil()!!.getAnimatingTouchlistener(ViewUtil.ANIMATION_SMALL_BUTTON__CLICK,
                ViewUtil.animatingTouchlistener {
                    var a = ""
                    var b = ""
                    if(init.login_Type_A_sub_parent_2_input_id.editableText != null) a = init.login_Type_A_sub_parent_2_input_id.editableText.toString()
                    if(init.login_Type_A_sub_parent_2_input_pw.editableText != null) b = init.login_Type_A_sub_parent_2_input_pw.editableText.toString()

                    var isOk = onLoginClick_LoginScene(a , b , util , viewModel , con)
                    if(isOk)    con.setMainScene()
                })
            )
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    fun setSubParrent1_signIn_group_kakaoLogin() {
        //카카오 로그인
        init.login_Type_A_sub_parent_2_signIn_group_login_kakao.apply {
            text = init.login_sub_parent_2_signIn_group_kakao_login_str
            textSize = init.login_sub_parent_2_signIn_group_kakao_login_textSize
            textColor = init.login_sub_parent_2_signIn_group_kakao_login_textColor
            if(checkData(init.login_sub_parent_2_signIn_group_kakao_login_background))          backgroundResource = init.login_sub_parent_2_signIn_group_kakao_login_background
            if(checkData(init.login_sub_parent_2_signIn_group_kakao_login_backgroundColor))     backgroundColor = init.login_sub_parent_2_signIn_group_kakao_login_backgroundColor

            var parma1 : LinearLayout.LayoutParams =  LinearLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_2_signIn_group_item_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_2_signIn_group_item_scaleY).toInt() )
            parma1.setMargins(init.login_sub_parent_2_signIn_group_item_marginLeft,init.login_sub_parent_2_signIn_group_item_marginTop,init.login_sub_parent_2_signIn_group_item_marginRight,init.login_sub_parent_2_signIn_group_item_marginBottom)
            layoutParams = parma1

            setOnTouchListener(con.getViewUtil()!!.getAnimatingTouchlistener(ViewUtil.ANIMATION_SMALL_BUTTON__CLICK,
                ViewUtil.animatingTouchlistener {
                    var a = ""
                    var b = ""
                    if(init.login_Type_A_sub_parent_2_input_id.editableText != null) a = init.login_Type_A_sub_parent_2_input_id.editableText.toString()
                    if(init.login_Type_A_sub_parent_2_input_pw.editableText != null) b = init.login_Type_A_sub_parent_2_input_pw.editableText.toString()

                    var isOk = onLoginClick_LoginScene(a , b , util , viewModel , con)
                    if(isOk)    con.setMainScene()
                })
            )
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    fun setSubParrent1_signIn_group_naverLogin()  {
        //네이버 로그인
        init.login_Type_A_sub_parent_2_signIn_group_login_naver.apply {
            text = init.login_sub_parent_2_signIn_group_naver_login_str
            textSize = init.login_sub_parent_2_signIn_group_naver_login_textSize
            textColor = init.login_sub_parent_2_signIn_group_naver_login_textColor
            if(checkData(init.login_sub_parent_2_signIn_group_naver_login_background))          backgroundResource = init.login_sub_parent_2_signIn_group_naver_login_background
            if(checkData(init.login_sub_parent_2_signIn_group_naver_login_backgroundColor))     backgroundColor = init.login_sub_parent_2_signIn_group_naver_login_backgroundColor

            var parma2 : LinearLayout.LayoutParams =  LinearLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_2_signIn_group_item_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_2_signIn_group_item_scaleY).toInt() )
            parma2.setMargins(init.login_sub_parent_2_signIn_group_item_marginLeft,init.login_sub_parent_2_signIn_group_item_marginTop,init.login_sub_parent_2_signIn_group_item_marginRight,init.login_sub_parent_2_signIn_group_item_marginBottom)
            layoutParams = parma2

            setOnTouchListener(con.getViewUtil()!!.getAnimatingTouchlistener(ViewUtil.ANIMATION_SMALL_BUTTON__CLICK,
                ViewUtil.animatingTouchlistener {
                    var a = ""
                    var b = ""
                    if(init.login_Type_A_sub_parent_2_input_id.editableText != null) a = init.login_Type_A_sub_parent_2_input_id.editableText.toString()
                    if(init.login_Type_A_sub_parent_2_input_pw.editableText != null) b = init.login_Type_A_sub_parent_2_input_pw.editableText.toString()

                    var isOk = onLoginClick_LoginScene(a , b , util , viewModel , con)
                    if(isOk)    con.setMainScene()
                })
            )
        }
    }
    @SuppressLint("ClickableViewAccessibility")
    fun setSubParrent1_signIn_group_facebookLogin() {
        //페북 로그인
        init.login_Type_A_sub_parent_2_signIn_group_login_faceBook.apply {
            text = init.login_sub_parent_2_signIn_group_faceBook_login_str
            textSize = init.login_sub_parent_2_signIn_group_faceBook_login_textSize
            textColor = init.login_sub_parent_2_signIn_group_faceBook_login_textColor
            if(checkData(init.login_sub_parent_2_signIn_group_faceBook_login_background))          backgroundResource = init.login_sub_parent_2_signIn_group_faceBook_login_background
            if(checkData(init.login_sub_parent_2_signIn_group_faceBook_login_backgroundColor))     backgroundColor = init.login_sub_parent_2_signIn_group_faceBook_login_backgroundColor
            var parma3 : LinearLayout.LayoutParams =  LinearLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_2_signIn_group_item_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_2_signIn_group_item_scaleY).toInt() )
            parma3.setMargins(init.login_sub_parent_2_signIn_group_item_marginLeft,init.login_sub_parent_2_signIn_group_item_marginTop,init.login_sub_parent_2_signIn_group_item_marginRight,init.login_sub_parent_2_signIn_group_item_marginBottom)
            layoutParams = parma3
            setOnTouchListener(con.getViewUtil()!!.getAnimatingTouchlistener(ViewUtil.ANIMATION_SMALL_BUTTON__CLICK,
                ViewUtil.animatingTouchlistener {
                    var a = ""
                    var b = ""
                    if(init.login_Type_A_sub_parent_2_input_id.editableText != null) a = init.login_Type_A_sub_parent_2_input_id.editableText.toString()
                    if(init.login_Type_A_sub_parent_2_input_pw.editableText != null) b = init.login_Type_A_sub_parent_2_input_pw.editableText.toString()

                    var isOk = onLoginClick_LoginScene(a , b , util , viewModel , con)
                    if(isOk)    con.setMainScene()
                })
            )
        }
    }

    fun setParrentText2_LOGIN() {
        init.login_Type_A_parrent_text2.apply {
            text = init.login_sub_parent_2_text2_str
            textSize = init.login_sub_parent_2_text2_textSize
            textColor = init.login_sub_parent_2_text2_textColor
            layoutParams =  FrameLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_2_text2_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_2_text2_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.login_sub_parent_2_text2_positionX)
            translationY = (devHeight.toFloat() * init.login_sub_parent_2_text2_positionY)
            if(checkData(init.login_sub_parent_2_text2_background))          backgroundResource = init.login_sub_parent_2_text2_background
            if(checkData(init.login_sub_parent_2_text2_backgroundColor))     backgroundColor = init.login_sub_parent_2_text2_backgroundColor
        }
    }

    fun setSubParrent2_text1_LOGIN() {
        init.login_Type_A_sub_parent_2_text1.apply {
            layoutParams =  LinearLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_2_text1_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_2_text1_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.login_sub_parent_2_text1_positionX)
            translationY = (devHeight.toFloat() * init.login_sub_parent_2_text1_positionY)
            textSize = init.login_sub_parent_2_text1_textSize
            typeface = init.login_sub_parent_2_text1_typeface
            textColor = init.login_sub_parent_2_text1_textColor
            text = init.login_sub_parent_2_text1_str
        }
    }

    fun setSubParrent2_infoGroupSpace_LOGIN() {
        init.login_Type_A_sub_parent_2_info_group_space.apply {
            if(checkData(init.login_sub_parent_2_info_group_background))         backgroundResource = init.login_sub_parent_2_info_group_background
            if(checkData(init.login_sub_parent_2_info_group_backgroundColor))    backgroundColor = init.login_sub_parent_2_info_group_backgroundColor
            layoutParams =  LinearLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_2_info_group_space_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_2_info_group_space_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.login_sub_parent_2_info_group_space_positionX)
            translationY = (devHeight.toFloat() * init.login_sub_parent_2_info_group_space_positionY)
        }
    }

    fun setSubParrent2_infoGroup_LOGIN() {
        when(init.login_sub_parent_2_info_group_orientation)  {
            init.HORIZONTAL -> { init.login_Type_A_sub_parent_2_info_group.orientation = LinearLayout.HORIZONTAL; init.login_Type_A_sub_parent_2_info_group_space.visibility = View.VISIBLE }
            init.VERTICAL   -> { init.login_Type_A_sub_parent_2_info_group.orientation = LinearLayout.VERTICAL;   init.login_Type_A_sub_parent_2_info_group_space.visibility = View.GONE }
        }
    }

    fun  setSubParrent2_infoGroup_contents_LOGIN() {

        init.login_Type_A_sub_parent_2_info_group_sign_up.apply {
            textSize = init.login_sub_parent_2_info_group_signUP_textSize
            textColor = init.login_sub_parent_2_info_group_signUP_textColor
            layoutParams =  LinearLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_2_info_group_signUP_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_2_info_group_signUP_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.login_sub_parent_2_info_group_signUP_positionX)
            translationY = (devHeight.toFloat() * init.login_sub_parent_2_info_group_signUP_positionY)
            text = init.login_sub_parent_2_info_group_signUP_text
            setOnClickListener {
                onSignUpClick_LoginScene(util , viewModel , con)
            }
        }

        init.login_Type_A_sub_parent_2_info_group_find_pw.apply {
            textSize = init.login_sub_parent_2_info_group_findPW_textSize
            textColor = init.login_sub_parent_2_info_group_findPW_textColor
            layoutParams =  LinearLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_2_info_group_findPW_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_2_info_group_findPW_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.login_sub_parent_2_info_group_findPW_positionX)
            translationY = (devHeight.toFloat() * init.login_sub_parent_2_info_group_findPW_positionY)
            text = init.login_sub_parent_2_info_group_findPW_text
            setOnClickListener {
                onFindInfoClick_LoginScene(util , viewModel , con)
            }
        }

    }

    fun setSubParrent2_text2_LOGIN() {
        init.login_Type_A_sub_parent_2_text2.apply {
            text = init.login_sub_parent_2_signIn_group_text_str
            textSize = init.login_sub_parent_2_signIn_group_text_textSize
            textColor = init.login_sub_parent_2_signIn_group_text_textColor
            layoutParams =  LinearLayout.LayoutParams((devWidth.toFloat() * init.login_sub_parent_2_signIn_group_text_scaleX).toInt(), (devHeight.toFloat() * init.login_sub_parent_2_signIn_group_text_scaleY).toInt() )
            translationX = (devWidth.toFloat() * init.login_sub_parent_2_signIn_group_text_positionX)
            translationY = (devHeight.toFloat() * init.login_sub_parent_2_signIn_group_text_positionY)
            if(checkData(init.login_sub_parent_2_signIn_group_text_background))          backgroundResource = init.login_sub_parent_2_signIn_group_text_background
            if(checkData(init.login_sub_parent_2_signIn_group_text_backgroundColor))     backgroundColor = init.login_sub_parent_2_signIn_group_text_backgroundColor
        }
    }

    fun setAnimation_LOGIN()  {
        when(init.login_anmation_type)  {
            init.TYPE_A ->  playAnimation_Login_Type_A(init.login_Type_A_sub_parent_1_image)
            init.CUSTOM ->  onPlayCustomAnimation_Login_TypeA(init.login_Type_A_parrent_text
                , init.login_Type_A_sub_parent_1_text1
                , init.login_Type_A_sub_parent_1_text2
                , init.login_Type_A_parrent_image
                , init.login_Type_A_sub_parent_1_image
                , init.login_Type_A_sub_parent_2_text1
                , init.login_Type_A_sub_parent_2_signIn_group_nomal_login)
        }
    }

    fun playAnimation_Login_Type_A(v : View)  {

        BasicUtil.DelayExecute(BasicUtil.DelayExecuteLitener {

            var ani_A : ValueAnimator  = ObjectAnimator.ofFloat( v,  "TranslationY", v.translationY, -v.translationY )
            ani_A.duration = 500
            ani_A.interpolator = AccelerateInterpolator()
            ani_A.addListener(onEnd = {

                v.rotationX = 0.0f
                BasicUtil.DelayExecute(BasicUtil.DelayExecuteLitener {

                    var width  = BasicUtil.getDeviceSize(con)[0]
                    var height = BasicUtil.getDeviceSize(con)[1]

                    val random = (-(width*0.05f).toInt()..(width*0.5f).toInt()).random()
                    v.translationX = random.toFloat()

                    val random1 = (7..14).random()
                    v.scaleX = random1.toFloat()*0.1f
                    v.scaleY = random1.toFloat()*0.1f

                    var ani_C : ValueAnimator  = ObjectAnimator.ofFloat( v,  "TranslationY", v.translationY, -v.translationY )
                    ani_C.duration = 1800
                    ani_C.interpolator = DecelerateInterpolator()
                    ani_C.addListener(onEnd = {

                        var ani_D : ValueAnimator  = ObjectAnimator.ofFloat( v,  "RotationX", 0.0f , -30.0f )
                        ani_D.duration = 300
                        ani_D.interpolator = DecelerateInterpolator()
                        ani_D.repeatCount = 1
                        ani_D.repeatMode = REVERSE
                        ani_D.start()

                        BasicUtil.DelayExecute(BasicUtil.DelayExecuteLitener {  playAnimation_Login_Type_A(v) }, 2000)
                    })
                    ani_C.start()

                    var set = AnimatorSet()
                    var ani_A : ValueAnimator  = ObjectAnimator.ofFloat( v,  "ScaleX", v.scaleX, v.scaleX-0.1f)
                    ani_A.duration = 300
                    ani_A.interpolator = LinearInterpolator()
                    ani_A.repeatMode = REVERSE
                    ani_A.startDelay = 450
                    ani_A.repeatCount= 1

                    var ani_B : ValueAnimator  = ObjectAnimator.ofFloat( v,  "ScaleY", v.scaleY, v.scaleY-0.2f )
                    ani_B.duration = 300
                    ani_B.interpolator = LinearInterpolator()
                    ani_B.repeatMode = REVERSE
                    ani_B.startDelay = 550
                    ani_B.repeatCount= 1

                    set.play(ani_A).with(ani_B)
                    set.start()

                },1000)

            })
            ani_A.start()

        }, 1000)

    }

    abstract  fun  onLoginClick_LoginScene (input_ID : String , input_PW : String , rUtil : ViewUtil?, rViewModel : ViewModel, rCon : initActivity) : Boolean

    abstract  fun  onSignUpClick_LoginScene(rUtil : ViewUtil?, rViewModel : ViewModel, rCon : initActivity)

    abstract  fun  onFindInfoClick_LoginScene(rUtil : ViewUtil?, rViewModel : ViewModel, rCon : initActivity)

    abstract  fun  onPlayCustomAnimation_Splash_TypeA(v : View, v1 : View )

    abstract  fun  onPlayCustomAnimation_Login_TypeA(v : View, v1 : View, v2 : View, v3 : View, v4 : View, v5 : View, v6 : View )

    abstract  fun  onDraw_CUSTUM_VIEW_SPLASH(rUtil : ViewUtil?, rViewModel : ViewModel, rCon : initActivity, rinit : init_data): View?

    abstract  fun  onDraw_CUSTUM_VIEW_LOGIN(rUtil : ViewUtil?, rViewModel : ViewModel, rCon : initActivity, rinit : init_data): View?

    abstract  fun  onDraw_CUSTUM_VIEW_MAIN(rUtil : ViewUtil?, rViewModel : ViewModel, rCon : initActivity, rinit : init_data): View?

    /** [로그인화면_END]---------------------------------------------------------------------------------------------------------------------------------------------------**/

    fun setMain(init : init_data)  {
        if(init.main_view_type == init.CUSTOM)    return
    }

}
