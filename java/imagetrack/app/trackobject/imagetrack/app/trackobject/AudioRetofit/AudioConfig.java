package imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public final class AudioConfig {
    @SerializedName("audioEncoding")
    @Expose
    private String audioEncoding;
    @SerializedName("effectsProfileId")
    @Expose
    private List<String> effectsProfileId = null;
    @SerializedName("pitch")
    @Expose
    private Integer pitch;
    @SerializedName("speakingRate")
    @Expose
    private Integer speakingRate;


    public AudioConfig(String audioEncoding, List<String> effectsProfileId, Integer pitch, Integer speakingRate) {

        this.audioEncoding = audioEncoding;
        this.effectsProfileId = effectsProfileId;
        this.pitch = pitch;
        this.speakingRate = speakingRate;
    }
/*
    public String getAudioEncoding() {
        return audioEncoding;
    }

    public void setAudioEncoding(String audioEncoding) {
        this.audioEncoding = audioEncoding;
    }

    public List<String> getEffectsProfileId() {
        return effectsProfileId;
    }

    public void setEffectsProfileId(List<String> effectsProfileId) {
        this.effectsProfileId = effectsProfileId;
    }

    public Integer getPitch() {
        return pitch;
    }

    public void setPitch(Integer pitch) {
        this.pitch = pitch;
    }

    public Integer getSpeakingRate() {
        return speakingRate;
    }

    public void setSpeakingRate(Integer speakingRate) {
        this.speakingRate = speakingRate;
    }
*/
}
