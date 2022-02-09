package com.example.birdsofafeather.models.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface StudentWithCoursesDao {
   @Transaction
   @Query("SELECT * FROM students")
   List<StudentWithCourses> getAll();

   @Query("SELECT * FROM students WHERE id=:id")
   StudentWithCourses get(int id);

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   void add(Student student);

   @Delete
   void delete(Student student);

   @Query("SELECT COUNT(*) FROM students")
   int count();
}
