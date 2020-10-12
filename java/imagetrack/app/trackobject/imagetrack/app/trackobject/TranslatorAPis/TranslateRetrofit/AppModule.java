package imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.TranslateRetrofit;


import dagger.Module;
import dagger.Provides;
import imagetrack.app.trackobject.Constants.Constants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = Authmodule.class)
public class AppModule {



    @Provides
    Retrofit  provideRetrofit(){
        return new Retrofit.Builder().baseUrl(Constants.BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
    }





}
