package bd.com.hasan.app.dailyexpense;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ExpenseListActivity extends AppCompatActivity {

    private RecyclerView expenseListRV;
    private ArrayList<Expense> expenses;
    private RelativeLayout startDateLayout, endDateLayout;
    private TextView startDateTV, endDateTV;

    private DatabaseHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expene_list);

        init();
        //DatePicker Start
        startDateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDatePick();
            }
        });
        endDateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endDatePick();
            }
        });
        //DatePicker Start End
    }

    private void endDatePick() {

        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String currentDate = year + "/" + month + "/" + day;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

                Date date = null;

                try {
                    date = simpleDateFormat.parse(currentDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long endDateInMilisec = date.getTime();

                endDateTV.setText(simpleDateFormat.format(date));
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.YEAR;
        int month = calendar.MONTH;
        int day = Calendar.DAY_OF_MONTH;

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,onDateSetListener,year,month,01);
        datePickerDialog.show();

    }

    private void startDatePick() {
        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String currentDate = year + "/" + month + "/" + day;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

                Date date = null;

                try {
                    date = simpleDateFormat.parse(currentDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long startDateInMilisec = date.getTime();

                startDateTV.setText(simpleDateFormat.format(date));
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.YEAR;
        int month = calendar.MONTH;
        int day = Calendar.DAY_OF_MONTH;

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,onDateSetListener,year,month,01);
        datePickerDialog.show();
    }

    private void init() {

        expenseListRV = findViewById(R.id.expenseListRV);
        startDateLayout = findViewById(R.id.startDateLayoute);
        endDateLayout = findViewById(R.id.endDateLayoute);
        startDateTV = findViewById(R.id.startDateTVe);
        endDateTV = findViewById(R.id.endDateTVe);
        expenses = new ArrayList<>();

    }
}
