package com.example.alarmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class AddAlarm extends AppCompatActivity {

    TextView currentDate;
    Spinner ringtoneSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_alarm);

        currentDate = findViewById(R.id.currentDate);
        ringtoneSpinner = findViewById(R.id.ringtoneSpinner);

        Calendar calendar = Calendar.getInstance();
        String dateFormat = DateFormat.getDateInstance(DateFormat.MONTH_FIELD).format(calendar.getTime());
        currentDate.setText("Today's Date -> " + dateFormat);

        String[] ringtones = {"Ringtone 1", "Ringtone 2", "Ringtone 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ringtones);
        ringtoneSpinner.setAdapter(adapter);
    }
}