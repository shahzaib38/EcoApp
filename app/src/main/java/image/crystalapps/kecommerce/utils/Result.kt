package image.crystalapps.kecommerce.utils

import java.lang.Exception


sealed class Result<out R> {


    data class Success<out T>(val data :T):Result<T>()
    data class Error(val exception : Exception) :Result<Nothing>()

    val Result<*>.succeeded get() = this is Success && data!=null


}