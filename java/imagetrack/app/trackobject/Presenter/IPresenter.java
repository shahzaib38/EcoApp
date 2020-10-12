package imagetrack.app.trackobject.Presenter;

import android.hardware.camera2.CameraAccessException;
import android.os.Handler;
import android.view.TextureView;

import imagetrack.app.trackobject.Model.Cameramodel.CameraTextureView;

public interface IPresenter {

    void OpenCamera(int width ,int height , Handler mBackgroundHandler , CameraTextureView textureView) throws CameraAccessException;

    void LockFocus() throws CameraAccessException;
    void ZoomIt(int progress) throws CameraAccessException;
    void onFocusTouch(float x, float y);
     void  CloseCamera();
    void OpenTorch();
    void CloseTorch();

}
