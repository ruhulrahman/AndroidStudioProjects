package bd.com.hasan.app.dailyexpense;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseDetailsAdapter extends RecyclerView.Adapter<ExpenseDetailsAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Expense> expenses;
    private DatabaseHelper helper;

    public ExpenseDetailsAdapter(Context context, ArrayList<Expense> expenses, DatabaseHelper helper) {
        this.context = context;
        this.expenses = expenses;
        this.helper = helper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_expense_details,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Expense expense = expenses.get(position);

        holder.expenseTypeTV.setText(expense.getExpenseType());
        holder.amountTV.setText(expense.getExpenseAmount());
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView expenseTypeTV, amountTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            expenseTypeTV = itemView.findViewById(R.id.expenseTypeTV);
            amountTV = itemView.findViewById(R.id.amountTV);
        }
    }
}
