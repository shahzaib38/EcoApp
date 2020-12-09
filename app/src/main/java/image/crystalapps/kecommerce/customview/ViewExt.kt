package image.crystalapps.kecommerce.customview

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import image.crystalapps.kecommerce.Event
import image.crystalapps.kecommerce.databinding.showSnackBar
import image.crystalapps.kecommerce.extensions.sum
import image.crystalapps.kecommerce.utils.Converters


fun View.setUpSnackBar(lifeCycleOwner : LifecycleOwner ,snackBarEvent : LiveData<Event<Int>>,timeLength :Int ){

    fun View.showSnackbar(snackbarText: String, timeLength: Int) {
        Snackbar.make(this, snackbarText, timeLength).run {
            addCallback(object : Snackbar.Callback() {
                override fun onShown(sb: Snackbar?) {
               //     EspressoIdlingResource.increment()
                }

                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                 //   EspressoIdlingResource.decrement()
                }
            })
            show()
        }
    }


    snackBarEvent.observe(lifeCycleOwner, Observer {event->

        event.getContentIfNotHandled()?.let {

            showSnackbar(context.getString(it), timeLength)

        }


    })





}