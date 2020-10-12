package imagetrack.app.trackobject.imagetrack.app.trackobject.AudioRetofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Input {
    @SerializedName("text")
    @Expose
    private String text;


    public Input(String text) {
        this.text = text;
    }

 //   public String getText() {
   //     return text;
   // }

  //  public void setText(String text) {
   //     this.text = text;
  //  }
}
