package image.crystalapps.kecommerce.ui.productselection.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import image.crystalapps.kecommerce.model.Products

class ImagePagerAdapter(val products: Products,fragmentManager: FragmentManager) :FragmentStatePagerAdapter(fragmentManager) {


    override fun getItem(position: Int): Fragment {
       return   ImageFragmentSelect.newInstance(products.productImage?.get(position),true)
    }

    override fun getCount(): Int {
        return products.productImage?.size?:0

    }


}