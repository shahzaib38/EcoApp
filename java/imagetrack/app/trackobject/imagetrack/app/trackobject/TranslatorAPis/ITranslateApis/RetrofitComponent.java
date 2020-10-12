package imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.ITranslateApis;


import dagger.Component;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.TranslateRetrofit.AppModule;
import retrofit2.Retrofit;

@Component(modules = AppModule.class)
public interface RetrofitComponent {




  Retrofit getRetrofit();






}
