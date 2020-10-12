package imagetrack.app.trackobject.ImageCropper;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;

import android.graphics.Paint;
import android.graphics.Path;

import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.example.myapplication.R;


public class CropImageView extends AppCompatImageView {

    private static final float MIN_FRAME_SIZE_IN_DP =50 ;
    private int mHandleSize;
    private TouchArea mTouchArea = TouchArea.OUT_OF_BOUNDS;
    private ShowMode mHandleShowMode = ShowMode.SHOW_ALWAYS;
    private int mOverlayColor;
    private int mFrameColor;
    private int mHandleColor;
    private static final int FRAME_STROKE_WEIGHT_IN_DP = 2;
    private Paint mPaintFrame;
    private float mFrameStrokeWeight;
    private static RectF mFrameRect;
    private float mMinFrameSize;
    private static final int WHITE = 0xFFFFFFFF;
    private static final int TRANSLUCENT_BLACK = 0xBB000000;
    private float mLastX, mLastY;
    public static float left=100.0f;
    public static float top=200.0f;
    public static float right=400.0f;
    public static float bottom=400.0f;
    private static final int HANDLE_SIZE_IN_DP = 10;
    private boolean mShowHandle = false;
    private String TAG=CropImageView.class.getSimpleName();
    private int widthmeasure;
    private int heightmeasure;
    private int mTouchPadding = 0;
    private float diffX;
    private float diffY;
    private DisplayMetrics displayMatrics ;


    public CropImageView(Context context) {
        this(context, null);

    }

    public CropImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public CropImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
         displayMatrics =new DisplayMetrics();
       ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMatrics);

        float density= (float) getDensity();
        mHandleSize = (int) (density * HANDLE_SIZE_IN_DP);
        mMinFrameSize = density * MIN_FRAME_SIZE_IN_DP;
        mPaintFrame = new Paint();
        mFrameColor = WHITE;
        mFrameStrokeWeight= density * FRAME_STROKE_WEIGHT_IN_DP;
        mFrameRect =new RectF(left, top, right, bottom);

        handleStyleable(context, attrs, defStyleAttr, density);

    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        final int widthmeasure =  MeasureSpec.getSize(widthMeasureSpec);
        final int heightmeasure =MeasureSpec.getSize(heightMeasureSpec);

        this.widthmeasure =widthmeasure;
        this.heightmeasure =heightmeasure;


    }
