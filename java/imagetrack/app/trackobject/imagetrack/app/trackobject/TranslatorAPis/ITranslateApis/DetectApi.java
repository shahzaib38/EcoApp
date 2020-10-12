package imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.ITranslateApis;

import java.util.Map;

import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.GetandSetTraslateApis.TranslateDetect;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.GetandSetTraslateApis.TranslatePost;
import io.reactivex.Flowable;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface DetectApi {

    @GET("v2")
    Flowable<Response<TranslateDetect>> getData(@QueryMap Map<String,String> name);


    @GET("v2?key=AIzaSyBkM82M98TQYuESFgvY0S0QdyVcLMdfqHc")
    Flowable<Response<TranslatePost>> PostTrsnalateDatqa(@Body TranslatePost translatePost);


}
