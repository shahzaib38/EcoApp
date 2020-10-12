package imagetrack.app.trackobject.Model.ICameraModel;

import android.Manifest;
import android.content.Context;

public interface ICameraFragment {

    int REQUEST_CAMERA_PERMISSION =9981 ;
    String CAMERAARRAY[]=new String[]{Manifest.permission.CAMERA ,Manifest.permission.RECORD_AUDIO};

    void startBackgroundThread();
    void stopBackgroundThread();
    void requestCameraPermission();
    boolean hasPermissions(Context context, String[] permissions);
}
