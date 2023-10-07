package com.example.app_tasks.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_tasks.R;
import com.example.app_tasks.adapter.RecipeAdapter;
import com.example.app_tasks.model.Recipe;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerHome;

    private DrawerLayout drawerAbout;
    //itens menu
    private DrawerLayout actualDrawer;
    private RecyclerView recyclerView;
    private List<Recipe> recipe = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerHome      = findViewById(R.id.drawerHome);

        drawerAbout     = findViewById(R.id.aboutLayout);

        actualDrawer    = findViewById(R.id.drawerHome);

        recyclerView    = findViewById(R.id.recyclerViewRecipe);
        reciclerConfig();

    }


    public void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void home(View view){
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void aboutOpenFragment(View view){
        Intent intent = new Intent(MainActivity.this, AboutMenu.class);
        startActivity(intent);
        actualDrawer    = findViewById(R.id.aboutLayout);

    }

    public void openMenu(View view){openDrawer(actualDrawer);}

    public void reciclerConfig(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecipeAdapter adapter = new RecipeAdapter(recipe);
        recyclerView.setAdapter(adapter);
        reciveSend();
    }

    public void logoutItemList(View view){
        logoutMenu(MainActivity.this);
    }
    public void reciveSend(){
        Recipe r = new Recipe("Panqueca salguada", "Uma ótia opção de pré-treino", R.drawable.panqu);
        this.recipe.add(r);
        r = new Recipe("Salada Gourmet", "Salada completa com excelente fontes de energia", R.drawable.salad);
        this.recipe.add(r);
        r = new Recipe("Panqueca com blueberry", "Excelente opção para um café da mnhã em familia", R.drawable.panqueca);
        this.recipe.add(r);
        r = new Recipe("Biscoito de aveia com banana", "Um lanchinho da tarde espetacular não pode faltar", R.drawable.biscoito);
        this.recipe.add(r);

    }

    private void logoutMenu(MainActivity mainActivity){
        AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
        builder.setTitle("Sair");
        builder.setMessage("Deseja sair da aplicação?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

}