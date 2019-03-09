package io.ameal.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class ColorChooseActivity extends AppCompatActivity
{
    private ColorChooseView colorChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_choose);
        init();
    }

    private void init()
    {
        colorChoose = findViewById(R.id.colorChooser);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        colorChoose.changeColor(event.getX(), event.getY());
        return super.onTouchEvent(event);
    }
}
