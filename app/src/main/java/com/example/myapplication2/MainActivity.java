package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.DataBase.AppDatabase;

public class MainActivity extends AppCompatActivity {
    private AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBreakfestActivity();
            }
        });

        Button button2 = findViewById(R.id.button2); // замените "button_id" на реальный идентификатор вашей кнопки

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLanchActivity();
            }
        });

        Button button3 = findViewById(R.id.button3); // замените "button_id" на реальный идентификатор вашей кнопки

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDinnerActivity();
            }
        });

        Button button4 = findViewById(R.id.button4); // замените "button_id" на реальный идентификатор вашей кнопки

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSnackActivity();
            }
        });

        Button button5 = findViewById(R.id.button5); // замените "button_id" на реальный идентификатор вашей кнопки

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openDessertActivity();
            }
        });
    }



    private void openBreakfestActivity() {
        Intent intent = new Intent(this, BreakfastActivity.class);
        startActivity(intent);
    }
    private void openDinnerActivity() {
        Intent intent = new Intent(this, DinnerActivity.class);
        startActivity(intent);
    }
    private void openLanchActivity() {
        Intent intent = new Intent(this, LanchActivity.class);
        startActivity(intent);
    }
    private void openSnackActivity() {
        Intent intent = new Intent(this, SnackActivity.class);
        startActivity(intent);
    }
    private void openDessertActivity() {
        Intent intent = new Intent(this, DessertActivity.class);
        startActivity(intent);
    }

}


