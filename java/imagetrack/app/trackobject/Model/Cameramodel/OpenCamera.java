package imagetrack.app.trackobject.Model.Cameramodel;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import imagetrack.app.AppSounds.AppSounds;
import imagetrack.app.trackobject.Model.ICameraModel.IOpenCamera;


@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public  final class  OpenCamera extends SurfaceView implements ImageReader.OnImageAvailableListener , IOpenCamera {

    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();
    private static String TAG = OpenCamera.class.getSimpleName();
    private  Context context;
    private  CameraTextureView textureView;
    private  CameraManager cameraManager;
    private  int mState = STATE_PREVIEW;
    private  Rect rect;
    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 90);
        ORIENTATIONS.append(Surface.ROTATION_90, 0);
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180); }

        private CameraCharacteristics characteristics;
    private String CameraId;
    private CameraDevice cameraDevice;
    private ImageReader mImageReader;
    private CameraCaptureSession Capturesession;
    private Handler mBackground;
    private CaptureRequest mPreviewRequest;
    private CaptureRequest.Builder mPreviewRequestBuilder;
    private File file;
    private int mSensorOrientation;
    private Activity activity;
    private int mRotation;
    private DisplayMetrics displayMatrics;
    private AppSounds appSounds;

    public OpenCamera(Context context) {
        super(context);
         displayMatrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMatrics);
        this.context = context;
        activity =(Activity)context;
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        file =new File("ssa" ,"oii.jpg");
        appSounds =new AppSounds(context);
    }


    @Override
    public void CameraOPened(int width, int height, Handler mBackgroundHandler , CameraTextureView textureView) throws CameraAccessException {
        this.mBackground =mBackgroundHandler;
        this.textureView= textureView;
        setUpOutPutCamera(width, height);

            cameraManager = (CameraManager) activity.getSystemService(Context.CAMERA_SERVICE);

            if (context.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                return; }

            cameraManager.openCamera(CameraId, new CameraDevice.StateCallback() {
                @Override
                public void onOpened(@NonNull CameraDevice camera) {
                    cameraDevice=camera;

                    try {
                        ToBeginCamera();


                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onDisconnected(@NonNull CameraDevice camera) {

                }

                @Override
                public void onError(@NonNull CameraDevice camera, int error) {

                }
            }, mBackground);



    }





    @Override
    public void setUpOutPutCamera(int width , int height) throws CameraAccessException {
        cameraManager = (CameraManager) activity.getSystemService(Context.CAMERA_SERVICE);
        Activity activity = (Activity) context;
        if (cameraManager==null) return;
            for (String CameraId : cameraManager.getCameraIdList()) {

                 characteristics
                        = cameraManager.getCameraCharacteristics(CameraId);



                Integer facing = characteristics.get(CameraCharacteristics.LENS_FACING);
                if (facing != null && facing == CameraCharacteristics.LENS_FACING_FRONT) {
                    continue;
                }

                StreamConfigurationMap map = characteristics.get(
                        CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (map == null) {
                    continue;
                }
                Size largest = Collections.max(
                        Arrays.asList(map.getOutputSizes(ImageFormat.JPEG)),
                        new Comparator<Size>() {
                            @Override
                            public int compare(Size lhs, Size rhs) {
                                return Long.signum((long) lhs.getWidth() * lhs.getHeight() -
                                        (long) rhs.getWidth() * rhs.getHeight());
                            }
                        });
                mImageReader = ImageReader.newInstance(displayMatrics.widthPixels, displayMatrics.heightPixels,
                       ImageFormat.JPEG, /*maxImages*/1);

                mImageReader.setOnImageAvailableListener(
                        this, mBackground);


                int displayRotation =activity.getWindowManager().getDefaultDisplay().getRotation();

                    mSensorOrientation = characteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);

            boolean swapdimension=false;

            switch (displayRotation){

                   case Surface.ROTATION_0:
                   case Surface.ROTATION_180:

                       if (mSensorOrientation  == 90 || mSensorOrientation==180 ){


                   //        swapdimension=true;
                       }

                       break;

                case Surface.ROTATION_90:
                case Surface.ROTATION_270:
                    if (mSensorOrientation ==0 || mSensorOrientation ==180){
                        swapdimension=true; }
                    break;
                    default: }




           Point displaySize=new Point();
            activity.getWindowManager().getDefaultDisplay().getSize(displaySize);

            int rotatedPreviewWidth =width;
            int rotatedPreviewHeight=height;


                int maxPreviewWidth =displaySize.x;
                int maxPreviewHeight=displaySize.y;


                if(swapdimension){
                    rotatedPreviewWidth =height;
                    rotatedPreviewHeight=width;

                    maxPreviewWidth=displaySize.y;
                    maxPreviewHeight=displaySize.x;


                }


                if (maxPreviewWidth>MAX_PREVIEW_WIDTH){
                    maxPreviewWidth=MAX_PREVIEW_WIDTH;
                }

                if (maxPreviewHeight>MAX_PREVIEW_HEIGHT){
                    maxPreviewHeight=MAX_PREVIEW_HEIGHT;
                }





                  Size size =new Size(displayMatrics.widthPixels,displayMatrics.heightPixels);

                Size[] sizes ={size};

                /*
                mPreviewSize = chooseOptimalSize(sizes,
                        rotatedPreviewWidth, rotatedPreviewHeight, maxPreviewWidth,
                        maxPreviewHeight, largest);

               int orientation = getResources().getConfiguration().orientation;

                if (displayRotation == Configuration.ORIENTATION_LANDSCAPE) {


                   textureView.setAspectRatio(
                           displayMatrics.widthPixels, displayMatrics.heightPixels);
                } else {

                    textureView.setAspectRatio(
                            displayMatrics.widthPixels, displayMatrics.heightPixels);
                }

                */





            this.CameraId =CameraId;
            }// For Loop end

         //if condition end



    } //setUpOutputMethod End




    @Override
    public void ToBeginCamera() throws CameraAccessException {
        SurfaceTexture texture = textureView.getSurfaceTexture();
        if (texture == null) {
            return;
        }

        Surface surface = new Surface(texture);
        mPreviewRequestBuilder
                = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);

        mPreviewRequestBuilder.addTarget(surface);

        cameraDevice.createCaptureSession(Arrays.asList(surface, mImageReader.getSurface()), new CameraCaptureSession.StateCallback() {
            @Override
            public void onConfigured(@NonNull CameraCaptureSession session) {
                if (null == cameraDevice) {
                    return;
                }
                Capturesession = session;

                mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE,
                        CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE);

                mPreviewRequest = mPreviewRequestBuilder.build();
                try {
                    session.setRepeatingRequest(mPreviewRequest,
                            new CameraCapture(), mBackground);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onConfigureFailed(@NonNull CameraCaptureSession session) {

            }
        }, mBackground);

        }










    /******* IMAGE AVAILABLE **********/
    @Override
    public void onImageAvailable(final ImageReader reader) {
        Log.i(TAG, "onImageAvailable: "+Thread.currentThread().getName());
    //   Image image= reader.acquireNextImage();

        /*
        if (cropImageView==null){
            cropImageView=new CropImageView(context);

        }
*/
     mBackground.post(new ImageSaver(reader.acquireLatestImage(),file,mRotation,context));





/*
       cropImageView =new CropImageView(context);
                  try {

                  cropImageView.ImageCroppperSettings(reader.acquireLatestImage());

              } catch (UnsupportedEncodingException e) {
                  e.printStackTrace();
              }


 */


    }


    @Override
    public void LockFocus() throws CameraAccessException {
            mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER,
                    CameraMetadata.CONTROL_AF_TRIGGER_START);
            mState = STATE_WAITING_LOCK;
            Capturesession.capture(mPreviewRequestBuilder.build(), new CameraCapture(), mBackground);
    }



    @Override
    public void TskePicture() throws CameraAccessException { LockFocus(); }

   @Override
    public void CaptureRandomImage() throws CameraAccessException {
        final Activity activity = (Activity) context;
        if (null == activity || null == cameraDevice) {
            return;
        }
        final CaptureRequest.Builder captureBuilder =
                cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
        captureBuilder.addTarget(mImageReader.getSurface());


       captureBuilder.set(CaptureRequest.SCALER_CROP_REGION,rect);


       captureBuilder.set(CaptureRequest.CONTROL_AF_MODE,
                CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE);
         mRotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        captureBuilder.set(CaptureRequest.JPEG_ORIENTATION, getOrientation(mRotation));
        Capturesession.stopRepeating();
        Capturesession.abortCaptures();
        Capturesession.capture(captureBuilder.build(),new CameraCapture(), mBackground);

       appSounds.setCameraShutterSound();
    }



    @Override
    public int getOrientation(int rotation){
        return (ORIENTATIONS.get(rotation) + mSensorOrientation + 270) % 360; }








    @Override
    public void ZoomIt(int progress) throws CameraAccessException {
         rect=  getZoomRect(progress);
        Log.i(TAG, "ZoomIt: "+rect);

      if(rect!=null){
              mPreviewRequestBuilder.set(CaptureRequest.SCALER_CROP_REGION, rect);
              Capturesession.setRepeatingRequest(mPreviewRequestBuilder.build(), new CameraCapture(), mBackground); }
    }







    @Override
    public Rect   getZoomRect(float zoomLevel) {
        Rect mCropRegion = new Rect();

        float maxZoom = (characteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)) * 10;
        Rect activeRect = characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);

        Log.i(TAG, "getZoomRect: "+zoomLevel);
        Log.i(TAG, "MaxZoomRect: "+maxZoom);
        if ((zoomLevel <= maxZoom) && (zoomLevel > 1)) {
            int minW = (int) (activeRect.width() / maxZoom);
            int minH = (int) (activeRect.height() / maxZoom);
            int difW = activeRect.width() - minW;
            int difH = activeRect.height() - minH;
            int cropW = difW / 100 * (int) zoomLevel;
            int cropH = difH / 100 * (int) zoomLevel;
            cropW -= cropW & 3;
            cropH -= cropH & 3;

          //  mCropRegion.set(cropW, cropH, activeRect.width() - cropW, activeRect.height() - cropH);

            // mCropRegion.set(centerX - deltaX,
            //       centerY - deltaY,
            //       centerX + deltaX,
            //       centerY + deltaY);
            //   }

            return new Rect(cropW, cropH, activeRect.width() - cropW, activeRect.height() - cropH);
        }else if(zoomLevel == 0){
            return new Rect(0, 0, activeRect.width(), activeRect.height());
        }


        return null;
    }
   // public static float clamp(float val, float min, float max) {
    //    return Math.max(min, Math.min(max, val)); }


    @Override
    public void OnFocusTouch(float x, float y) {
        try {
            mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER,
                    CameraMetadata.CONTROL_AF_TRIGGER_START);


            Capturesession.capture(mPreviewRequestBuilder.build(), new CameraCapture(),
                    mBackground);
            Log.i(TAG, "OnFocusTouch: ");
      //      appSounds.setCameraFocusSound();
        } catch (Exception e) {
            Log.i(TAG, "OnFocusTouch: "+e.getMessage()); } }




    public class CameraCapture extends CameraCaptureSession.CaptureCallback{
        @Override
        public void onCaptureStarted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, long timestamp, long frameNumber) {
            super.onCaptureStarted(session, request, timestamp, frameNumber);
        }

        @Override
        public void onCaptureProgressed(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull CaptureResult partialResult) {

            process(partialResult);
        }

        @Override
        public void onCaptureCompleted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result) {
         super.onCaptureCompleted(session, request, result);

           process(result);
        }

       private void process(CaptureResult result) {

            switch (mState){
                case STATE_PREVIEW:
                    // We have nothing to do when the camera preview is working normally.

                    break;


                    case STATE_WAITING_LOCK:
                        Integer afState =result.get(TotalCaptureResult.CONTROL_AF_STATE);
                       if (afState==null){

                     try {

                         CaptureRandomImage();
                     } catch (CameraAccessException e) {

                         Log.i(TAG, "process: "+e.getMessage()); }
                 }else if(CaptureRequest.CONTROL_AF_STATE_FOCUSED_LOCKED==afState ||
                      CaptureRequest.CONTROL_AF_STATE_NOT_FOCUSED_LOCKED==afState){



                     Integer aeState = result.get(CaptureResult.CONTROL_AE_STATE);
                     if (aeState == null ||
                             aeState == CaptureResult.CONTROL_AE_STATE_CONVERGED) {
                         mState = STATE_PICTURE_TAKEN;


                         try {
                             CaptureRandomImage();
                         } catch (CameraAccessException e) {
                         //    e.printStackTrace();

                         }
                     } else {
                         runPrecaptureSequence();
                     }
                       }

                 break;

                case STATE_WAITING_PRECAPTURE:
                    // CONTROL_AE_STATE can be null on some devices
                    Integer aeState = result.get(CaptureResult.CONTROL_AE_STATE);
                    if (aeState == null ||
                            aeState == CaptureResult.CONTROL_AE_STATE_PRECAPTURE ||
                            aeState == CaptureRequest.CONTROL_AE_STATE_FLASH_REQUIRED) {
                        mState = STATE_WAITING_NON_PRECAPTURE;
                    }
                    break;





                case STATE_WAITING_NON_PRECAPTURE:
                    // CONTROL_AE_STATE can be null on some devices
                    Integer aeeState = result.get(CaptureResult.CONTROL_AE_STATE);
                    if (aeeState == null || aeeState != CaptureResult.CONTROL_AE_STATE_PRECAPTURE) {
                        mState = STATE_PICTURE_TAKEN;
                        try {
                            CaptureRandomImage();
                        } catch (CameraAccessException e) {
                            Log.i(TAG, "State Wait : "+e.getMessage()); }
                    }break;

                    case STATE_PICTURE_TAKEN:
                     unlockFocus();
                     break;
            } }






    @Override
        public void onCaptureFailed(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull CaptureFailure failure) {
            super.onCaptureFailed(session, request, failure); }




    }

    @Override
    public void runPrecaptureSequence() {
        try {
            // This is how to tell the camera to trigger.
            mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER,
                    CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER_START);
            // Tell #mCaptureCallback to wait for the precapture sequence to be set.
            mState = STATE_WAITING_PRECAPTURE;
            Capturesession.capture(mPreviewRequestBuilder.build(), new CameraCapture(),
                    mBackground);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }




    @Override
    public void unlockFocus() {
        try {
            // Reset the auto-focus trigger
            mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER,
                    CameraMetadata.CONTROL_AF_TRIGGER_CANCEL);

            Capturesession.capture(mPreviewRequestBuilder.build(), new CameraCapture(),
                    mBackground);
            // After this, the camera will go back to the normal state of preview.
         mState = STATE_PREVIEW;
            Log.i(TAG, "unlockFocus: "+rect);
            mPreviewRequestBuilder.set(CaptureRequest.SCALER_CROP_REGION,rect);

            Capturesession.setRepeatingRequest(mPreviewRequestBuilder.build(), new CameraCapture(),
                    mBackground);
        } catch (CameraAccessException e) {
            e.printStackTrace();
            Log.i(TAG, "unlockFocus: " +e.getMessage());
        }
    }







    @Override
    public void CloseCamera(){
        if (null != Capturesession) {
            Capturesession.close();
            Capturesession = null; }

        if (null != cameraDevice) {
            cameraDevice.close();
            cameraDevice = null; }

        if (null != mImageReader) {
            mImageReader.close();
            mImageReader = null;
        }


    }

    @Override
    public void OpenTorch() {
        if (mPreviewRequestBuilder==null)return;
        try {

                    mPreviewRequestBuilder.set(CaptureRequest.FLASH_MODE, CaptureRequest.FLASH_MODE_TORCH);
                    mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AE_MODE_ON);

                Capturesession.setRepeatingRequest(mPreviewRequestBuilder.build(), null, null);

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void CloseTorch() {
        if (mPreviewRequestBuilder==null)return;
        try {
            mPreviewRequestBuilder.set(CaptureRequest.FLASH_MODE, CaptureRequest.FLASH_MODE_OFF);
            Capturesession.setRepeatingRequest(mPreviewRequestBuilder.build(), null, null);


        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }





/*
    static class CompareSizesByArea implements Comparator<Size> {

        @Override
        public int compare(Size lhs, Size rhs) {
            // We cast here to ensure the multiplications won't overflow
            return Long.signum((long) lhs.getWidth() * lhs.getHeight() -
                    (long) rhs.getWidth() * rhs.getHeight());
        }

    }
*/









/*
    // Give
    private  Size chooseOptimalSize(Size[] choices, int textureViewWidth,
                                    int textureViewHeight, int maxWidth, int maxHeight, Size aspectRatio) {

        // Collect the supported resolutions that are at least as big as the preview Surface
        List<Size> bigEnough = new ArrayList<>();
        // Collect the supported resolutions that are smaller than the preview Surface
        List<Size> notBigEnough = new ArrayList<>();
        int w = aspectRatio.getWidth();
        int h = aspectRatio.getHeight();


        for (Size option : choices) {


            if (option.getWidth() <= maxWidth && option.getHeight() <= maxHeight &&

                    option.getHeight() == option.getWidth() * h / w) {


                if (option.getWidth() >= textureViewWidth &&
                        option.getHeight() >= textureViewHeight) {
                    bigEnough.add(option);
                } else {
                    notBigEnough.add(option);
                }
            }
        }

        if (bigEnough.size() > 0) {
            return Collections.min(bigEnough, new OpenCamera.CompareSizesByArea());
        } else if (notBigEnough.size() > 0) {

            return Collections.max(notBigEnough, new OpenCamera.CompareSizesByArea());
        } else {
            return choices[0];
        }
    }
 */



}
