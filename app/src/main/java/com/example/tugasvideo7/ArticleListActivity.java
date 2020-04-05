package com.example.tugasvideo7;

import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArticleListActivity extends AppCompatActivity {

    private RecyclerView rvListArticle;
    DatabaseHelper myDb;
    private ArrayList<Article> articles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);

        setTitle("List Article");
        rvListArticle = findViewById(R.id.rv_list_article);
        myDb = new DatabaseHelper(this);
        //menampilkan semua list artikel
        getDataArticle();

        rvListArticle.setLayoutManager(new LinearLayoutManager(this));
        rvListArticle.setAdapter(new ArticleAdapter(articles));
    }
    //metode mengambil data artikel dari database
    private void getDataArticle() {
        Cursor cursor = myDb.getAllData();

        while (cursor.moveToNext()){
            Article article = new Article();
            article.setId(cursor.getInt(0));
            article.setTitle(cursor.getString(1));
            article.setAuthor(cursor.getString(2));
            article.setArticle(cursor.getString(3));

            articles.add(article);
        }
    }
}
