package imagetrack.app.trackobject.Model.Cameramodel;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;
import imagetrack.app.trackobject.Model.ICameraModel.IVisionImage;
import imagetrack.app.trackobject.imagetrack.app.trackobject.TranslatorAPis.TranslateRetrofit.TranslateLetter;

public final class VisionImage implements IVisionImage {
    private Context context;

      public VisionImage(Context context){
      DisplayMetrics displayMatrics;
      this.context=context;
      displayMatrics = new DisplayMetrics();
      ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMatrics); }


    /*   Unused Code
    public void ImageFromMediaImage(ByteBuffer buffer, int rotation,Context context) {




        int result;
        switch (rotation) {
            case 0:
                result = FirebaseVisionImageMetadata.ROTATION_0;

                break;
            case 90:
                result = FirebaseVisionImageMetadata.ROTATION_90;
                break;
            case 180:
                result = FirebaseVisionImageMetadata.ROTATION_180;
                break;
            case 270:
                result = FirebaseVisionImageMetadata.ROTATION_270;
                break;
            default:
                result = FirebaseVisionImageMetadata.ROTATION_0;



        }


        Log.i(TAG, "ImageFromMediaImage nn: "+result);
        FirebaseVisionImageMetadata metadata = new FirebaseVisionImageMetadata.Builder()
                .setWidth(displayMatrics.widthPixels)   // 480x360 is typically sufficient for
               .setHeight(displayMatrics.heightPixels)  // image recognition

                .setRotation(result)
                .setFormat(ImageFormat.NV21)
              .build();


     FirebaseVisionImage image = FirebaseVisionImage.fromByteBuffer(buffer, metadata);


       TextRecognizeDetect(image);





    }

    */



    @Override
    public void TextRecognizeDetect(final FirebaseVisionImage firebaseVisionImage){
         FirebaseVisionTextRecognizer detector;

        detector = FirebaseVision.getInstance().getCloudTextRecognizer();

        detector.processImage(firebaseVisionImage).addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
            @Override
            public void onSuccess(FirebaseVisionText firebaseVisionText) {
                String resultText =firebaseVisionText.getText();
            /*
                Log.i(TAG, "onSuccess: "+resultText);

              //  stringBuffer.append(resultText);

                for (FirebaseVisionText.TextBlock block: firebaseVisionText.getTextBlocks()) {
                    String blockText = block.getText();
                    Float blockConfidence = block.getConfidence();


                    List<RecognizedLanguage> blockLanguages = block.getRecognizedLanguages();
                    Point[] blockCornerPoints = block.getCornerPoints();
                    Rect blockFrame = block.getBoundingBox();
                    for (FirebaseVisionText.Line line: block.getLines()) {
                        String lineText = line.getText();
                        Float lineConfidence = line.getConfidence();
                        Log.i(TAG, "onSuccess: "+lineText);
                        Log.i(TAG, "onSuccess: "+resultText );
                        //            stringBuffer.append("\n " +lineText);
                        List<RecognizedLanguage> lineLanguages = line.getRecognizedLanguages();
                        Point[] lineCornerPoints = line.getCornerPoints();
                        Rect lineFrame = line.getBoundingBox();
                        for (FirebaseVisionText.Element element: line.getElements()) {
                            String elementText = element.getText();
                            Float elementConfidence = element.getConfidence();
                            Log.i(TAG, "onSuccess: "+elementText);
                            Log.i(TAG, "onSuccess: "+resultText );
                            List<RecognizedLanguage> elementLanguages = element.getRecognizedLanguages();
                            Point[] elementCornerPoints = element.getCornerPoints();
                            Rect elementFrame = element.getBoundingBox();
                        }
                    }
                }

             */
              TranslateLetter translateLetter=  TranslateLetter.getTranslateLetterInstance();
                translateLetter.TranslateWords(resultText,context); }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });


    }


    @Override
    public void FirebaseImageTrack(Bitmap bitmap) {
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);
        TextRecognizeDetect(image); }

}
