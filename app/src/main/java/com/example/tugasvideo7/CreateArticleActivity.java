package com.example.tugasvideo7;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateArticleActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    private EditText editTitle, editAuthor, editArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_article);

        setTitle("Create Article");

        myDb = new DatabaseHelper(this);
        editTitle = findViewById(R.id.edt_input_title);
        editAuthor = findViewById(R.id.edt_input_author);
        editArticle = findViewById(R.id.edt_input_article);

    }

    public void clickPost(View view) {
        String title = editTitle.getText().toString();
        String author = editAuthor.getText().toString();
        String article = editArticle.getText().toString();

        if (title.equals("") || author.equals("") || article.equals("")) {
            Toast.makeText(this, "Mohon isi data secara lengkap", Toast.LENGTH_SHORT).show();
        } else {
            boolean insert = myDb.insertData(editTitle.getText().toString(), editAuthor.getText().toString(), editArticle.getText().toString());
            if (insert){
                editTitle.setText("");
                editAuthor.setText("");
                editArticle.setText("");
                Toast.makeText(this, "Artikel berhasil di tambahkan", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(this, "Artikel gagal di tambahkan", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
