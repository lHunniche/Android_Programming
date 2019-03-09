package io.ameal.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener
{
    private GestureDetectorCompat gestureDetector;
    private ColorSwitchView colorSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init()
    {
        gestureDetector = new GestureDetectorCompat(this, this);
        colorSwitch = findViewById(R.id.colorSwitcher);
    }

    @Override
    public boolean onDown(MotionEvent e)
    {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e)
    {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e)
    {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
    {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e)
    {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
    {
        //Log.e("X", velocityX + "");
        //Log.e("Y", velocityY + "");

        // til højre
        if (velocityX > 5000)
        {
            Log.e("Fling", "1");
            colorSwitch.makeRed();
        }

        // til venstre
        else if (velocityX < -5000)
        {
            goToColorChooseActivity();
        }

        // ned
        else if (velocityY > 5000)
        {
            Log.e("Fling", "3");
            colorSwitch.makeGreen();
        }

        // op
        else if (velocityY < -5000)
        {
            Log.e("Fling", "4");
            colorSwitch.makePink();
        }

        return true;
    }

    private void goToColorChooseActivity()
    {
        Intent intent = new Intent(this, ColorChooseActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (gestureDetector.onTouchEvent(event))
        {
            return true;
        }
        return super.onTouchEvent(event);
    }
}
