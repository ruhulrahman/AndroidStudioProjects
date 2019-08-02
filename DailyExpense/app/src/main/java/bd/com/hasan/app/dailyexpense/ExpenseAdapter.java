package bd.com.hasan.app.dailyexpense;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Expense> expenses;
    private DatabaseHelper helper;

    public ExpenseAdapter(Context context, ArrayList<Expense> expenses, DatabaseHelper helper) {
        this.context = context;
        this.expenses = expenses;
        this.helper = helper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_expene_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Expense expense = expenses.get(position);

    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView totalAmountTV;
        private Button dateBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            totalAmountTV = itemView.findViewById(R.id.totalAmountTV);
            dateBtn = itemView.findViewById(R.id.dateBtn);
        }
    }
}
