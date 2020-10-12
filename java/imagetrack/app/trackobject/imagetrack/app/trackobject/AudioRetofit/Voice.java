package imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Voice {


    @SerializedName("languageCode")
    @Expose
    private String languageCode;
    @SerializedName("name")
    @Expose
    private String name;

    public Voice(String languageCode, String name) {
        this.languageCode = languageCode;
        this.name = name;
    }

   // public String getLanguageCode() {
   //     return languageCode;
   // }

  //  public void setLanguageCode(String languageCode) {
     //   this.languageCode = languageCode;
   // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
