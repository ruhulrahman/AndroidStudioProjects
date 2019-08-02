package com.example.sqliteinsertviewdelete;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<User> userList;
    private DatabaseHelper helper;
    private Context context;

    public UserAdapter(ArrayList<User> userList, DatabaseHelper helper, Context context) {
        this.userList = userList;
        this.helper = helper;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_users, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final User user = userList.get(i);
        viewHolder.nameTV.setText(user.getName());
        viewHolder.ageTV.setText(user.getAge());
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                helper = new DatabaseHelper(context);
                helper.deleteData(user.getId());
                userList.remove(i);
                notifyDataSetChanged();
                return false;
            }
        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("name", user.getName());
                intent.putExtra("age", user.getAge());
                intent.putExtra("id", String.valueOf(user.getId()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTV, ageTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.nameTV);
            ageTV = itemView.findViewById(R.id.ageTV);
        }
    }
}
