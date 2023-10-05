package com.example.app_tasks.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_tasks.R;

public class AboutMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_menu);
    }

    public void back (View view){
        Intent intent = new Intent(AboutMenu.this, MainActivity.class);
        startActivity(intent);
    }
}