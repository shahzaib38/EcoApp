package image.crystalapps.kecommerce.ui.productselection

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.ui.productselection.fragments.ImageFragmentSelect

class ProductPageAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    val productS :Products?=null

    override fun getItem(position: Int): Fragment {
        return ImageFragmentSelect.newInstance(productS?.productImage?.get(position), true) }
    
    override fun getCount(): Int {
        return productS?.productImage?.size ?:0
    }


}