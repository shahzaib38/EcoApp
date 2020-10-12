package imagetrack.app.trackobject.Model.ICameraModel;

import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureResult;
import android.os.Handler;
import android.view.TextureView;

import imagetrack.app.trackobject.Model.Cameramodel.CameraTextureView;

public interface IOpenCamera {

      //Variables
      //START
       int STATE_PREVIEW = 0;
       int STATE_WAITING_LOCK = 1;
       int STATE_WAITING_PRECAPTURE = 2;
       int STATE_WAITING_NON_PRECAPTURE = 3;
       int STATE_PICTURE_TAKEN = 4;

      //END
       int MAX_PREVIEW_WIDTH = 1920;
       int MAX_PREVIEW_HEIGHT = 1080;




      void OnFocusTouch(float x, float y);
      void CameraOPened(int width, int height, Handler mBackgroundHandler , CameraTextureView textureView)throws CameraAccessException;
      void setUpOutPutCamera(int width , int height) throws CameraAccessException;
      void ToBeginCamera() throws CameraAccessException;
      void TskePicture() throws CameraAccessException;
      int getOrientation(int rotation);
      void CaptureRandomImage() throws CameraAccessException;
      Rect getZoomRect(float zoomlevel);
      void ZoomIt(int progress) throws CameraAccessException;
      void LockFocus() throws CameraAccessException;
      void runPrecaptureSequence();
      void unlockFocus();
      void CloseCamera();
      void OpenTorch();
       void CloseTorch();
}
