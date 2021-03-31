package com.example.hit29032021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class InfoBook extends AppCompatActivity {
    TextView tvTitle, tvAuthor, tvPrice, tvNumberPage, tvDes, tvNumberReview, tvCategory, tvNumberRate;
    ImageView imgBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_book);
        AnhXa();
        Intent intent = getIntent();
        tvTitle.setText(intent.getStringExtra("titleBook"));
        tvAuthor.setText("Tác giả: " + intent.getStringExtra("authorBook"));
        tvCategory.setText(intent.getStringExtra("category"));
        tvDes.setText(intent.getStringExtra("desBook"));
        tvNumberRate.setText(String.valueOf(intent.getIntExtra("rateNumber", 0)/10));
        tvPrice.setText(intent.getIntExtra("priceBook", 0) + "  ₫");
        tvNumberReview.setText(intent.getIntExtra("numberReview", 0)+ " lượt đánh giá");
        tvNumberPage.setText(String.valueOf(intent.getIntExtra("numberPage", 0)));
        Glide.with(InfoBook.this).load(intent.getStringExtra("imgBook")).into(imgBook);
    }
    private void AnhXa()
    {
        tvTitle = findViewById(R.id.titleProduct);
        tvAuthor = findViewById(R.id.authorProduct);
        tvCategory = findViewById(R.id.categoryProduct);
        tvDes = findViewById(R.id.descriptionProduct);
        tvNumberRate = findViewById(R.id.ratingProduct);
        tvNumberReview = findViewById(R.id.numberReview);
        tvPrice =  findViewById(R.id.priceProduct);
        tvNumberPage = findViewById(R.id.numberPage);
        imgBook = findViewById(R.id.imageProduct);
    }
}