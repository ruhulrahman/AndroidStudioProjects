package com.example.datepickerandtimepicker;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button openDatePickerBtn, openTimePickerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        openDatePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker();
            }
        });

        openTimePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimePicker();
            }
        });
    }

    public void openTimePicker(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.custom__time_picker, null);
        final TimePicker timePicker = view.findViewById(R.id.timePicker);
        Button done = view.findViewById(R.id.doneBtn);
        
        builder.setView(view);
        final Dialog dialog = builder.create();
        dialog.show();

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                @SuppressLint({"NewApi", "LocalSuppress"}) int hour = timePicker.getHour();
                @SuppressLint({"NewApi", "LocalSuppress"}) int min = timePicker.getMinute();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss aa");
                Time time = new Time(hour, min, 0);
                openTimePickerBtn.setText(simpleDateFormat.format(time));
                dialog.dismiss();

            }
        });
    }

    public void openDatePicker(){
        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String currentDate = year+"/"+month+"/"+dayOfMonth+" 00:00:00";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");//parameter
                Date date = new Date();
                try{
                    date = simpleDateFormat.parse(currentDate);
                }catch (ParseException e){
                    e.printStackTrace();
                }

                long dateInMilisec = date.getTime();
                openDatePickerBtn.setText(simpleDateFormat.format(date));
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, onDateSetListener, year, month, dayOfMonth);
        datePickerDialog.show();

    }

    private void init() {
        openDatePickerBtn = findViewById(R.id.openDatePickerBtn);
        openTimePickerBtn = findViewById(R.id.openTimePickerBtn);
    }
}
