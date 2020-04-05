package com.example.tugasvideo7;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private ArrayList<Article> articles = new ArrayList<>();

    ArticleAdapter(ArrayList<Article> articles) {
        this.articles.clear();
        this.articles = articles;
        notifyDataSetChanged(); //method yang digunakan untuk memanggil view
                                // kembali ketika ada databaru
    }

    @NonNull
    @Override
    //menampilkan ke article list dari list article
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_article, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(articles.get(position));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
    //view holder digunakan sebagai referensi item yang akan ditampilkan ke view
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtListTitle, txtListAuthor, txtListArticle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtListTitle = itemView.findViewById(R.id.tv_list_title);
            txtListAuthor = itemView.findViewById(R.id.tv_list_author);
            txtListArticle = itemView.findViewById(R.id.tv_list_article);
            itemView.setOnClickListener(this);
        }

        public void bind (Article article){
            txtListTitle.setText(article.getTitle());
            txtListAuthor.setText(article.getAuthor());
            txtListArticle.setText(article.getArticle());
        }

        @Override
        public void onClick(View view) {
            Article article = articles.get(getAdapterPosition());

            Intent intent = new Intent(view.getContext(), ArticleDetailActivity.class);
            intent.putExtra("Id", article.getId());
            view.getContext().startActivity(intent);
        }
    }
}