// Set Layout


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
      super.onLayout(changed, left, top, right, bottom);

        if(widthmeasure ==0 || heightmeasure==0)
            return;

        invalidate(); }





    private void handleStyleable(Context context, AttributeSet attrs, int defStyleAttr, float density) {
        TypedArray typedArray= context.obtainStyledAttributes(attrs , R.styleable.scv_CropImageView,defStyleAttr ,0);

        try {


            mOverlayColor =
                    typedArray.getColor(R.styleable.scv_CropImageView_scv_overlay_color, TRANSLUCENT_BLACK);
            mFrameColor = typedArray.getColor(R.styleable.scv_CropImageView_scv_frame_color, WHITE);
            mHandleColor = typedArray.getColor(R.styleable.scv_CropImageView_scv_handle_color, WHITE);


            mTouchPadding = typedArray.getDimensionPixelSize(R.styleable.scv_CropImageView_scv_touch_padding, 0);


            for (ShowMode mode : ShowMode.values()) {
                if (typedArray.getInt(R.styleable.scv_CropImageView_scv_handle_show_mode, 1) == mode.getId()) {
                    mHandleShowMode = mode;
                    Log.i(TAG, "handleStyleable: " + mHandleShowMode);
                    break;
                }
            }


            setHandleShowMode(mHandleShowMode);
        }catch (Exception e){
            e.getMessage();
        }finally {
            typedArray.recycle();
        }
    }


    private void setHandleShowMode(ShowMode mode) {
        mHandleShowMode = mode;
        switch (mode) {
            case SHOW_ALWAYS:
                mShowHandle = false;
                break;
            case NOT_SHOW:

            case SHOW_ON_TOUCH:
                mShowHandle = true;
                break;
        }
        invalidate();
    
    
    }


    private Object getDensity() {



        DisplayMetrics displayMetrics = new DisplayMetrics();


            ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);

        return displayMetrics.density;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawcropFrame(canvas);
    }



    private void drawcropFrame(Canvas canvas) {

        drawFrame(canvas);
        drawOverlay(canvas);
        if (mShowHandle) drawHandles(canvas);

    }

    private void drawOverlay(Canvas canvas) {
         Paint mPaintTranslucent =new Paint();
        mPaintTranslucent.setAntiAlias(true);
        mPaintTranslucent.setColor(mOverlayColor);
        mPaintTranslucent.setStyle(Paint.Style.FILL);
        Path path = new Path();
        RectF overlayRect =
        new RectF((float) Math.floor(0),  (float) Math.ceil(0),
            (float) Math.ceil(displayMatrics.widthPixels), (float) Math.ceil(displayMatrics.heightPixels));
       path.addRect(overlayRect, Path.Direction.CW);



      path.addRect(mFrameRect, Path.Direction.CCW);
        canvas.drawPath(path, mPaintTranslucent);


    }

    private void drawHandles(Canvas canvas) {
        mPaintFrame.setStyle(Paint.Style.FILL);
        mPaintFrame.setColor(mHandleColor);
        canvas.drawCircle(mFrameRect.left, mFrameRect.top, mHandleSize, mPaintFrame);
        canvas.drawCircle(mFrameRect.right, mFrameRect.top, mHandleSize, mPaintFrame);
        canvas.drawCircle(mFrameRect.left, mFrameRect.bottom, mHandleSize, mPaintFrame);
        canvas.drawCircle(mFrameRect.right, mFrameRect.bottom, mHandleSize, mPaintFrame);


    }

    private void drawFrame(Canvas canvas) {
        if (mPaintFrame ==null){
            mPaintFrame =new Paint(); }

        mPaintFrame.setAntiAlias(true);
        mPaintFrame.setFilterBitmap(true);
        mPaintFrame.setStyle(Paint.Style.STROKE);
        mPaintFrame.setColor(mFrameColor);
        mPaintFrame.setStrokeWidth(mFrameStrokeWeight);
        left=mFrameRect.left;
        top=mFrameRect.top;
        right=mFrameRect.right;
        bottom=mFrameRect.bottom;
        canvas.drawRect(mFrameRect, mPaintFrame);

    }



    public RectF getRectF() {

    return new RectF(mFrameRect.left,mFrameRect.top,mFrameRect.right,mFrameRect.bottom);
    }


    /***************** Enumeration  ****************/
 private enum TouchArea {
        OUT_OF_BOUNDS, CENTER, LEFT_TOP, RIGHT_TOP, LEFT_BOTTOM, RIGHT_BOTTOM
    }

    public enum ShowMode {
        SHOW_ALWAYS(1), SHOW_ON_TOUCH(2), NOT_SHOW(3);
        private final int ID;

        ShowMode(final int id) {
            this.ID = id;
        }

        public int getId() {
            return ID;
        }
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                onDown(event);return true;
                case MotionEvent.ACTION_MOVE:
                    onMove(event);
                    if (mTouchArea != TouchArea.OUT_OF_BOUNDS) {
                        getParent().requestDisallowInterceptTouchEvent(true); }return true;

            case MotionEvent.ACTION_CANCEL: getParent().requestDisallowInterceptTouchEvent(false); onCancel();

            return true;

            case MotionEvent.ACTION_UP:
                getParent().requestDisallowInterceptTouchEvent(false);
                onUp();
                return true;


        }





        return false;
    }

    private void onUp() {
        if (mHandleShowMode == ShowMode.SHOW_ON_TOUCH)
            mShowHandle = false;

        mTouchArea = TouchArea.OUT_OF_BOUNDS;
        invalidate();
    }

    private void onCancel() {
        mTouchArea = TouchArea.OUT_OF_BOUNDS;
        mShowHandle=false;
        invalidate();

    }

    private void onDown(MotionEvent event) {
        invalidate();
        mLastX=  event.getX();
        mLastY= event.getY();
        checkTouchArea(event.getX(), event.getY());






    }


    /******** Checking Touch Area **********/
    private void checkTouchArea(float x, float y) {
          // Check Left Top
        if(isInsideCornerLeftTop(x,y)){
            mTouchArea = TouchArea.LEFT_TOP;
            if (mHandleShowMode == ShowMode.SHOW_ON_TOUCH) mShowHandle = true;
              return; }


        //Check Right Top
        if (isInsideCornerRightTop(x, y)) {
            mTouchArea = TouchArea.RIGHT_TOP;
            if (mHandleShowMode == ShowMode.SHOW_ON_TOUCH) mShowHandle = true;



           return; }

        // Left Bottom
        if (isInsideCornerLeftBottom(x, y)) {
            mTouchArea = TouchArea.LEFT_BOTTOM;
            if (mHandleShowMode == ShowMode.SHOW_ON_TOUCH) mShowHandle = true;
            return; }


        if (isInsideCornerRightBottom(x, y)) {

            mTouchArea = TouchArea.RIGHT_BOTTOM;
           if (mHandleShowMode == ShowMode.SHOW_ON_TOUCH) mShowHandle = true;
            return;

        }




        if (isInsideFrame(x, y)) {
            if (mHandleShowMode == ShowMode.SHOW_ON_TOUCH) mShowHandle = true;
            mTouchArea = TouchArea.CENTER;
            return;
        }



        mTouchArea = TouchArea.OUT_OF_BOUNDS;


    }




    /************ Condition for checking Area ************/
    private boolean isInsideFrame(float x, float y) {
        if (mFrameRect.left <= x && mFrameRect.right >= x) {
            if (mFrameRect.top <= y && mFrameRect.bottom >= y) {
                mTouchArea = TouchArea.CENTER;
                mShowHandle=true;
                return true; } }


        return false;

    }





    private boolean isInsideCornerRightBottom(float x, float y) {

        mTouchArea = TouchArea.RIGHT_BOTTOM;
        mHandleShowMode = ShowMode.SHOW_ON_TOUCH;
        float dx = x - mFrameRect.right;
        float dy = y - mFrameRect.bottom;
        float d = dx * dx + dy * dy;
        return Sq(mHandleSize +mTouchPadding)>=d; }

    private boolean isInsideCornerLeftBottom(float x, float y) {

        mTouchArea = TouchArea.LEFT_BOTTOM;
        mHandleShowMode = ShowMode.SHOW_ON_TOUCH;

        float dx = x - mFrameRect.left;
        float dy = y - mFrameRect.bottom;
        float d = dx * dx + dy * dy;
        return Sq(mHandleSize +mTouchPadding)>=d; }

    private boolean isInsideCornerRightTop(float x, float y) {

        mTouchArea = TouchArea.RIGHT_TOP;
        mHandleShowMode = ShowMode.SHOW_ON_TOUCH;

        float dx = x - mFrameRect.right;
        float dy = y - mFrameRect.top;
        float d = dx * dx + dy * dy;
        return Sq(mHandleSize +mTouchPadding)>=d; }

    private boolean isInsideCornerLeftTop(float x, float y) {

        mTouchArea = TouchArea.LEFT_TOP;
        mHandleShowMode = ShowMode.SHOW_ON_TOUCH;

        float dx = x - mFrameRect.left;
        float dy = y - mFrameRect.top;
        float d = dx * dx + dy * dy;
        return Sq(mHandleSize +mTouchPadding)>=d; }

    /************ Condition Checking Area End***********/






    private float Sq(int value) { return value * value; }




    private void onMove(MotionEvent event) {

        diffX = event.getX() - mLastX;
       diffY = event.getY() - mLastY;

        Log.i(TAG, "onMove: "+mTouchArea.name());
        switch (mTouchArea) {
            case CENTER:
                moveFrame(diffX, diffY);
                break;
            case LEFT_TOP:
                moveHandleLT(diffX, diffY);
                break;
            case RIGHT_TOP:
                moveHandleRT(diffX, diffY);
                break;
            case LEFT_BOTTOM:
                moveHandleLB(diffX, diffY);
                break;
            case RIGHT_BOTTOM:
                moveHandleRB(diffX, diffY);
                break;
            case OUT_OF_BOUNDS:

                break;
        }
        invalidate();
        mLastX = event.getX();
        mLastY = event.getY();

    }





    private void moveHandleRB(float diffX, float diffY) {

        mFrameRect.right += diffX;
        mFrameRect.bottom += diffY;

        if (mFrameRect.right > widthmeasure) {
            mFrameRect.right -= diffX;
        }

        if (mFrameRect.bottom > heightmeasure) {
            mFrameRect.bottom -= diffY;
        }

        if (isWidthTooSmall()) {
            float offsetX = mMinFrameSize - getFrameW();
            mFrameRect.right += offsetX;
        }
        if (isHeightTooSmall()) {
            float offsetY = mMinFrameSize - getFrameH();
            mFrameRect.bottom += offsetY;
        }

        checkScaleBounds();

    }


    private void moveHandleLB(float diffX, float diffY) {
        mFrameRect.left += diffX;
        mFrameRect.bottom += diffY;


        if (mFrameRect.left <0) {
            mFrameRect.left -= diffX;
        }

        if (mFrameRect.bottom > heightmeasure) {
            mFrameRect.bottom -= diffY;
        }



        if (isWidthTooSmall()) {
            float offsetX = mMinFrameSize - getFrameW();
            mFrameRect.left -= offsetX;
        }
        if (isHeightTooSmall()) {
            float offsetY = mMinFrameSize - getFrameH();
            mFrameRect.bottom += offsetY;
        }


        checkScaleBounds();

    }

    private void moveHandleRT(float diffX, float diffY) {
        mFrameRect.right += diffX;
        mFrameRect.top += diffY;


        if (mFrameRect.right > widthmeasure) {
            mFrameRect.right -= diffX;
        }

        if (mFrameRect.top <0) {
            mFrameRect.top -= diffY;
        }




        if (isWidthTooSmall()) {
            float offsetX = mMinFrameSize - getFrameW();
            mFrameRect.right += offsetX;
        }
        if (isHeightTooSmall()) {
            float offsetY = mMinFrameSize - getFrameH();
            mFrameRect.top -= offsetY;
        }

    }

    private void moveHandleLT(float diffX, float diffY) {


            mFrameRect.left += diffX;
            mFrameRect.top += diffY;


        if (mFrameRect.top < 0) {
            mFrameRect.top -= diffY;
        }

        if (mFrameRect.left <0) {
            mFrameRect.left -= diffX;
        }






        if (isWidthTooSmall()) {
                float offsetX = mMinFrameSize - getFrameW();
                mFrameRect.left -= offsetX;
            }
            if (isHeightTooSmall()) {
                float offsetY = mMinFrameSize - getFrameH();
                mFrameRect.top -= offsetY;
            }









    }
    private float getFrameW() {
        return (mFrameRect.right - mFrameRect.left);
    }

    private float getFrameH() {
        return (mFrameRect.bottom - mFrameRect.top);
    }



    private boolean isWidthTooSmall() {
        return getFrameW() < mMinFrameSize;
    }

    private boolean isHeightTooSmall() {
        return getFrameH() < mMinFrameSize;
    }

    private void checkScaleBounds() {
        float lDiff = mFrameRect.left ;
        float bDiff = mFrameRect.bottom ;



        if (lDiff < 0) {
            mFrameRect.left -= lDiff;
        }

       if (bDiff > heightmeasure) {
            mFrameRect.bottom -= bDiff;
       }



    }


    ///// Move Frame
    private void moveFrame(float x, float y) {

         mFrameRect.left += x;
         mFrameRect.right += x;
         mFrameRect.top += y;
         mFrameRect.bottom += y;

        CheckMoveBounds();

    }

    private void CheckMoveBounds() {
        float diff = mFrameRect.left;


        if (diff < 0) {
            mFrameRect.left -= diffX;
            mFrameRect.right -= diffX;
            mFrameRect.top -= diffY;
            mFrameRect.bottom -= diffY;


        }

        diff =mFrameRect.top;

        if (diff<0){
            mFrameRect.left -= diffX;
            mFrameRect.right -= diffX;
            mFrameRect.top -= diffY;
            mFrameRect.bottom -= diffY;

        }


        diff =mFrameRect.bottom;
        if (diff>displayMatrics.heightPixels){
            mFrameRect.left -= diffX;
            mFrameRect.right -= diffX;
            mFrameRect.top -= diffY;
            mFrameRect.bottom -= diffY;

        }


        diff =mFrameRect.right;

        if (diff>displayMatrics.widthPixels){
            mFrameRect.left -= diffX;
            mFrameRect.right -= diffX;
            mFrameRect.top -= diffY;
            mFrameRect.bottom -= diffY;

        }


invalidate();
    }









}
