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

public class LanchActivity extends AppCompatActivity {
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanch);
        db = AppDatabaseSingleton.getInstance(this);

        // Load the list of breakfast foods from the database
        new LoadFoodAsyncTask().execute();
    }

    private void displayFoodButtons(List<FoodEntity> foodEntities) {
        LinearLayout layout = findViewById(R.id.table_lanch);

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
            return db.foodDao().getFoodsByCategory("Первое блюдо");
        }

        @Override
        protected void onPostExecute(List<FoodEntity> foodEntities) {
            // Update UI with the loaded foodEntities
            displayFoodButtons(foodEntities);
        }
    }
    private void addDishesToDatabase() {
        // Creating instances of first course dishes and adding them to the database
        FoodEntity dish1 = new FoodEntity("Борщ", "Первое блюдо",
                "Состав:\n" +
                        "- 300 г свеклы\n" +
                        "- 200 г моркови\n" +
                        "- 200 г картошки\n" +
                        "- 100 г капусты\n" +
                        "- 1 луковица\n" +
                        "- 2 ст. ложки томатной пасты\n" +
                        "- 200 г говядины\n" +
                        "- 2 картофельные лепешки\n" +
                        "- Зелень, соль, перец (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Обжарьте лук, добавьте мясо, свеклу, морковь, картошку и капусту.\n" +
                        "2. Добавьте томатную пасту и варите до готовности.\n" +
                        "3. Подавайте с картофельными лепешками и зеленью.");

        FoodEntity dish2 = new FoodEntity("Куриный суп с лапшой", "Первое блюдо",
                "Состав:\n" +
                        "- 200 г куриного филе\n" +
                        "- Лапша (яичная или рисовая)\n" +
                        "- Морковь, лук, картошка\n" +
                        "- Петрушка, лавровый лист\n" +
                        "- Соль, перец (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Варите куриное филе, добавьте нарезанные овощи.\n" +
                        "2. Добавьте лапшу, петрушку и лавровый лист.\n" +
                        "3. Посолите, поперчите по вкусу.");

        FoodEntity dish3 = new FoodEntity("Грибной крем-суп", "Первое блюдо",
                "Состав:\n" +
                        "- 300 г грибов (шампиньоны или лисички)\n" +
                        "- 1 луковица\n" +
                        "- 2 ст. ложки муки\n" +
                        "- 500 мл куриного бульона\n" +
                        "- 200 мл сливок\n" +
                        "- Лавровый лист, тимьян\n" +
                        "- Соль, перец (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Обжарьте лук, добавьте грибы и муку.\n" +
                        "2. Залейте куриной бульоном, добавьте лавровый лист и тимьян.\n" +
                        "3. Варите 15 минут, затем добавьте сливки, посолите и поперчите.");

        FoodEntity dish4 = new FoodEntity("Томатный суп с базиликом", "Первое блюдо",
                "Состав:\n" +
                        "- 500 г помидоров\n" +
                        "- 1 луковица\n" +
                        "- 2 зубчика чеснока\n" +
                        "- 1 морковь\n" +
                        "- 1 ст. ложка томатной пасты\n" +
                        "- 500 мл овощного бульона\n" +
                        "- Свежий базилик\n" +
                        "- Соль, перец (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Обжарьте лук, чеснок, морковь и помидоры.\n" +
                        "2. Добавьте томатную пасту и бульон, варите 20 минут.\n" +
                        "3. Пюрируйте суп, добавьте свежий базилик, посолите и поперчите.");

        FoodEntity dish5 = new FoodEntity("Чечевичный суп", "Первое блюдо",
                "Состав:\n" +
                        "- 1 стакан красной чечевицы\n" +
                        "- 1 луковица\n" +
                        "- 2 моркови\n" +
                        "- 2 зубчика чеснока\n" +
                        "- Лавровый лист, тимьян\n" +
                        "- 1 литр овощного бульона\n" +
                        "- Соль, перец (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Обжарьте лук, морковь и чеснок, добавьте чечевицу и бульон.\n" +
                        "2. Добавьте лавровый лист и тимьян, варите до готовности.\n" +
                        "3. Посолите и поперчите.");

        FoodEntity dish6 = new FoodEntity("Карри-суп с креветками", "Первое блюдо",
                "Состав:\n" +
                        "- 300 г креветок\n" +
                        "- 1 луковица\n" +
                        "- 2 зубчика чеснока\n" +
                        "- 1 морковь\n" +
                        "- 1 ст. ложка карри-пасты\n" +
                        "- 400 мл кокосового молока\n" +
                        "- Лайм, кинза\n" +
                        "- Соль, перец (по вкусу)\n" +
                        "Приготовление:\n" +
                        "1. Обжарьте лук, чеснок и морковь, добавьте креветки и карри-пасту.\n" +
                        "2. Залейте кокосовым молоком и варите 15-20 минут.\n" +
                        "3. Посолите, поперчите, добавьте лайм и кинзу.");

        FoodEntity dish7 = new FoodEntity("Рамен с курицей", "Первое блюдо",
                "Состав:\n" +
                        "- 200 г куриного филе\n" +
                        "- Яичная лапша\n" +
                        "- Лук, чеснок\n" +
                        "- Морковь, шампиньоны\n" +
                        "- 1 литр куриного бульона\n" +
                        "- Соевый соус, имбирь (по вкусу)\n" +
                        "- Зеленый лук, кунжут\n" +
                        "Приготовление:\n" +
                        "1. Обжарьте лук, чеснок, морковь и грибы. Добавьте курицу и обжаривайте.\n" +
                        "2. Добавьте бульон, яичную лапшу, соевый соус и имбирь.\n" +
                        "3. Подавайте, посыпанный нарезанным зеленым луком и кунжутом.");

        // Insert first course dishes into the database
        db.foodDao().insertFood(dish1);
        db.foodDao().insertFood(dish2);
        db.foodDao().insertFood(dish3);
        db.foodDao().insertFood(dish4);
        db.foodDao().insertFood(dish5);
        db.foodDao().insertFood(dish6);
        db.foodDao().insertFood(dish7);
    }

}