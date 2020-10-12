package imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class AudioRequestBody {

    @SerializedName("audioConfig")
    @Expose
    private AudioConfig audioConfig;
    @SerializedName("input")
    @Expose
    private Input input;
    @SerializedName("voice")
    @Expose
    private Voice voice;


    public AudioRequestBody(AudioConfig audioConfig, Input input, Voice voice) {
        this.audioConfig = audioConfig;
        this.input = input;
        this.voice = voice;
    }

    /*
    public AudioConfig getAudioConfig() {
        return audioConfig;
    }

    public void setAudioConfig(AudioConfig audioConfig) {
        this.audioConfig = audioConfig;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }


     */
}
