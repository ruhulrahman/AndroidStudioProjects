package com.testing.dev.firebasedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.testing.dev.firebasedatabase.databinding.ModelCourseItemBinding;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private List<Course> courseList;
    private Context context;

    public CourseAdapter(List<Course> courseList, Context context) {
        this.courseList = courseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ModelCourseItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.model_course_item,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course course = courseList.get(position);

        holder.binding.titleTV.setText(course.getTitle());
        holder.binding.codeTV.setText(course.getCode());
        holder.binding.creditTV.setText(String.valueOf(course.getCredit()));
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ModelCourseItemBinding binding;

        public ViewHolder(ModelCourseItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
