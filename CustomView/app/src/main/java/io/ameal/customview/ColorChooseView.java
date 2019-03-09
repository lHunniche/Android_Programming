package io.ameal.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ColorChooseView extends View
{
    private Rect redRect;
    private Rect greenRect;
    private Rect blueRect;
    private Rect yellowRect;
    private Paint rectPaint;
    private Paint circlePaint;



    public ColorChooseView(Context context)
    {
        super(context);
        init();
    }

    public ColorChooseView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public ColorChooseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init()
    {
        redRect = new Rect();
        greenRect = new Rect();
        blueRect = new Rect();
        yellowRect = new Rect();

        rectPaint = new Paint();
        circlePaint = new Paint();
        circlePaint.setColor(Color.WHITE);
    }

    public void changeColor(float inputX, float inputY)
    {
        int x = (int)inputX;
        int y = (int)inputY;

        if (redRect.contains(x, y))
        {
            circlePaint.setColor(Color.RED);
        }
        else if (blueRect.contains(x, y))
        {
            circlePaint.setColor(Color.BLUE);
        }
        else if (greenRect.contains(x, y))
        {
            circlePaint.setColor(Color.GREEN);
        }
        else if (yellowRect.contains(x, y))
        {
            circlePaint.setColor(Color.YELLOW);
        }

        this.invalidate();




    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        rectPaint.setColor(Color.RED);
        redRect.left = 0;
        redRect.top = 0;
        redRect.right = canvas.getWidth()/2;
        redRect.bottom = canvas.getHeight()/2;
        canvas.drawRect(redRect, rectPaint);

        rectPaint.setColor(Color.GREEN);
        greenRect.left = canvas.getWidth()/2;
        greenRect.top = 0;
        greenRect.right = canvas.getWidth();
        greenRect.bottom = canvas.getHeight()/2;
        canvas.drawRect(greenRect, rectPaint);

        rectPaint.setColor(Color.BLUE);
        blueRect.left = 0;
        blueRect.top = canvas.getHeight()/2;
        blueRect.right = canvas.getWidth()/2;
        blueRect.bottom = canvas.getHeight();
        canvas.drawRect(blueRect, rectPaint);

        rectPaint.setColor(Color.YELLOW);
        yellowRect.left = canvas.getWidth()/2;
        yellowRect.top = canvas.getHeight()/2;
        yellowRect.right = canvas.getWidth();
        yellowRect.bottom = canvas.getHeight();
        canvas.drawRect(yellowRect, rectPaint);

        canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/4, circlePaint);



    }

}
