package image.crystalapps.kecommerce

import android.app.Activity
import android.os.Bundle
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.LockSupport

class TestingActivity: Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)




        foo()

    }



    fun ordinaryFunction(block : ()->Unit){
        println("hi")
    }


    fun foo(){
        println("1")
        ordinaryFunction {
            return@ordinaryFunction

        }


        println("2")
    }





}