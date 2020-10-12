package image.crystalapps.kecommerce.utils.rx

import io.reactivex.rxjava3.core.Scheduler

interface SchedularProvider {


    fun io() :Scheduler
    fun Single() :Scheduler
    fun newThread() :Scheduler
    fun Trampoline() :Scheduler



}