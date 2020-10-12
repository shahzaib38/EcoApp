package imagetrack.app.trackobject.Presenter;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.os.Handler;
import imagetrack.app.trackobject.Model.Cameramodel.CameraTextureView;
import imagetrack.app.trackobject.Model.Cameramodel.OpenCamera;

public final class Presenter implements IPresenter {

   private OpenCamera openCamera;

    public Presenter(Context context){
        openCamera =new OpenCamera(context); }

    @Override
    public void OpenCamera(int width, int height, Handler mBackgroundHandler, CameraTextureView textureView) {
        try { openCamera.CameraOPened(width, height,mBackgroundHandler,textureView);
        } catch (CameraAccessException e) {
            e.printStackTrace(); } }

    @Override
    public void LockFocus() throws CameraAccessException {
        openCamera.TskePicture(); }

    @Override
    public void ZoomIt(int progress) throws CameraAccessException {
        openCamera.ZoomIt(progress); }

    @Override
    public void onFocusTouch(float x, float y) {
        openCamera.OnFocusTouch(x,y);}

    @Override
    public void CloseCamera() {
        openCamera.CloseCamera();
    }

    @Override
    public void OpenTorch() {
        openCamera.OpenTorch();
    }

    @Override
    public void CloseTorch() {
        openCamera.CloseTorch();
    }


}
