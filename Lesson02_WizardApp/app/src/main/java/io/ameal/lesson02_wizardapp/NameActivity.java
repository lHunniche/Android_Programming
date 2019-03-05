package io.ameal.lesson02_wizardapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity
{
    EditText nameText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        nameText = findViewById(R.id.nameEditText);
        nameText.setGravity(Gravity.CENTER_HORIZONTAL);
        //nameText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        Button nextButton = findViewById(R.id.nameNext);
        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                goToAgeActivity();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState)
    {
        super.onSaveInstanceState(saveInstanceState);
        Log.e("Name Activity", "onSaveInstanceState called!!");
        saveInstanceState.putString("savedName", nameText.getText().toString() + "");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState)
    {
        super.onRestoreInstanceState(saveInstanceState);
        Log.e("Name Activity", "onRestoreInstanceState called!!");

        String savedName = (String) saveInstanceState.get("savedName");
        nameText.setText("Hello there, " + savedName);
    }

    private void goToAgeActivity()
    {
        Intent intent = new Intent(this, AgeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("name", nameText.getText().toString());
        startActivity(intent);
    }
}
