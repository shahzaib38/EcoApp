package imagetrack.app.trackobject.Model.Cameramodel;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.media.Image;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.ByteBuffer;

import imagetrack.app.trackobject.ImageCropper.CropImageView;

  public final class  ImageSaver implements Runnable{

      private File file;
      private Image image;
      private String TAG =ImageSaver.class.getSimpleName();
      private Context context;
      private int rotation;
      private VisionImage visionImage;
      private CropImageView cropperValue;

  public   ImageSaver(Image image, File file , int rotation , Context context) {
        this.image= image;
       this.file = file;
     this.rotation=rotation;


     visionImage =new VisionImage(context);
     cropperValue =new CropImageView(context);
      this.context=context;
  }


    @Override
    public void run() {


      try {


          ByteBuffer buffer = image.getPlanes()[0].getBuffer();
          byte[] bytes = new byte[buffer.capacity()];
          buffer.get(bytes);


          Bitmap b = getCropImage(bytes);
          visionImage.FirebaseImageTrack(b);
      }catch (Exception e){
          Log.i(TAG, "run: "+e.getMessage());

      }finally {
          image.close();
      }



/*
          File Path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
          File file = new File(Path, "picok.jpg");
          FileOutputStream output = null;
        try {
            output = new FileOutputStream(file);
           output.write(byteArray);

            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                image.close();
            }
            if (null != output) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

*/

    }

    private Bitmap getCropImage(byte[] bytes) {
        RectF rectF=cropperValue.getRectF();
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        Bitmap bitmap1= Bitmap.createScaledBitmap(bitmap,image.getWidth(),image.getHeight(),false);
        Matrix matrix = new Matrix();
        matrix.postRotate(90);
        Bitmap bitmap2= Bitmap.createBitmap(bitmap1,0,0,image.getWidth(),image.getHeight(),matrix,false);
        Bitmap bitmap12= Bitmap.createScaledBitmap(bitmap2,image.getWidth(),image.getHeight(),false);
        Bitmap bitmap11 =Bitmap.createBitmap(bitmap12,(int)rectF.left,(int)rectF.top,(int)rectF.width(),(int)rectF.height());
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap11.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return bitmap11; }}
