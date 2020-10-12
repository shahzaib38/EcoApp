package imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import java.io.IOException;

public final class PlayMediaService extends Service implements MediaPlayer.OnPreparedListener ,MediaPlayer.OnCompletionListener,IPlayMediaService {

    private MediaPlayer mMediaPlayer;


    @Override
    public IBinder onBind(Intent intent) {
        return new AudioBinder();
    }


    @Override
    public void onPrepared(MediaPlayer mp) {



        mMediaPlayer.start();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mMediaPlayer.stop(); }



    @Override
    public void OnInitialized(Context context ,String audioContent) throws IOException {
        mMediaPlayer =new MediaPlayer();

        String url = "data:audio/mp3;base64,"+audioContent;
        mMediaPlayer.setOnPreparedListener(this);
        mMediaPlayer.setOnCompletionListener(this);
        mMediaPlayer.setDataSource(url);
        mMediaPlayer.prepare(); }
}
