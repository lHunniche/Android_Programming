package io.ameal.lesson02_wizardapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button beginButton = findViewById(R.id.beginWizardButton);
        beginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                beginWizard();
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.e("Main Activity", "onStart called!!");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.e("Main Activity", "onResume called!!");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.e("Main Activity", "onPause called!!");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.e("Main Activity", "onStop called!!");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.e("Main Activity", "onRestart called!!");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.e("Main Activity", "onDestroy called!!");
    }



    private void beginWizard()
    {
        Intent intent = new Intent(this, NameActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
