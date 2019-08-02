package bd.com.hasan.app.dailyexpense;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddExpenseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText amountET, datetET, timeET;
    private ImageView documentIV;
    private Button updateDocumentBtn, saveBtn;

    private String date, time, amount,expenseType;

    private DatabaseHelper helper;

    private Spinner expenseTypeSpnr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        init();

        // Spinner Start
        expenseTypeSpnr.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Food Bill");
        categories.add("Electricity Bill");
        categories.add("TranspoartBil");
        categories.add("House Rent");
        categories.add("Tution Fee");
        categories.add("Medical Bil");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        expenseTypeSpnr.setAdapter(dataAdapter);

        // Spinner End

        // Datepicker and Timepicker Start
        datetET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker();
            }
        });
        timeET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker();
            }
        });
        // Datepicker and Timepicker end

        // Camera Start for Update Document Start

        updateDocumentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }
        });

        // Camera Start for Update Document end

        //Save to database
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

    }

    // Saving data in database

    private void saveData() {

        amount = amountET.getText().toString();
        date = datetET.getText().toString();
        time = timeET.getText().toString();

        long id = helper.insertData(expenseType,amount,date,time);
        Toast.makeText(AddExpenseActivity.this, "ID is "+id, Toast.LENGTH_LONG).show();

        startActivity(new Intent(AddExpenseActivity.this,ExpenceDetailsActivity.class));

    }

    // Saving data in database end

    // Datepicker and Timepicker Method
    private void datePicker() {

        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String currentDate = year + "/" + month + "/" + day;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" yyyy/MM/dd");

                Date date = null;

                try {
                    date = simpleDateFormat.parse(currentDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long dateInMilisec = date.getTime();

                datetET.setText(simpleDateFormat.format(date));
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.YEAR;
        int month = calendar.MONTH;
        int day = calendar.DAY_OF_MONTH;

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,onDateSetListener,year, month, day);
        datePickerDialog.show();

    }

    private void timePicker() {

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minuite) {
                String currentTime = hour + ":" + minuite;
                SimpleDateFormat simpletimmeFormat = new SimpleDateFormat(" hh:mm:ss aa");

                Time time = null;

                try {
                    time = (Time) simpletimmeFormat.parse(currentTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long timeInMilisec = time.getTime();
                timeET.setText(simpletimmeFormat.format(time));
            }
        };

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.HOUR_OF_DAY;
        int minuite = calendar.MINUTE;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,onTimeSetListener,hour,minuite,false);
        timePickerDialog.show();
    }
    // Datepicker and Timepicker Method end

    private void init() {
        amountET = findViewById(R.id.amountET);
        datetET = findViewById(R.id.datetET);
        timeET = findViewById(R.id.timetET);
        documentIV = findViewById(R.id.documentIV);
        updateDocumentBtn = findViewById(R.id.updateDocumentBtn);
        saveBtn = findViewById(R.id.saveBtn);
        expenseTypeSpnr = findViewById(R.id.expenseTypeSpnr);
    }

//Spinner Methods
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

        expenseType = adapterView.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    //Spinner Methods end

    //Camera Override Method For Result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK)
        {
            if (requestCode == 1)
            {
                Bundle bundle = data.getExtras();
                Bitmap bitmap= (Bitmap) bundle.get("data");
                documentIV.setImageBitmap(bitmap);
            }
        }
    }
}
