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

public class SnackActivity extends AppCompatActivity {
    private AppDatabase db;
//салаты!!!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);
        db = AppDatabaseSingleton.getInstance(this);

        // Load the list of breakfast foods from the database
        new LoadFoodAsyncTask().execute();
    }

    private void displayFoodButtons(List<FoodEntity> foodEntities) {
        LinearLayout layout = findViewById(R.id.table_snack);

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
            return db.foodDao().getFoodsByCategory("Салат");
        }

        @Override
        protected void onPostExecute(List<FoodEntity> foodEntities) {
            // Update UI with the loaded foodEntities
            displayFoodButtons(foodEntities);
        }
    }
    private void addDishesToDatabase() {
        // Creating instances of salad dishes and adding them to the database
        FoodEntity dish1 = new FoodEntity("Греческий салат", "Салат",
                "Состав:\n" +
                        "- Помидоры\n" +
                        "- Огурцы\n" +
                        "- Красный лук\n" +
                        "- Красные оливки\n" +
                        "- 200 г фета\n" +
                        "- Оливковое масло, орегано\n" +
                        "- Соль, перец (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Нарежьте помидоры, огурцы, лук и оливки.\n" +
                        "2. Добавьте нарезанный сыр, полейте оливковым маслом, посыпьте орегано.");

        FoodEntity dish2 = new FoodEntity("Цезарь с курицей", "Салат",
                "Состав:\n" +
                        "- Зеленый салат (романо или айсберг)\n" +
                        "- 200 г куриного филе\n" +
                        "- Хлебные гренки\n" +
                        "- Помидоры черри\n" +
                        "- Пармезан\n" +
                        "- Соус Цезарь\n" +
                        "Приготовление:\n" +
                        "1. Обжарьте курицу, нарежьте на полоски.\n" +
                        "2. Смешайте салат с курицей, добавьте гренки, помидоры и посыпьте пармезаном.\n" +
                        "3. Полейте соусом.");

        FoodEntity dish3 = new FoodEntity("Салат Нисуаз с тунцом", "Салат",
                "Состав:\n" +
                        "- 200 г тунца (желательно консервированного)\n" +
                        "- 2 яйца\n" +
                        "- Картошка (вареная)\n" +
                        "- Зеленые бобы (вареные)\n" +
                        "- Помидоры черри\n" +
                        "- Зеленый салат\n" +
                        "- Оливки\n" +
                        "- Оливковое масло, горчица (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Уложите на тарелку картошку, яйца, зеленые бобы, помидоры и тунец.\n" +
                        "2. Полейте оливковым маслом, добавьте горчицу.");

        FoodEntity dish4 = new FoodEntity("Салат с авокадо и креветками", "Салат",
                "Состав:\n" +
                        "- Зеленый салат\n" +
                        "- 200 г креветок\n" +
                        "- 1 авокадо\n" +
                        "- Лимон\n" +
                        "- Красный лук\n" +
                        "- Оливковое масло, базилик\n" +
                        "- Соль, перец (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Обжарьте креветки, посолите, поперчите.\n" +
                        "2. Нарежьте авокадо, полейте лимонным соком.\n" +
                        "3. Смешайте салат, креветки, авокадо и лук, полейте оливковым маслом, посыпьте базиликом.");

        FoodEntity dish5 = new FoodEntity("Салат Цезарь с лососем", "Салат",
                "Состав:\n" +
                        "- Зеленый салат (романо или айсберг)\n" +
                        "- 200 г лосося (свежего или копченого)\n" +
                        "- Хлебные гренки\n" +
                        "- Пармезан\n" +
                        "- Соус Цезарь\n" +
                        "- Помидоры черри\n" +
                        "Приготовление:\n" +
                        "1. Разложите салат на тарелку, добавьте лосось, гренки и помидоры.\n" +
                        "2. Посыпьте пармезаном и полейте соусом Цезарь.");

        FoodEntity dish6 = new FoodEntity("Салат с рукколой и грушей", "Салат",
                "Состав:\n" +
                        "- Руккола\n" +
                        "- Груша\n" +
                        "- Голубой сыр\n" +
                        "- Грецкие орехи\n" +
                        "- Оливковое масло, бальзамический уксус\n" +
                        "- Мед\n" +
                        "- Соль, перец (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Нарежьте грушу и смешайте с рукколой.\n" +
                        "2. Добавьте голубой сыр и грецкие орехи.\n" +
                        "3. Полейте оливковым маслом, уксусом и медом, посолите и поперчите.");

        FoodEntity dish7 = new FoodEntity("Салат Таббуле с кинзой", "Салат",
                "Состав:\n" +
                        "- Петрушка\n" +
                        "- Помидоры\n" +
                        "- Огурцы\n" +
                        "- Молотый бульгур\n" +
                        "- Лимон\n" +
                        "- Кинза\n" +
                        "- Оливковое масло, мята\n" +
                        "- Соль, перец (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Замочите бульгур в горячей воде.\n" +
                        "2. Нарежьте помидоры, огурцы, петрушку и кинзу.\n" +
                        "3. Смешайте все ингредиенты, добавьте лимонный сок, оливковое масло и мяту. Посолите и поперчите.");

        // Insert salad dishes into the database
        db.foodDao().insertFood(dish1);
        db.foodDao().insertFood(dish2);
        db.foodDao().insertFood(dish3);
        db.foodDao().insertFood(dish4);
        db.foodDao().insertFood(dish5);
        db.foodDao().insertFood(dish6);
        db.foodDao().insertFood(dish7);
    }

}