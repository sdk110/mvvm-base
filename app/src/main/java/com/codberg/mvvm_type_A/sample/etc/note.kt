package com.codberg.mvvm_type_A.sample.etc

import android.view.View
import com.libs.cutil_kotlin.ViewUtil

//    fun testSnackBar()  {
//
//        Snackbar.make(main_activity_search_recycler_view, "Hello World", Snackbar.LENGTH_LONG).show();
//    }
//
//    fun testProgressBar()  {
//
//        val dialog = progressDialog(message = "Please wait a bit…", title = "Fetching data")
//        dialog.show()
//    }
//
//    fun testScene()  {
//
//        val lp = FrameLayout.LayoutParams(
//            LinearLayout.LayoutParams.MATCH_PARENT,
//            LinearLayout.LayoutParams.MATCH_PARENT
//        )
//        addContentView(layoutManager(this).getView_1(), lp)
//
//    }


//private fun dpToPx(dp: Float): Int {
//    val density = con
//        .displayMetrics
//        .density
//    return Math.round(dp * density)
//}

//    override val layoutResourceId: Int get() = R.layout.activity_main.



/**
 *
 *  [sample_code]
 *
fun setButton(event:() -> Unit) {

//set onClickListener
//        con.findViewById<Button>(R.id.main_activity_search_button_1).setOnClickListener{ con.mPopupViewManager!!.showViewA() }
con.findViewById<Button>(R.id.main_activity_search_button_1).setOnClickListener{ event() }

}

fun setList()  {

//set onCreateListener
var onCreateListener_model_A : GeneralPerposeRecyclerViewAdapter.createViewListener = object : GeneralPerposeRecyclerViewAdapter.createViewListener  {

override fun onCreate(ui: AnkoContext<ViewGroup>): View = with(ui) {

verticalLayout {
lparams(matchParent, wrapContent)
padding = dip(16)

imageView {
id = R.id.test_item_img
layoutParams = LinearLayout.LayoutParams(dip(100), dip(100))
}

textView {
id = R.id.test_item_text
layoutParams = LinearLayout.LayoutParams(dip(100), dip(50))
text = "test"
textSize = 16f // <- it is sp, no worries
textColor = Color.BLACK
}
}

}
}

//set onBindListener
var onBindListener_model_A : GeneralPerposeRecyclerViewAdapter.bindListener = object : GeneralPerposeRecyclerViewAdapter.bindListener {

override fun onBind(holder: RecyclerView.ViewHolder, position: Int, data : Any, baseContext : Context) {
holder.itemView.run {
var item : listTypeData_Response = data as listTypeData_Response

//print
var t1 : TextView = findViewById<TextView>(R.id.test_item_text)
var i1 : ImageView = findViewById<ImageView>(R.id.test_item_img)

t1.text = item.name
ImageLoader().init_data(baseContext,200,200).setPath(R.drawable.ic_image_black_24dp).setImage_SPLASH(i1)

//click
setOnClickListener {baseContext.toast("position : $position")}
}
}

}

//set observing
viewModel.listType_ResponseLiveData.observe(con,
Observer {
it.forEach { document -> AdapterforListA!!.addItem(document) }
AdapterforListA!!.notifyDataSetChanged()
}
)

//set onClickListener
con.findViewById<Button>(R.id.main_activity_search_button).setOnClickListener  {  viewModel.notifyListTypeData(ViewModel.GET)  }

//set Adapter
con.findViewById<RecyclerView>(R.id.main_activity_search_recycler_view).run {
AdapterforListA!!.setOnCreateViewListener(onCreateListener_model_A)
AdapterforListA!!.setOnBindListener(onBindListener_model_A)
adapter = AdapterforListA
layoutManager = StaggeredGridLayoutManager(3, 1).apply {
gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
orientation = StaggeredGridLayoutManager.VERTICAL
}
setHasFixedSize(true)
}

}
 **/

/**
getViewUtil()!!.addView(this,"a", init.login_Type_A_parrent, ViewUtil.ANIMATION_FADE_IN, ViewUtil.ANIMATION_FADE_OUT,object : ViewUtil.addViewInitListener  {
    override fun setView(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRemove() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
} )
        **/