package imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit;

import dagger.Module;
import dagger.Provides;
import imagetrack.app.trackobject.Constants.Constants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = AudioTextToSpeechAuth.class)
class AudioTexttoSpeechModule {





    @Provides
    Retrofit provideRetrofit(){

        return   new Retrofit.Builder()
                .baseUrl(Constants.TEXTTOSPEECHSYNTHESIZE).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();

    }






}
