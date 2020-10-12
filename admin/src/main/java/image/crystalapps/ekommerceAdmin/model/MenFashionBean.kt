package image.crystalapps.ekommerceAdmin.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import image.crystalapps.ekommerceAdmin.BR

class MenFashionBean  :BaseObservable(){

     @Bindable
     var productId :String =""
          get() = field

       set(value) {
          field=value

      notifyPropertyChanged(BR.productId)

       }


    @Bindable
    var productPrize :String =""




    @Bindable
     var productName :String=""
         get()=field

    set(value){
        field=value
    notifyPropertyChanged(BR.productName)
    }

    @Bindable
     var productDescription :String =""
         get() = field
         set(value) {
             field=value

         notifyPropertyChanged(BR.productDescription)
         }




    @Bindable
     var productType :String =""
         get() = field
        set(value){
            field =value
        notifyPropertyChanged(BR.productType)
        }




     var productImageUrl =""

     var sizes :ArrayList<Int>? = null

     var colorsDescription :ArrayList<ColorDescription>?=null




}