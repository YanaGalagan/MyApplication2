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

public class BreakfastActivity extends AppCompatActivity {
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        db = AppDatabaseSingleton.getInstance(this);

        // Load the list of breakfast foods from the database
        new LoadFoodAsyncTask().execute();
    }

    private void displayFoodButtons(List<FoodEntity> foodEntities) {
        LinearLayout layout = findViewById(R.id.table);

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
            return db.foodDao().getFoodsByCategory("Завтрак");
        }

        @Override
        protected void onPostExecute(List<FoodEntity> foodEntities) {
            // Update UI with the loaded foodEntities
            displayFoodButtons(foodEntities);
        }
    }

    private void addDishesToDatabase() {
        // Creating instances of breakfast dishes and adding them to the database
        FoodEntity dish1 = new FoodEntity("Омлет с овощами", "Завтрак",
                "Состав:\n" +
                        "- 3 яйца\n" +
                        "- Помидоры, перец, лук (по вкусу)\n" +
                        "- Соль, перец (по вкусу)\n" +
                        "- Разрыхлитель теста\n" +
                        "- Разрыхлитель теста\n" +
                        "Приготовление:\n" +
                        "1. Взбейте яйца венчиком.\n" +
                        "2. Добавьте порезанные овощи, соль, перец и тщательно перемешайте.\n" +
                        "3. Вылейте смесь на разогретую сковороду, жарьте до готовности.");

        FoodEntity dish2 = new FoodEntity("Греческий йогурт с медом и орехами", "Завтрак",
                "Состав:\n" +
                        "- 1 стакан греческого йогурта\n" +
                        "- 2 ст. ложки меда\n" +
                        "- Грецкие орехи (по вкусу)\n" +
                        "- Фрукты (по желанию)\n" +
                        "Приготовление:\n" +
                        "1. Смешайте йогурт с медом.\n" +
                        "2. Посыпьте орехами и добавьте фрукты.");

        FoodEntity dish3 = new FoodEntity("Фруктовый салат", "Завтрак",
                "Состав:\n" +
                        "- Яблоки, бананы, клубника, виноград (по вкусу)\n" +
                        "- 2 ст. ложки меда\n" +
                        "- Сок половины лимона\n" +
                        "Приготовление:\n" +
                        "1. Нарежьте фрукты и полейте их лимонным соком.\n" +
                        "2. Полейте медом и перемешайте.");

        FoodEntity dish4 = new FoodEntity("Авокадо-тост", "Завтрак",
                "Состав:\n" +
                        "- Хлеб (желательно цельнозерновой)\n" +
                        "- Авокадо\n" +
                        "- Соль, перец, оливковое масло\n" +
                        "Приготовление:\n" +
                        "1. Выложите кусочки авокадо на хлеб.\n" +
                        "2. Посыпьте солью, перцем и добавьте немного оливкового масла.");

        FoodEntity dish5 = new FoodEntity("Чиа-пудинг", "Завтрак",
                "Состав:\n" +
                        "- 3 ст. ложки семян чиа\n" +
                        "- 1 стакан молока (любого)\n" +
                        "- Ванильный сахар (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Смешайте семена чиа с молоком и ванильным сахаром.\n" +
                        "2. Поставьте в холодильник на ночь.");

        FoodEntity dish6 = new FoodEntity("Панкейки", "Завтрак",
                "Состав:\n" +
                        "- 1 стакан муки\n" +
                        "- 1 яйцо\n" +
                        "- 1 стакан молока\n" +
                        "- 2 ст. ложки сахара\n" +
                        "- 1 ч. ложка разрыхлителя теста\n" +
                        "Приготовление:\n" +
                        "1. Смешайте все ингредиенты в миске.\n" +
                        "2. Жарьте ложки теста на сковороде до золотистой корки.");

        FoodEntity dish7 = new FoodEntity("Сэндвич с лососем", "Завтрак",
                "Состав:\n" +
                        "- Хлеб (желательно черный)\n" +
                        "- Лосось (копченый или свежий)\n" +
                        "- Сметана или крем-фреш\n" +
                        "- Укроп (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Намазывайте сметану на хлеб.\n" +
                        "2. Уложите лосось сверху и посыпьте мелко нарезанным укропом.");

        // Insert breakfast dishes into the database
        db.foodDao().insertFood(dish1);
        db.foodDao().insertFood(dish2);
        db.foodDao().insertFood(dish3);
        db.foodDao().insertFood(dish4);
        db.foodDao().insertFood(dish5);
        db.foodDao().insertFood(dish6);
        db.foodDao().insertFood(dish7);
    }
}
