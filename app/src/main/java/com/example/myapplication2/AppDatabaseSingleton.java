package com.example.myapplication2;
import android.content.Context;
import androidx.room.Room;
import com.example.myapplication2.DataBase.AppDatabase;
public class AppDatabaseSingleton {
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "имя_вашей_базы_данных")
                    .build();
        }
        return instance;
    }
}

