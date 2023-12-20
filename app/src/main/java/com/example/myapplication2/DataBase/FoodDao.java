package com.example.myapplication2.DataBase;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.myapplication2.models.FoodEntity;
import java.util.List;

@Dao
public interface FoodDao {
    @Insert
    long insertFood(FoodEntity food);

    @Query("SELECT * FROM food_table WHERE category = :category")
    List<FoodEntity> getFoodsByCategory(String category);

}
