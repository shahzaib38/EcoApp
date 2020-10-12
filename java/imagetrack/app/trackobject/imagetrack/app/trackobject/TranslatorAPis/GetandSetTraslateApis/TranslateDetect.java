package imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.GetandSetTraslateApis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class TranslateDetect {



    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }



}
