package imagetrack.app.trackobject.Model.Cameramodel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import javax.xml.transform.Result;

import imagetrack.app.trackobject.Constants.Constants;


public class NetworkWork extends Worker {

    Context conext;
    String TAG =NetworkWork.class.getSimpleName();

    public NetworkWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);

        this.conext=context;
    }

    @NonNull
    @Override

    public Result doWork() {



            return Result.success();
  


    }

}
