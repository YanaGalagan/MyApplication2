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

public class DinnerActivity extends AppCompatActivity {
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);
        db = AppDatabaseSingleton.getInstance(this);

        // Load the list of breakfast foods from the database
        new LoadFoodAsyncTask().execute();
    }

    private void displayFoodButtons(List<FoodEntity> foodEntities) {
        LinearLayout layout = findViewById(R.id.table_dinner);

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
            return db.foodDao().getFoodsByCategory("Обед");
        }

        @Override
        protected void onPostExecute(List<FoodEntity> foodEntities) {
            // Update UI with the loaded foodEntities
            displayFoodButtons(foodEntities);
        }
    }
    private void addDishesToDatabase() {
        // Creating instances of lunch dishes and adding them to the database
        FoodEntity dish1 = new FoodEntity("Паста Болоньезе", "Обед",
                "Состав:\n" +
                        "- 300 г фарфалле или другой пасты\n" +
                        "- 250 г фарша (говядина/свинина)\n" +
                        "- Лук, морковь, сельдерей (по вкусу)\n" +
                        "- 2 ст. ложки томатной пасты\n" +
                        "- Соль, перец, базилик (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Обжарьте лук, морковь, и сельдерей. Добавьте фарш и обжаривайте до коричневого цвета.\n" +
                        "2. Добавьте томатную пасту, соль, перец, базилик. Тушите 15-20 минут.\n" +
                        "3. Варите пасту и добавьте к соусу.");

        FoodEntity dish2 = new FoodEntity("Куриный салат с авокадо", "Обед",
                "Состав:\n" +
                        "- 200 г куриного филе (вареного или жареного)\n" +
                        "- 1 авокадо\n" +
                        "- Помидоры\n" +
                        "- Зеленый салат\n" +
                        "- Оливковое масло, лимонный сок (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Нарежьте куриное филе, авокадо, помидоры и салат.\n" +
                        "2. Смешайте все ингредиенты и посыпьте лимонным соком и оливковым маслом.");

        FoodEntity dish3 = new FoodEntity("Ризотто с грибами", "Обед",
                "Состав:\n" +
                        "- 1 стакан риса\n" +
                        "- 200 г грибов (шампиньоны или другие)\n" +
                        "- Лук, чеснок\n" +
                        "- 1/2 стакана белого вина\n" +
                        "- 500 мл куриного бульона\n" +
                        "- Пармезан, соль, перец (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Обжарьте лук и чеснок, добавьте рис и грибы.\n" +
                        "2. Залейте вино и доведите до кипения. Постепенно добавляйте куриный бульон.\n" +
                        "3. Посолите, поперчите, посыпьте пармезаном.");

        FoodEntity dish4 = new FoodEntity("Тайская курица с кокосовым молоком", "Обед",
                "Состав:\n" +
                        "- 300 г куриного филе\n" +
                        "- 1 банка кокосового молока\n" +
                        "- Красный карри-паста\n" +
                        "- Лимонная трава, имбирь, чеснок (по вкусу)\n" +
                        "- Рис для подачи\n" +
                        "Приготовление:\n" +
                        "1. Обжарьте курицу с карри-пастой. Добавьте нарезанный имбирь, чеснок и лимонную траву.\n" +
                        "2. Добавьте кокосовое молоко и тушите до готовности.\n" +
                        "3. Подавайте с рисом.");

        FoodEntity dish5 = new FoodEntity("Суп-лапша с курицей и овощами", "Обед",
                "Состав:\n" +
                        "- 200 г куриного филе\n" +
                        "- Лапша (яичная или рисовая)\n" +
                        "- Морковь, лук, грибы (по вкусу)\n" +
                        "- Соевый соус, имбирь, чеснок (по вкусу)\n" +
                        "- Зеленый лук для подачи\n" +
                        "Приготовление:\n" +
                        "1. Обжарьте курицу с луком, морковью и грибами.\n" +
                        "2. Добавьте лапшу и варите, добавляя соус, имбирь и чеснок.\n" +
                        "3. Подавайте с нарезанным зеленым луком.");

        FoodEntity dish6 = new FoodEntity("Картошка по-деревенски", "Обед",
                "Состав:\n" +
                        "- 500 г картошки\n" +
                        "- Лук, чеснок\n" +
                        "- Приправы (паприка, розмарин, тимьян)\n" +
                        "- Оливковое масло\n" +
                        "Приготовление:\n" +
                        "1. Нарежьте картошку дольками, добавьте нарезанный лук и чеснок.\n" +
                        "2. Обсыпьте приправами, полейте оливковым маслом и запекайте в духовке.");

        FoodEntity dish7 = new FoodEntity("Салат Нисуаз", "Обед",
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

        // Insert lunch dishes into the database
        db.foodDao().insertFood(dish1);
        db.foodDao().insertFood(dish2);
        db.foodDao().insertFood(dish3);
        db.foodDao().insertFood(dish4);
        db.foodDao().insertFood(dish5);
        db.foodDao().insertFood(dish6);
        db.foodDao().insertFood(dish7);
    }



}
