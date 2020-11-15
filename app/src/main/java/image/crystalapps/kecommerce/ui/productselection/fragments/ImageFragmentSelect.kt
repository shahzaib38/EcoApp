package image.crystalapps.kecommerce.ui.productselection.fragments

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.ImageFragmentDataBinding
import image.crystalapps.kecommerce.databinding.ImageSelectDataBinding
import image.crystalapps.kecommerce.databinding.ImageSelectItemDataBinding
import image.crystalapps.kecommerce.ui.base.BaseFragment
import image.crystalapps.kecommerce.ui.productselection.ProductViewModel



@AndroidEntryPoint
class ImageFragmentSelect :BaseFragment<ProductViewModel , ImageSelectDataBinding>() {


    companion object {

        private const val IMAGE = "image"
        private var imageSelectDataBinding :ImageSelectDataBinding?=null

        fun newInstance(image: String?, isFullscreenMode: Boolean): ImageFragmentSelect {
            val fragment = ImageFragmentSelect()
            val args = Bundle()
            args.putString(IMAGE, image)
            fragment.arguments = args
            return fragment
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageSelectDataBinding = getViewDataBinding()
        val images=      arguments?.let { it.get(IMAGE) }
        imageSelectDataBinding?.imagedata?.setImageURI(Uri.parse(images.toString()))

    }


    val mViewModel by  viewModels<ProductViewModel>()

    override fun getBindingVariable(): Int  =BR.viewModel

    override fun getLayoutId(): Int  = R.layout.imageselect_layout

    override fun getViewModel(): ProductViewModel =mViewModel


}