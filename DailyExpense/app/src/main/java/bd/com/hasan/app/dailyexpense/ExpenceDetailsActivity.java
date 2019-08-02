package bd.com.hasan.app.dailyexpense;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenceDetailsActivity extends AppCompatActivity {

    private TextView dateTV;
    private RecyclerView expenseDetailsRV;
    private ArrayList<Expense> expenses;
    private DatabaseHelper helper;

    private ExpenseDetailsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expence_details);

        init();

        setAdapter();
        getExpenseData();

    }

    private void setAdapter() {

        expenseDetailsRV.setLayoutManager(new LinearLayoutManager(this));
        expenseDetailsRV.setAdapter(adapter);

    }

    private void getExpenseData() {

        Cursor cursor=  helper.showData();
        while (cursor.moveToNext()){

            int id = cursor.getInt(cursor.getColumnIndex(helper.COL_ID));
            String expenseType= cursor.getString(cursor.getColumnIndex(helper.COL_EXPENSETYPE));
            String expenseAmount = cursor.getString(cursor.getColumnIndex(helper.COL_Amount));
            String expenseDate = cursor.getString(cursor.getColumnIndex(helper.COL_DATE));
            String expenseTime = cursor.getString(cursor.getColumnIndex(helper.COL_TIME));

            expenses.add(new Expense(id,expenseAmount,expenseDate,expenseTime,expenseType));
            adapter.notifyDataSetChanged();
        }
    }

    private void init() {
        dateTV = findViewById(R.id.dateTV);
        expenseDetailsRV = findViewById(R.id.expenseDetailsRV);
        expenses = new ArrayList<>();

        adapter = new ExpenseDetailsAdapter(this,expenses,helper);
    }
}
