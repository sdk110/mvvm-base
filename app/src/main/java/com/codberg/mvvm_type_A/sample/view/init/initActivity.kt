package com.codberg.mvvm_type_A.sample.view.init

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import com.codberg.mvvm_type_A.sample.view.MainViewManager

import android.os.Bundle
import androidx.core.animation.addListener
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import com.libs.cutil_kotlin.BaseKotlinActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.codberg.mvvm_type_A.sample.viewmodel.ViewModel
import com.libs.cutil_kotlin.BasicUtil
import org.jetbrains.anko.contentView

open class initActivity : BaseKotlinActivity<ViewModel>() {

    lateinit var initViewManager : MainViewManager
    lateinit var init : init_data
    var isDraw : Boolean = false
    override val viewModel: ViewModel by viewModel()

    override fun onRemove(): Int = 3
    override fun onBackground(): Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        process()
    }

    fun setView() {

        when(init.layout_config)  {

            in (0..1) -> {
                if(init.splash_view_type == init.TYPE_A)    setContentView(init.getSplash_TYPE_A(baseContext))
                else                                        setContentView(initViewManager.customView_SPLASH)
            }

            2 -> {
                if( init.login_view_type       == init.TYPE_A )  setContentView(init.getLogin_TYPE_A(baseContext))
                else if( init.login_view_type  == init.TYPE_B )  setContentView(init.getLogin_TYPE_B(baseContext))
                else                                             setContentView(initViewManager.cutomView_LOGIN)
            }

            3 -> {
                if( init.main_view_type       == init.TYPE_A )   setContentView(init.getMain_TYPE_A(baseContext))
                else                                             setContentView(initViewManager.customView_MAIN)
            }

        }

    }

    fun process()  {

        if(isDraw) return
        isDraw = true

        init = init_data(this)
        initViewManager = MainViewManager(getViewUtil(),viewModel,this, init)

        setView()

        when(init.layout_config)  {
            in (0..1) -> nextScene()
            2 -> initViewManager.setLogin(init)
            3 -> initViewManager.setMain(init)
        }
    }

    fun nextScene()  {

        initViewManager.setSplash()
        BasicUtil.DelayExecute(BasicUtil.DelayExecuteLitener {
            setLoginScene()
        },init.splash_delay_time)

    }

    fun setLoginScene()  {

        playTransition {

            when(init.layout_config)  {

                0 ->  {
                    if( init.login_view_type       == init.TYPE_A )  setContentView(init.getLogin_TYPE_A(baseContext))
                    else if( init.login_view_type  == init.TYPE_B )  setContentView(init.getLogin_TYPE_B(baseContext))
                    else                                             setContentView(initViewManager.cutomView_LOGIN)
                }

                in (1..2) ->  {
                    if( init.main_view_type == init.TYPE_A )   setContentView(init.getMain_TYPE_A(baseContext))
                    else                                      setContentView(initViewManager.customView_MAIN)
                }

            }

            when(init.layout_config)  {
                0 -> initViewManager.setLogin(init)
                in (1..2) -> initViewManager.setMain(init)
            }

        }

    }

    fun setMainScene()  {

        playTransition {

            if( init.main_view_type       == init.TYPE_A )   setContentView(init.getMain_TYPE_A(baseContext))
            else                                             setContentView(initViewManager.customView_MAIN)

            initViewManager.setMain(init)

        }

    }

    fun playTransition(rFunction : () -> Unit)  {

        when(init.layout_transition_type)  {

            init.TYPE_A ->  {

                var a : ValueAnimator = ObjectAnimator.ofFloat( contentView,  "alpha", 1.0f, 0.0f )
                a.setDuration(450)
                a.setInterpolator(FastOutLinearInInterpolator())
                a.addListener(onEnd = {

                    rFunction()
                    contentView!!.alpha =0.0f
                    var b : ValueAnimator = ObjectAnimator.ofFloat( contentView,  "alpha", 0.0f, 1.0f )
                    b.setDuration(450)
                    b.setInterpolator(FastOutLinearInInterpolator())
                    BasicUtil.DelayExecute(BasicUtil.DelayExecuteLitener { b.start() }, 0)

                })
                a.start()

            }

            init.DATA_NONE ->  {

                rFunction()

            }

        }

    }

}
