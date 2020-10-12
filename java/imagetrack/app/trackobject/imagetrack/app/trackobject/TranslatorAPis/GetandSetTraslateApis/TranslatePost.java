package imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.GetandSetTraslateApis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class TranslatePost {

    @SerializedName("q")
    @Expose
    private String q;
    @SerializedName("target")
    @Expose
    private String target;

    public TranslatePost(String q, String target) {
        super();
        this.q = q;
        this.target = target;
    }

    public String getQ() {
        return q;
    }


    public String getTarget() {
        return target;
    }

}

