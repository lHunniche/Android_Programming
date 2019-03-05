package io.ameal.lesson02_wizardapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView nameText = findViewById(R.id.sumName);
        TextView ageText = findViewById(R.id.sumAge);
        TextView birthdayText = findViewById(R.id.sumBirthday);

        nameText.setText("Name: " + (String) getIntent().getExtras().get("name"));
        ageText.setText("Age: " + (String) getIntent().getExtras().get("age"));
        birthdayText.setText("Birthday: " + (String) getIntent().getExtras().get("birthday"));

    }
}
