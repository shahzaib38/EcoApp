package imagetrack.app.trackobject.Model.ICameraModel;

import android.graphics.Bitmap;

import com.google.firebase.ml.vision.common.FirebaseVisionImage;

public interface IVisionImage {
  void TextRecognizeDetect(final FirebaseVisionImage firebaseVisionImage);
    void FirebaseImageTrack(Bitmap bitmap);
}
