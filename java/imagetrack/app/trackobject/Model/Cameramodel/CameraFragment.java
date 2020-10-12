package imagetrack.app.trackobject.Model.Cameramodel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import imagetrack.app.SaveSharedPreferences.LanguageSavePreference;
import imagetrack.app.trackobject.Constants.Constants;
import imagetrack.app.trackobject.Model.ICameraModel.ICameraFragment;
import imagetrack.app.trackobject.Presenter.IPresenter;
import imagetrack.app.trackobject.Presenter.Presenter;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.GetandSetTraslateApis.LanguageSupportmodel;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.TranslateFragment.LanguageRequestView;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.TranslateRetrofit.SharedViewmodel;


public final class CameraFragment extends Fragment implements TextureView.SurfaceTextureListener, View.OnClickListener ,AppCompatSeekBar.OnSeekBarChangeListener , ICameraFragment {

    private IPresenter iPresenter;
    private HandlerThread mBackgroundThread;
    private ImageView imageButton;
    private CameraTextureView cameraTextureView;
    private Handler mBackgroundHandler;
    private String TAG =CameraFragment.class.getSimpleName();
    private AppCompatSeekBar appCompatSeekBar;
    private int progress;
    private TextView  languageTextview;
    private ImageView dropdownimage;
    private ConnectivityManager connectivityManager;
    private TorchMode torchMode=TorchMode.FLASHON;
    private  ImageView FlashMode;
   private CameraFragment(){}
    public  static CameraFragment newInstance(){
        return new CameraFragment();}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cameraTextureView =view.findViewById(R.id.surfacetexture);
        appCompatSeekBar =view.findViewById(R.id.seekbar);
        dropdownimage =view.findViewById(R.id.dropImageview);
        cameraTextureView.setSurfaceTextureListener(this);
        iPresenter =new Presenter(getActivity());
        languageTextview =view.findViewById(R.id.languagevalue);
        imageButton =view.findViewById(R.id.picture);
        appCompatSeekBar.setOnSeekBarChangeListener(this);
        imageButton.setOnClickListener(this);
        dropdownimage.setOnClickListener(this);
        if (getActivity()!=null){ connectivityManager = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);}

         FlashMode =view.findViewById(R.id.flashmode);
        FlashMode.setOnClickListener(this);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_manager,container ,false); }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SharedViewmodel model = ViewModelProviders.of(getActivityNonNull()).get(SharedViewmodel.class);

        model.getliveData().observe(getViewLifecycleOwner(),new Observer<LanguageSupportmodel>() {
            @Override
            public void onChanged(LanguageSupportmodel s) {
                LanguageSavePreference languageSavePreference=  LanguageSavePreference.getPrefeerencesInstance(getActivity());
                languageTextview.setText(s.getName() );
                languageSavePreference.setValue(s); }});




    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        if (!hasPermissions(getActivity(),CAMERAARRAY))
        { requestCameraPermission();return; }

        try {
            iPresenter.OpenCamera(width,height,mBackgroundHandler,cameraTextureView);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) { }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false; }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) { }

    @Override
    public void startBackgroundThread() {
        mBackgroundThread = new HandlerThread("CameraBackground");
        mBackgroundThread.start();
        mBackgroundHandler = new Handler(mBackgroundThread.getLooper());
    }



     @Override
    public void stopBackgroundThread() {
            mBackgroundThread.quitSafely();
        try {
            mBackgroundThread.join();
            mBackgroundThread = null;
            mBackgroundHandler = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } }

    @Override
    public void onResume() {
        super.onResume();

        appCompatSeekBar.setProgress(0);
        startBackgroundThread();

        if (cameraTextureView.isAvailable()) {
            try {
                iPresenter.OpenCamera(cameraTextureView.getWidth(), cameraTextureView.getHeight() ,mBackgroundHandler,cameraTextureView);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        } else {
            cameraTextureView.setSurfaceTextureListener(this);
        }
    }

    @Override
    public void requestCameraPermission() {
        requestPermissions(CAMERAARRAY, REQUEST_CAMERA_PERMISSION);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onPause() {
        stopBackgroundThread();
        super.onPause();
        iPresenter.CloseTorch();
        iPresenter.CloseCamera();
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        iPresenter.CloseCamera();

        cameraTextureView =null;
        appCompatSeekBar =null;
        dropdownimage =null;
        iPresenter =null;
        languageTextview =null;
        imageButton =null;
        Log.i(TAG, "onDestroy: "); }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.picture:
                if (getActivity() == null) { return; }
                //  try {
                //    iPresenter.LockFocus();}catch(CameraAccessException e){ e.printStackTrace(); }

          /*   Constraints  constraints=new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).setRequiredNetworkType(NetworkType.METERED).build();
 Data data=new Data.Builder().putString(Constants.NETWORKKEY,Constants.SUCCESS).build();
             final OneTimeWorkRequest   oneTimeWorkRequest =new OneTimeWorkRequest.Builder(NetworkWork.class).setConstraints(constraints).build();
                final WorkManager   workManager =WorkManager.getInstance(getActivity());
workManager.enqueue(oneTimeWorkRequest);
workManager.getWorkInfoByIdLiveData(oneTimeWorkRequest.getId()).observe(getActivity(), new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                      if (workInfo!=null) {
                          if (WorkInfo.State.SUCCEEDED==workInfo.getState()){
                              //  try {     iPresenter.LockFocus();}catch(CameraAccessException e){ e.printStackTrace(); }


                          }else if (WorkInfo.State.FAILED==workInfo.getState()){
                              new AlertDialog.Builder(getActivity())
                                      .setTitle("Check Network")
                                      .setMessage("Check your internet connection")
                                      .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                          public void onClick(DialogInterface dialog, int which) {} })
                                       .setNegativeButton(android.R.string.no, null)
                                      .setIcon(R.drawable.icontranslate)
                                      .show();   }      }      }  }); */


          CheckNetworkAvailability();
                break;


            case R.id.dropImageview:
                LanguageRequestView languageRequestView = new LanguageRequestView();
                languageRequestView.show(getChildFragmentManager(), "Hello");
                break;

            case R.id.flashmode:
                if (!hasTorch()){ Toast.makeText(getActivity(), "Torch not Available", Toast.LENGTH_SHORT).show();return;

                }else{
                    switchTorch();

                }




                break;

        } }

    private void CheckNetworkAvailability() {

        ConnectivityManager.NetworkCallback connectivityManager1 = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(@Nullable Network network) {
                try {
                    iPresenter.LockFocus();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onUnavailable() {
                if (getActivity() == null) {
                    return;
                }
                new AlertDialog.Builder(getActivity())
                        .setTitle(Constants.NETWORKCHECKTITLE)
                        .setMessage(Constants.CheckINTERNETCONNECTION)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {


                            }
                        })

                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(R.drawable.icontranslate)
                        .show();


            }

        };


        connectivityManager.requestNetwork(new NetworkRequest.Builder().addTransportType(NetworkCapabilities.TRANSPORT_WIFI).addTransportType(NetworkCapabilities.TRANSPORT_VPN).addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR).build(), connectivityManager1
                , 20);

    }

    private void switchTorch() {

       switch (torchMode){

           case FLASHON:
               torchMode =TorchMode.FLASHOFF;
               iPresenter.OpenTorch();
               FlashMode.setImageResource(R.drawable.flashon);
               break;

           case FLASHOFF:
               iPresenter.CloseTorch();
               FlashMode.setImageResource(R.drawable.flashoff);
               torchMode=TorchMode.FLASHON;


               break;


       }

   }

    private boolean hasTorch() {
    if (getActivity()!=null){
            return getActivity().getPackageManager()
                    .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH); }

    return false;
    }






                /*
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        if (motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
            iPresenter.onFocusTouch(motionEvent.getX(), motionEvent.getY());
            Log.i(TAG, "onTouch: ");
        }
        return true; }
*/






    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        this.progress=progress;
        try {
            iPresenter.ZoomIt(progress/3);
             iPresenter.onFocusTouch(200,200);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {





    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        try {
            iPresenter.ZoomIt(progress/3);

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
         if(requestCode==REQUEST_CAMERA_PERMISSION) {
                if (grantResults.length > 0) {
                    boolean cameraPermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    boolean readExternalFile = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (cameraPermission && readExternalFile) {
                        if (cameraTextureView.isAvailable()) {
                            try {
                                iPresenter.OpenCamera(cameraTextureView.getWidth(), cameraTextureView.getHeight() ,mBackgroundHandler,cameraTextureView);
                            } catch (CameraAccessException e) {
                                e.printStackTrace();
                            }
                        } else {
                            cameraTextureView.setSurfaceTextureListener(this);
                        }
                    } else {

                        if (getActivity()!=null) {
                            getActivity().finish(); }

                        }
                }


        }



    }



    @Override
    public  boolean hasPermissions(Context context, String[] permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
    private FragmentActivity getActivityNonNull() {
        if (super.getActivity() != null) {
            return super.getActivity();
        } else {
            throw new RuntimeException("null returned from getActivity()");
        }
    }

    enum TorchMode{

        FLASHON, FLASHOFF


    }

}
