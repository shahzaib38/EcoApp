package image.crystalapps.kecommerce

import androidx.lifecycle.Observer

class Event<out T> (private  val content :T) {


    var hasBeenVisible =false
    private set



    fun getContentIfNotHandled() :T?{

        return if(hasBeenVisible){

            null
        }
        else{
            hasBeenVisible =true

            content }
    }



    fun peekContent() :T =content

    class EventOberver<T>(private  val onEventUnHandledContent : (T) ->Unit ) : Observer<Event<T>> {
        override fun onChanged(event : Event<T>?) {

            event?.getContentIfNotHandled()?.let {
                onEventUnHandledContent(it)
            }

        }


    }





}