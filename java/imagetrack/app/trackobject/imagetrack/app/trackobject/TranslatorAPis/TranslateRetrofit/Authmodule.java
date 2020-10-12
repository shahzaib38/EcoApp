package imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.TranslateRetrofit;

import dagger.Module;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.ITranslateApis.DetectApi;
import retrofit2.Retrofit;


@Module
public class Authmodule {



    DetectApi providesDetectApi(Retrofit retrofit){
        return retrofit.create(DetectApi.class);


    }

}
