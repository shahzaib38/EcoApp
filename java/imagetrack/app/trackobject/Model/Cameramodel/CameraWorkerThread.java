package imagetrack.app.trackobject.Model.Cameramodel;

import android.hardware.camera2.CameraAccessException;
import android.os.Handler;
import android.util.Log;

public class CameraWorkerThread implements Runnable{

    OpenCamera openCamera ;

    int width;
    int height;
    Handler mBackgroundHandler;
    CameraTextureView textureView;
    String TAG =CameraWorkerThread.class.getSimpleName();
    public CameraWorkerThread(OpenCamera openCamera, int width, int height, Handler mBackgroundHandler, CameraTextureView textureView){

        this.openCamera=openCamera;

        this.width=width;
        this.height=height;
        this.mBackgroundHandler=mBackgroundHandler;
        this.textureView=textureView;



    }

    @Override
    public void run() {

        try {
            openCamera.CameraOPened(width, height,mBackgroundHandler,textureView);
        } catch (CameraAccessException e) {
            e.printStackTrace();

            Log.i(TAG, "Take Picture Thread: "+e.getMessage());

        }
    }
}
