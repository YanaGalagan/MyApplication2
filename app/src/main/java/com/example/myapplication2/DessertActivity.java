package com.example.myapplication2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.DataBase.AppDatabase;
import com.example.myapplication2.models.FoodEntity;

import java.util.List;

public class DessertActivity extends AppCompatActivity {
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);
        db = AppDatabaseSingleton.getInstance(this);

        // Load the list of breakfast foods from the database
        new LoadFoodAsyncTask().execute();
    }

    private void displayFoodButtons(List<FoodEntity> foodEntities) {
        LinearLayout layout = findViewById(R.id.dessert_table);

        // Dynamically create buttons for each food item
        for (FoodEntity food : foodEntities) {
            Button button = new Button(this);
            button.setText(food.name);
            button.setOnClickListener(view -> showRecipeDialog(food.recipe));

            // Add the button to your layout
            layout.addView(button);
        }
    }

    private void showRecipeDialog(String recipe) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Рецепт блюда");
        builder.setMessage(recipe);
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private class LoadFoodAsyncTask extends AsyncTask<Void, Void, List<FoodEntity>> {
        @Override
        protected List<FoodEntity> doInBackground(Void... voids) {
            // Add dishes to the database in the background
            //addDishesToDatabase();

            // Load the list of breakfast foods from the database
            return db.foodDao().getFoodsByCategory("Дессерт");
        }

        @Override
        protected void onPostExecute(List<FoodEntity> foodEntities) {
            // Update UI with the loaded foodEntities
            displayFoodButtons(foodEntities);
        }
    }
    private void addDishesToDatabase() {
        // Creating instances of dessert dishes and adding them to the database
        FoodEntity dish1 = new FoodEntity("Тирамису", "Дессерт",
                "Состав:\n" +
                        "- 250 г маскарпоне\n" +
                        "- 3 яйца\n" +
                        "- 100 г сахара\n" +
                        "- 200 мл сильного кофе\n" +
                        "- 200 г савоярди\n" +
                        "- Какао\n" +
                        "- Ванильный сахар\n" +
                        "Приготовление:\n" +
                        "1. Смешайте маскарпоне с желтками и половиной сахара.\n" +
                        "2. Взбейте белки с оставшимся сахаром. Вмешивайте в смесь.\n" +
                        "3. Вымачивайте савоярди в кофе и слагайте слой в форму. Покройте маскапоне.\n" +
                        "4. Повторяйте слои. Посыпьте какао и ванильным сахаром.");

        FoodEntity dish2 = new FoodEntity("Панна котта с ягодным соусом", "Дессерт",
                "Состав:\n" +
                        "- 400 мл сливок\n" +
                        "- 100 г сахара\n" +
                        "- 1 ванильная стручка\n" +
                        "- 1 ч. ложка желатина\n" +
                        "- 2 ст. ложки воды\n" +
                        "- Ягоды (клубника, малина)\n" +
                        "- Сахар по вкусу\n" +
                        "Приготовление:\n" +
                        "1. Замачивайте желатин в воде.\n" +
                        "2. Варите сливки с сахаром и ванилью. Добавьте желатин.\n" +
                        "3. Выливайте в формы и охлаждайте. Подавайте с ягодным соусом.");

        FoodEntity dish3 = new FoodEntity("Шоколадный фондан", "Дессерт",
                "Состав:\n" +
                        "- 100 г черного шоколада\n" +
                        "- 100 г сливочного масла\n" +
                        "- 2 яйца\n" +
                        "- 100 г сахара\n" +
                        "- 50 г муки\n" +
                        "- Ванильный сахар\n" +
                        "Приготовление:\n" +
                        "1. Топите шоколад с маслом. Добавьте взбитые яйца с сахаром.\n" +
                        "2. Постепенно добавляйте муку, перемешивая. Добавьте ванильный сахар.\n" +
                        "3. Выливайте в формы и выпекайте 10-12 минут при 200°C.");

        FoodEntity dish4 = new FoodEntity("Малиновый чизкейк", "Дессерт",
                "Состав:\n" +
                        "- 200 г печенья\n" +
                        "- 80 г сливочного масла\n" +
                        "- 300 г творожного сыра\n" +
                        "- 100 г сахара\n" +
                        "- 2 яйца\n" +
                        "- 200 г малины\n" +
                        "- Сахарная пудра\n" +
                        "Приготовление:\n" +
                        "1. Измельчите печенье, смешайте с расплавленным маслом. Выложите в форму.\n" +
                        "2. Смешайте творожный сыр, сахар, яйца. Выложите на корж.\n" +
                        "3. Размешайте малину с сахаром. Распределите по тесту. Выпекайте 40-45 минут.");

        FoodEntity dish5 = new FoodEntity("Классический крем-брюле", "Дессерт",
                "Состав:\n" +
                        "- 4 яичных желтка\n" +
                        "- 100 г сахара\n" +
                        "- 500 мл сливок\n" +
                        "- Ваниль\n" +
                        "- Сахар для посыпки\n" +
                        "Приготовление:\n" +
                        "1. Взбивайте желтки с сахаром. Добавьте ваниль и сливки.\n" +
                        "2. Выливайте в формы и запекайте в водяной бане 40-45 минут.\n" +
                        "3. Посыпьте сахаром и подрумяньте факелом.");

        FoodEntity dish6 = new FoodEntity("Фруктовый тарт с ванильным кремом", "Дессерт",
                "Состав:\n" +
                        "- 200 г песочного теста\n" +
                        "- 250 мл молока\n" +
                        "- 3 желтка\n" +
                        "- 100 г сахара\n" +
                        "- 30 г муки\n" +
                        "- Ваниль\n" +
                        "- Фрукты (персики, ягоды)\n" +
                        "- Апельсиновый желе\n" +
                        "Приготовление:\n" +
                        "1. Раскатайте тесто и уложите в форму. Подпеките.\n" +
                        "2. Смешайте желтки, сахар, муку. Залейте молоком и варите венчиком.\n" +
                        "3. Вылейте крем в тесто и украсьте фруктами. Залейте желе.");

        FoodEntity dish7 = new FoodEntity("Мороженое в вафельной рожке", "Дессерт",
                "Состав:\n" +
                        "- 500 мл молока\n" +
                        "- 200 г сахара\n" +
                        "- 6 яичных желтков\n" +
                        "- Ваниль\n" +
                        "- 200 мл взбитых сливок\n" +
                        "- Вафельные рожки\n" +
                        "Приготовление:\n" +
                        "1. Загрейте молоко с сахаром. Взбивайте желтки и вливайте в молоко.\n" +
                        "2. Варите до загустения, добавьте ваниль. Охладите и добавьте взбитые сливки.\n" +
                        "3. Замораживайте смесь, выкладывайте в рожки и подавайте.");

        // Insert dessert dishes into the database
        db.foodDao().insertFood(dish1);
        db.foodDao().insertFood(dish2);
        db.foodDao().insertFood(dish3);
        db.foodDao().insertFood(dish4);
        db.foodDao().insertFood(dish5);
        db.foodDao().insertFood(dish6);
        db.foodDao().insertFood(dish7);
    }


}