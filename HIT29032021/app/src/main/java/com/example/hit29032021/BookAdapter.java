package com.example.hit29032021;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>{
    List<Book> list;
    Context context;

    public BookAdapter(List<Book> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvDesProduct.setText(list.get(position).getDescriptionProduct());
        holder.tvPriceProduct.setText(list.get(position).getPriceProduct()+" ₫");
        holder.tvRateStarProduct.setText(list.get(position).getRateStar()+"");
        holder.tvTitleProduct.setText(list.get(position).getTitleProduct());
        holder.tvAuthorProduct.setText(list.get(position).getAuthorProduct());
        holder.tvNumberReview.setText(list.get(position).getNumberOfReview()+" + lượt đánh giá");
        holder.tvCategory.setText(list.get(position).getCategotyProduct());
        holder.tvNumberPage.setText(list.get(position).getNumberOfPage()+ " trang");
        Glide.with(context).load(list.get(position).getImageLink()).into(holder.imgTitleProduct);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTitleProduct;
        TextView tvTitleProduct, tvAuthorProduct, tvRateStarProduct, tvPriceProduct, tvDesProduct, tvNumberPage, tvNumberReview, tvCategory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTitleProduct = itemView.findViewById(R.id.imageProduct);
            tvAuthorProduct = itemView.findViewById(R.id.authorProduct);
            tvTitleProduct = itemView.findViewById(R.id.titleProduct);
            tvRateStarProduct = itemView.findViewById(R.id.ratingProduct);
            tvPriceProduct = itemView.findViewById(R.id.priceProduct);
            tvDesProduct = itemView.findViewById(R.id.descriptionProduct);
            tvNumberPage = itemView.findViewById(R.id.numberPage);
            tvNumberReview = itemView.findViewById(R.id.numberReview);
            tvCategory = itemView.findViewById(R.id.category);
        }
    }

}
