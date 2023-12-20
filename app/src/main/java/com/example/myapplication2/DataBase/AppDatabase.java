package com.example.myapplication2.DataBase;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.myapplication2.models.FoodEntity;


@Database(entities = {FoodEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FoodDao foodDao();}
