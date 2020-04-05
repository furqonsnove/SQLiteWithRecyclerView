package com.example.tugasvideo7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void toList(View view) {
        Intent i = new Intent(this,ArticleListActivity.class);
        startActivity(i);
    }

    public void toCreate(View view) {
        Intent i = new Intent(this,CreateArticleActivity.class);
        startActivity(i);
    }


}
