package com.example.myapplication2.models;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "food_table")
public class FoodEntity {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public String name;
    public String category;
    public String recipe;
    public FoodEntity(String name, String category, String recipe) {
        this.name = name;
        this.category = category;
        this.recipe = recipe;
    }


}
