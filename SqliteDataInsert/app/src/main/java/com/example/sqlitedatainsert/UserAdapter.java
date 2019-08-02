package com.example.sqlitedatainsert;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<User> userList;
    private Context context;
    private Database helper;

    public UserAdapter(ArrayList<User> userList, Context context, Database helper) {
        this.userList = userList;
        this.context = context;
        this.helper = helper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_users, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final User user = userList.get(i);
        viewHolder.nameTv.setText(user.getName());
        viewHolder.ageTv.setText(user.getAge());
       viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
               helper = new Database(context);
               helper.deleteData(user.getId());
               userList.remove(i);
               notifyDataSetChanged();
               return false;
           }
       });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv, ageTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTV);
            ageTv = itemView.findViewById(R.id.ageTV);
        }
    }
}
