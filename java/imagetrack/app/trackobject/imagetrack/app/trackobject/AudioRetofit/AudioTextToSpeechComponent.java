package imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit;

import dagger.Component;
import retrofit2.Retrofit;

@Component(modules = AudioTexttoSpeechModule.class)
public interface AudioTextToSpeechComponent {



    Retrofit getRetrofit();

}
