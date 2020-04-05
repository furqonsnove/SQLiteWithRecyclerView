package com.example.tugasvideo7;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArticleDetailActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    private TextView txtDetailTitle, txtDetailAuthor, txtDetailArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        setTitle("Detail Article");

        myDb = new DatabaseHelper(this);
        txtDetailTitle = findViewById(R.id.tv_detail_title);
        txtDetailAuthor = findViewById(R.id.tv_detail_author);
        txtDetailArticle = findViewById(R.id.tv_detail_article);

        int id = getIntent().getIntExtra("Id", 0);
        Cursor cursor = myDb.getDataById(id);

        cursor.moveToNext();
        txtDetailTitle.setText(cursor.getString(1));
        txtDetailAuthor.setText(cursor.getString(2));
        txtDetailArticle.setText(cursor.getString(3));
    }
}
