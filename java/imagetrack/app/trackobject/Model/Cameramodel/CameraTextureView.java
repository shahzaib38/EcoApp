package imagetrack.app.trackobject.Model.Cameramodel;

import android.content.Context;
import android.util.AttributeSet;

import android.util.Log;
import android.view.TextureView;

public final class CameraTextureView extends TextureView {

    private String TAG =CameraTextureView.class.getSimpleName();
    private int mRatioWidth;
    private int mRatioHeight;

    public CameraTextureView(Context context) {
        super(context,null);
    }

    public CameraTextureView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public CameraTextureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }






    public void setAspectRatio(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");

        }

        Log.i(TAG, "setAspectRatio: "+Thread.currentThread().getName());
        mRatioWidth = width;
        mRatioHeight = height;
        requestLayout();
    }






    /************** Engineer *********/


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (0 == mRatioWidth || 0 == mRatioHeight) {
            setMeasuredDimension(width, height);
        } else {
            if (width < height * mRatioWidth / mRatioHeight) {
                setMeasuredDimension(width, width * mRatioHeight / mRatioWidth);
            } else {
                setMeasuredDimension(height * mRatioWidth / mRatioHeight, height);
            }
        }
    }

}
