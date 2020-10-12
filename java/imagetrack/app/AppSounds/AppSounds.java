package imagetrack.app.AppSounds;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;

import com.example.myapplication.R;

public class AppSounds implements SoundPool.OnLoadCompleteListener{

    private SoundPool soundPool;
    private Context context;

    public AppSounds(Context context ){
        SoundPool.Builder shutterSound;

        this.context=context;


        shutterSound =new SoundPool.Builder();
        shutterSound.setAudioAttributes(new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build());
        shutterSound.setMaxStreams(5);
        soundPool=   shutterSound.build();
        soundPool.setOnLoadCompleteListener(this);

    }
    public void  setCameraShutterSound(){

     soundPool.load(context, R.raw.camerashutter1 ,1);
    }



    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
      soundPool.play(sampleId, 1f, 1f, 1, 0, 1);
    }


    public void  setCameraFocusSound(){

        soundPool.load(context, R.raw.camerafocusbeep ,1);
    }


}
