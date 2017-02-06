package org.soundcool.upv.oscapp;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.SeekBar;

public class SeekBarMultislider extends SeekBar {

    public SeekBarMultislider(Context context) {
        super(context);
    }

    public SeekBarMultislider(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SeekBarMultislider(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldh, oldw);
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    protected void onDraw(Canvas c) {
        c.rotate(-90);
        c.translate(-getHeight(), 0);

        super.onDraw(c);
    }

    @Override public synchronized void setProgress(int progress){
        super.setProgress(progress);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
    }



    // No redefinimos el: public boolean onTouchEvent(MotionEvent event)

}
