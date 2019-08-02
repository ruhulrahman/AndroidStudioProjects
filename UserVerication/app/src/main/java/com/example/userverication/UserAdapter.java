package com.example.userverication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<User> userList;
    private Context context;

    public UserAdapter(ArrayList<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user_activity, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final User user = userList.get(i);
        viewHolder.profileIV.setImageResource(user.getUserImage());
        viewHolder.emailTv.setText(user.getUserEmail());
        viewHolder.nameTv.setText(user.getUserName());
        if (user.isVerified() == true){
            viewHolder.verifiedTv.setText("Verified");
            viewHolder.verifiedTv.setTextColor(context.getResources().getColor(R.color.colorPrimary));
        }else{
            viewHolder.verifiedTv.setText("Not Verified");
            viewHolder.verifiedTv.setTextColor(context.getResources().getColor(R.color.red));
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("image", user.getUserImage());
                intent.putExtra("name", user.getUserName());
                intent.putExtra("email", user.getUserEmail());
                intent.putExtra("isVerified", user.isVerified());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView profileIV;
        private TextView nameTv, emailTv, verifiedTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileIV = itemView.findViewById(R.id.profileIV);
            nameTv = itemView.findViewById(R.id.nameTv);
            emailTv = itemView.findViewById(R.id.emailTv);
            verifiedTv = itemView.findViewById(R.id.verifiedTv);
        }
    }
}
