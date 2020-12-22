package image.crystalapps.kecommerce.utils

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class RxSchedularProvider :
    SchedularProvider {


    override fun io(): Scheduler {

        return Schedulers.io()
    }



    override fun Single(): Scheduler {

        return Schedulers.single()
    }

    override fun newThread(): Scheduler {

        return Schedulers.newThread()
    }

    override fun Trampoline(): Scheduler {
      return  Schedulers.trampoline() }


}