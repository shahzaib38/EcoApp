package image.crystalapps.kecommerce.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class NotificationWorkManager(appContext: Context ,workerParams: WorkerParameters) :CoroutineWorker(appContext ,workerParams) {


    override suspend fun doWork(): Result {

     val value=   inputData.getString("file_path")

        println("value $value")

        return Result.success()
    }



}