package io.ameal.lesson02_wizardapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity
{
    EditText ageText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        ageText = findViewById(R.id.ageEditText);
        ageText.setGravity(Gravity.CENTER_HORIZONTAL);

        Button nextButton = findViewById(R.id.ageNext);
        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                goToBirthdayActivity();
            }
        });

    }

    private void goToBirthdayActivity()
    {
        Intent intent = new Intent(this, BirthdayActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("name", (String) getIntent().getExtras().get("name"));
        intent.putExtra("age", ageText.getText().toString());
        startActivity(intent);
    }
}
