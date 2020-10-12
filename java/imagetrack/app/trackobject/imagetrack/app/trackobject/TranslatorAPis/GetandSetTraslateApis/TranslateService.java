package imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.GetandSetTraslateApis;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class TranslateService {


    @SerializedName("confidence")
    @Expose
    private Double confidence;
    @SerializedName("isReliable")
    @Expose
    private Boolean isReliable;
    @SerializedName("language")
    @Expose
    private String language;

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Boolean getIsReliable() {
        return isReliable;
    }

    public void setIsReliable(Boolean isReliable) {
        this.isReliable = isReliable;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
