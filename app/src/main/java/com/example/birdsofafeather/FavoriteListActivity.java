package com.example.birdsofafeather;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.birdsofafeather.models.db.AppDatabase;
import com.example.birdsofafeather.models.db.StudentWithCourses;

import java.util.List;

public class FavoriteListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_list);
        AppDatabase db = AppDatabase.singleton(this);
        List<StudentWithCourses> favorites = db.studentWithCoursesDao().getFavorites();

        FavoriteViewAdapter studentsViewAdapter;

        // Set up the RecycleView for the list of favorites
        RecyclerView studentsRecycleView = findViewById(R.id.favorites_recycler_view);
        RecyclerView.LayoutManager studentsLayoutManager = new LinearLayoutManager(this);
        studentsRecycleView.setLayoutManager(studentsLayoutManager);

        // Pass in student list to the adapter for the RecycleView
        studentsViewAdapter = new FavoriteViewAdapter(favorites);
        studentsRecycleView.setAdapter(studentsViewAdapter);

    }


}