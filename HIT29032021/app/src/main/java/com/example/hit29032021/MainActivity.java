package com.example.hit29032021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String url = "https://bookshopb.herokuapp.com/api/books";
    private static RecyclerView recyclerView;
    private static BookAdapter bookAdapter;
    private static List<Book> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleViewListBook);
        list = new ArrayList<>();
        bookAdapter = new BookAdapter(list, MainActivity.this);


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String listBook = response;
                try {
                    JSONArray jsonArray = new JSONArray(listBook);
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String TitleBook = jsonObject.getString("title");
                        String AuthorBook = jsonObject.getString("author");
                        String ImageLinkBook = jsonObject.getString("imageLink");
                        String DesBook = jsonObject.getString("description");
                        int PriceBook = jsonObject.getInt("price");
                        int RateStarBook = jsonObject.getInt("rateStar");
                        int NumberReview = jsonObject.getInt("numOfReview");
                        int NumberPage = jsonObject.getInt("numOfPage");
                        String Category = jsonObject.getString("categoty");
                        list.add(new Book(ImageLinkBook, TitleBook, AuthorBook, NumberReview, PriceBook, DesBook, Category, RateStarBook, NumberPage));
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(MainActivity.this, linearLayoutManager.getOrientation());
                        recyclerView.addItemDecoration(dividerItemDecoration);
                        recyclerView.setAdapter(bookAdapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "Cập nhật dữ liệu thành công", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Lỗi cập nhật dữ liệu", Toast.LENGTH_LONG).show();
            }
        });
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                JSONArray jsonArray = response;
//                for(int i = 0; i < jsonArray.length(); i++)
//                {
//                    try {
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        String TitleBook = jsonObject.getString("title");
//                        String AuthorBook = jsonObject.getString("author");
//                        String ImageLinkBook = jsonObject.getString("imageLink");
//                        String DesBook = jsonObject.getString("description");
//                        int PriceBook = jsonObject.getInt("price");
//                        int RateStarBook = jsonObject.getInt("rateStar");
//                        int NumberReview = jsonObject.getInt("numOfReview");
//                        int NumberPage = jsonObject.getInt("numOfPage");
//                        String Category = jsonObject.getString("categoty");
//                        list.add(new Book(ImageLinkBook, TitleBook, AuthorBook, NumberReview, PriceBook, DesBook, Category, RateStarBook, NumberPage));
//                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
//                        recyclerView.setLayoutManager(linearLayoutManager);
//                        recyclerView.setAdapter(bookAdapter);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//                Toast.makeText(MainActivity.this, "Cập nhật dữ liệu thành công", Toast.LENGTH_SHORT).show();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity.this, "Lỗi cập nhật dữ liệu", Toast.LENGTH_LONG).show();
//            }
//        });
        requestQueue.add(stringRequest);
        bookAdapter.setIOnClicktem(new IOnClickItem() {
            @Override
            public void iClickItem(Book book) {
                Intent intent = new Intent(MainActivity.this, InfoBook.class);
                intent.putExtra("titleBook",book.getTitleProduct());
                intent.putExtra("authorBook", book.getAuthorProduct());
                intent.putExtra("priceBook", book.getPriceProduct());
                intent.putExtra("rateNumber", book.getRateStar());
                intent.putExtra("desBook", book.getDescriptionProduct());
                intent.putExtra("numberReview", book.getNumberOfReview());
                intent.putExtra("category", book.getCategotyProduct());
                intent.putExtra("numberPage", book.getNumberOfPage());
                intent.putExtra("imgBook", book.getImageLink());
                startActivity(intent);
            }
        });
    }

}