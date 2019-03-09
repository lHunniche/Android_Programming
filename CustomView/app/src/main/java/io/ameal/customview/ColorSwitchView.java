package io.ameal.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ColorSwitchView extends View
{
    private int mRed;
    private int mGreen;
    private int mBlue;


    public ColorSwitchView(Context context)
    {
        super(context);
        init();
    }

    public ColorSwitchView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public ColorSwitchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init()
    {
        makeRed();
    }

    public void makeRed()
    {
        mRed = 255;
        mGreen = 0;
        mBlue = 0;
        this.invalidate();
    }
    public void makeBlue()
    {
        mRed = 0;
        mGreen = 0;
        mBlue = 255;
        this.invalidate();
    }
    public void makeGreen()
    {
        mRed = 0;
        mGreen = 255;
        mBlue = 0;
        this.invalidate();
    }
    public void makePink()
    {
        mRed = 255;
        mGreen = 0;
        mBlue = 255;
        this.invalidate();
    }


    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawRGB(mRed, mGreen, mBlue);
    }
}
