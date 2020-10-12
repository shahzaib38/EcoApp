package image.crystalapps.ekommerceAdmin.ui.menfashion

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import image.crystalapps.ekommerceAdmin.BR
import image.crystalapps.ekommerceAdmin.R
import image.crystalapps.ekommerceAdmin.databinding.MenFashionBinding
import image.crystalapps.ekommerceAdmin.model.ColorDescription
import image.crystalapps.ekommerceAdmin.model.MenFashionBean
import image.crystalapps.ekommercelibraries.ui.base.BaseActivity
import image.crystalapps.ekommercelibraries.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class MenFashion  :  BaseActivity<MenFashionViewModel, MenFashionBinding>() , MenFashionNavigator {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    lateinit var  menFashionViewModel :MenFashionViewModel
    private var productType :String =""
    private var menFashionBinding:MenFashionBinding?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN)
              menFashionBinding = getViewDataBinding()
        menFashionViewModel = getViewModel()
        menFashionBinding?.apply {
            viewModel = menFashionViewModel
            menFashionViewModel.setNavigator(this@MenFashion)
            lifecycleOwner = this@MenFashion
        }

        //setUpLiveData()

    }

//
//   private fun setUpLiveData(){
//       getViewModel().getSubmitLiveData().observe(this ,observer)
//    }


    private val observer :Observer<String> = Observer<String> {
    Toast.makeText(this ,it ,Toast.LENGTH_LONG).show()
    }







    override fun getBindingVariable(): Int {
        return  BR.viewModel }

    override fun getLayoutId(): Int {
        return R.layout.activity_men_fashion
    }

    override fun getViewModel(): MenFashionViewModel {
        return  ViewModelProvider(this, viewModelProviderFactory).get(
            MenFashionViewModel::class.java)
    }

    override fun submitData() {
        val fashionBean =      MenFashionBean()
        fashionBean.run {
            menFashionBinding?.also {
                productId = it.titleeditText.text.toString()
             val  titleBool= menFashionViewModel.isTitleEmpty(productId)

                productName = it.productNameeditText.text.toString()
              val productBool=  menFashionViewModel.isProductNameEmpty(productName)

                productDescription = it.descriptioneditText.text.toString()
              val descriptionBool =  menFashionViewModel.isDescriptionEmpty(productDescription)

                productPrize =it.priceditText.text.toString()
                 val priceBool= menFashionViewModel.isPrizeEmpty(productPrize)

                if (titleBool && descriptionBool && productBool && priceBool){
                    Toast.makeText(this@MenFashion, "Working", Toast.LENGTH_LONG).show()


                    productType =this.productType
                    productImageUrl = "pant.lether.jeans.png"

                    val colorDescription = ColorDescription()
                    colorDescription.colorName = "Lila"
                    colorDescription.imageUrl = "lilacolor.jpg"
                    val colorDescriptionArrays: ArrayList<ColorDescription> = ArrayList()
                    colorDescriptionArrays.add(colorDescription)
                    colorsDescription = colorDescriptionArrays

                    sizes = ArrayList()
                    sizes?.add(12)

                }


            }
        }
    }

    override fun setType(productType: String) {
        println(productType)
        this.productType=productType


    }


}
