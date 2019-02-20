package io.ameal.lesson01_helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView firstTextOwO;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComps();
    }

    private void initComps()
    {
        firstTextOwO = findViewById(R.id.myFirstTextView);
        firstTextOwO.setText("Please eradicate anime");

        getSupportActionBar().hide();
    }
}
