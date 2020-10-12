package imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit;


import android.os.Binder;

public final class AudioBinder extends Binder {


    public PlayMediaService getService(){
        return new PlayMediaService();

    }



}
