package com.adnroid.mprogressview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/**
 * ${desc}
 * ProgressBar 圆角 并添加文字
 * @author osx
 * @time 2018/8/11 0011 19:09
 */
public class MProgressView extends ProgressBar {
    private String mString = "1000";
    private Paint mPaint;
    private int mColor;
    private float mTextSize = 14;
    private float paddingLeft = 0;
    private Rect rect = new Rect();
    public MProgressView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }


    public MProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    public MProgressView(Context context) {
        super(context);
        init(context, null);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        mPaint.getTextBounds(mString, 0, mString.length(), rect);
        int pro = getProgress();
        int y = getHeight() / 2 - rect.centerY();
        int x = getWidth() / 2 - rect.centerX();
        canvas.drawText(mString, x, y, mPaint);
    }

    private void init(Context context, AttributeSet attributeSet) {

        TypedArray array = context.obtainStyledAttributes(attributeSet, R.styleable.MProgressView);

        mColor = array.getColor(R.styleable.MProgressView_pro_color, getResources().getColor(R.color.colorAccent));
        mTextSize = array.getDimensionPixelSize(R.styleable.MProgressView_pro_size, 16);
        paddingLeft = array.getDimension(R.styleable.MProgressView_pro_paddingLeft, 0);
        mString = array.getString(R.styleable.MProgressView_pro_txt);

        array.recycle();
        mPaint = new Paint();
        mPaint.setColor(mColor);
        mPaint.setTextSize(mTextSize);

    }

    public void setText(String text) {
        this.mString = text;
        invalidate();
    }
}
