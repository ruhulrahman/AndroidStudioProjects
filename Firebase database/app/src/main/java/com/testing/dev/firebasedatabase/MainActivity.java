package com.testing.dev.firebasedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.testing.dev.firebasedatabase.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<Course> courseList;
    private CourseAdapter courseAdapter;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        init();

        userId = firebaseAuth.getCurrentUser().getUid();

        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = binding.courseTitleET.getText().toString();
                String code = binding.courseCodeET.getText().toString();
                int credit = Integer.parseInt(binding.courseCreditET.getText().toString());

                saveCourse(title,code,credit);
            }
        });

        getCourses();


    }

    private void getCourses() {
        DatabaseReference coursesRef = databaseReference.child("users").child(userId).child("courses");
        coursesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    courseList.clear();
                    for (DataSnapshot data:dataSnapshot.getChildren()){
                        Course course = data.getValue(Course.class);
                        courseList.add(course);
                        courseAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void saveCourse(String title, String code, int credit) {
        DatabaseReference courseRef = databaseReference.child("users").child(userId).child("courses");

        String courseId = courseRef.push().getKey();
        Course course = new Course(title,code,credit,courseId);


        courseRef.child(courseId).setValue(course).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        courseList = new ArrayList<>();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        courseAdapter = new CourseAdapter(courseList,this);
        binding.coursesRV.setLayoutManager(new LinearLayoutManager(this));
        binding.coursesRV.setAdapter(courseAdapter);
    }
}
