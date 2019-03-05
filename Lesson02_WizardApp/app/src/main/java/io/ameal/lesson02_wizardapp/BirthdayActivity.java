package io.ameal.lesson02_wizardapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BirthdayActivity extends AppCompatActivity
{
    EditText birthText = null;
    Calendar calendar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);

        birthText = findViewById(R.id.birthEditText);
        birthText.setGravity(Gravity.CENTER_HORIZONTAL);

        calendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2)
            {
                calendar.set(Calendar.YEAR, i);
                calendar.set(Calendar.MONTH, i1);
                calendar.set(Calendar.DAY_OF_MONTH, i2);
                updateLabel();
            }
        };

        birthText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                DatePickerDialog datePickerDialog = new DatePickerDialog(BirthdayActivity.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.updateDate(1996, 9-1, 16);
                datePickerDialog.show();
            }
        });


        Button nextButton = findViewById(R.id.birthdayNext);
        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                goToSummary();
            }
        });
    }

    private void goToSummary()
    {
        Intent intent = new Intent(this, SummaryActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

        intent.putExtra("name", (String) getIntent().getExtras().get("name"));
        intent.putExtra("age", (String) getIntent().getExtras().get("age"));
        intent.putExtra("birthday", birthText.getText().toString());
        startActivity(intent);
    }

    private void updateLabel()
    {
        String myCalendarFormat = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myCalendarFormat, Locale.getDefault());

        birthText.setText(simpleDateFormat.format(calendar.getTime()));

    }
}
