package imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit;


import  com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class AudioResponseData {

    @SerializedName("audioContent")
    @Expose
    private String audioContent;

    public AudioResponseData(String audioContent) {
        this.audioContent = audioContent;
    }

    public String getAudioContent() {
        return audioContent;
    }


}