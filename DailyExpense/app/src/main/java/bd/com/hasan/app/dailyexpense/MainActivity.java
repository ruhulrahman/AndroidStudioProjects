package bd.com.hasan.app.dailyexpense;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

import bd.com.hasan.app.dailyexpense.Fragments.MainActivityMonthFragment;
import bd.com.hasan.app.dailyexpense.Fragments.MainActivityTodayFragment;
import bd.com.hasan.app.dailyexpense.Fragments.MainActivityWeakFragment;

public class MainActivity extends AppCompatActivity {

    private Button monthFragmentBtn, weakFragmentBtn, todayFragmentBtn;
    private RelativeLayout startDateLayout, endDateLayout;
    private TextView startDateTV, endDateTV;
    private DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

//        Fragment portion start

        replaceFragment(new MainActivityMonthFragment());

        monthFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new MainActivityMonthFragment());
            }
        });
        weakFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new MainActivityWeakFragment());
            }
        });
        todayFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new MainActivityTodayFragment());
            }
        });
//        Fragment portion start

        datePick();

    }
    private void init() {

        monthFragmentBtn = findViewById(R.id.monthFragmentBtn);
        weakFragmentBtn = findViewById(R.id.weakFragmentBtn);
        todayFragmentBtn = findViewById(R.id.todayFragmentBtn);
        startDateLayout = findViewById(R.id.startDateLayout);
        endDateLayout = findViewById(R.id.endDateLayout);
        startDateTV = findViewById(R.id.startDateTV);
        endDateTV = findViewById(R.id.endDateTV);
    }

    private void replaceFragment(Fragment fragment) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.expenseFramaLayout,fragment);
        ft.commit();
    }

    private void datePick() {

        startDateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,android.R.style.Theme_DeviceDefault_Dialog_MinWidth,dateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));
                dialog.show();
            }
        });
        endDateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,android.R.style.Theme_DeviceDefault_Dialog_MinWidth,dateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String startDate = month + " - " + day + " - " + year;
                startDateTV.setText(startDate);
                String endDate = month + " - " + day + " - " + year;
                endDateTV.setText(endDate);
            }
        };
    }

    public void addExpense(View view) {
        startActivity(new Intent(MainActivity.this,AddExpenseActivity.class));
    }

    public void expenseList(View view) {
        startActivity(new Intent(MainActivity.this,ExpenseListActivity.class));
    }
}
