package imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit;

import dagger.Component;
import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface InterfaceDetectTextToAudio {

    @POST("?key=AIzaSyBkM82M98TQYuESFgvY0S0QdyVcLMdfqHc")
    Flowable<AudioResponseData> getResposeBody(@Body AudioRequestBody  audioRequestBody);




}
