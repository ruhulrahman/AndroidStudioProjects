package com.example.dailyexpenseapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.dailyexpenseapp.databinding.ActivityAddExpanseBinding;

import java.io.ByteArrayOutputStream;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddExpanseActivity extends AppCompatActivity {
    private DatabaseHelper helper;
    private ActivityAddExpanseBinding binding;
    private String date, time, type, image;
    private Double amount;
    private boolean result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_expanse);

        helper = new DatabaseHelper(this);

        binding.expanseDateET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker();
            }
        });
        binding.expanseTimeET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimePicker();
            }
        });

        expanseDataInsert();

    }

    private void openDatePicker() {
        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month +1;
                String currentDate = year+"/"+month+"/"+dayOfMonth+" 00:00:00";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date = new Date();
                try {
                    date = simpleDateFormat.parse(currentDate);
                }catch (ParseException e){
                    e.printStackTrace();
                }

                long dateInMiniSec = date.getTime();
                binding.expanseDateET.setText(simpleDateFormat.format(date));
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, onDateSetListener, year, month, day);
        datePickerDialog.show();
    }

    private void openTimePicker() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.custom_time_picker, null);
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
                Time time = new Time(hour, min, 0);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss aa");
                binding.expanseTimeET.setText(simpleDateFormat.format(time));
                dialog.dismiss();
            }
        });
    }

    private void expanseDataInsert() {
        result = false;
        binding.addExpanseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = binding.expanseTypeSn.getSelectedItem().toString();
                amount = Double.parseDouble(binding.expanseAmountET.getText().toString());
                date = binding.expanseDateET.getText().toString();
                time = binding.expanseTimeET.getText().toString();
                image = binding.documentImageIV.get
                String myBase64Image = encodeToBase64(myBitmap, Bitmap.CompressFormat.PNG, 100);
                if(amount.equals("")){
                    Toast.makeText(AddExpanseActivity.this, "Please enter amount", Toast.LENGTH_SHORT).show();
                }else if(date.equals("")){
                    Toast.makeText(AddExpanseActivity.this, "Please pickup date", Toast.LENGTH_SHORT).show();
                }else if(time.equals("")){
                    Toast.makeText(AddExpanseActivity.this, "Please pickup time", Toast.LENGTH_SHORT).show();
                }else{
                    long id = helper.insertData(type, amount, date, time);
                    result = true;
                    if(result == true){
                        binding.expanseAmountET.setText("");
                        binding.expanseDateET.setText("");
                        binding.expanseTimeET.setText("");
                        binding.documentImageIV.setImageURI(null);
                        binding.expanseTypeSn.setSelection(0);
                    }
                    Toast.makeText(AddExpanseActivity.this, "ID "+id, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void addDocumentBtn(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            Uri uri = data.getData();
            binding.documentImageIV.setImageURI(uri);
        }
    }

    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality)
    {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }
}
