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

public class AddAlarm extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

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
    
    public void pickDate(View view) {
        showDatePickerDialog();
    }

    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        String datePicked = dayOfMonth + "/" + month + "/" + year;
        Toast.makeText(this, "Date Picked -> " + datePicked, Toast.LENGTH_SHORT).show();
    }
}
