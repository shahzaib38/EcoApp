package imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit;

import dagger.Module;
import dagger.Provides;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.ITranslateApis.DetectApi;
import retrofit2.Retrofit;

@Module
class AudioTextToSpeechAuth {






         @Provides
        DetectApi providesDetectApi(Retrofit retrofit){
            return retrofit.create(DetectApi.class); }






}
