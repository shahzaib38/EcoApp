package image.crystalapps.ekommerceAdmin.databinding

import android.text.InputType
import android.widget.Toast
import androidx.appcompat.view.menu.MenuAdapter
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import image.crystalapps.ekommerceAdmin.R
import image.crystalapps.ekommerceAdmin.adapter.MenFashionAdapter
import kotlinx.android.synthetic.main.activity_men_list.view.*


@BindingAdapter("checkError")
fun titleCheckErrors(editText: TextInputEditText, check :Boolean ){

   when(editText.id){
        R.id.titleeditText-> check(editText ,check ,"Title 1")
        R.id.descriptioneditText-> check(editText ,check ,"Description 1")
        R.id.productNameeditText->check(editText ,check ,"Product Name 1")
        R.id.priceditText->check(editText ,check ,"PRice Name 1") } }

fun check(editText: TextInputEditText ,check: Boolean ,text :String){
    if (!check) {
        Toast.makeText(editText.context, text, Toast.LENGTH_LONG).show() }

}





@BindingAdapter("numberKeyboard")
fun changeKeyBoardLayout(editText : TextInputEditText ,selection :Boolean){
    if (selection){ editText.inputType = InputType.TYPE_CLASS_NUMBER}

}



@BindingAdapter("adapter")
fun setAdapter(recyclerView :RecyclerView ,adapter:MenFashionAdapter){

    recyclerView.menFashionRecyclerview.layoutManager = LinearLayoutManager(recyclerView.context)
 //   recyclerView.menFashionRecyclerview.adapter = adapter

}


