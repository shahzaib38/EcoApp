package imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit;

import android.content.Context;

import java.io.IOException;

public interface IPlayMediaService {

    void OnInitialized(Context context , String audioContent)throws IOException;
}
