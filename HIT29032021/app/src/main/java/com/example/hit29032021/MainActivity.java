package com.example.hit29032021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    String url = "https://bookshopb.herokuapp.com/api/books";
    RecyclerView recyclerView;
    BookAdapter bookAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                AnhXa(response);
                Toast.makeText(MainActivity.this, "Cập nhật dữ liệu thành công", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Lỗi cập nhật dữ liệu", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);

    }
    private void AnhXa(JSONArray jsonArray)
    {
        recyclerView = findViewById(R.id.recycleViewListBook);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<Book> list = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++)
        {
            try {
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

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        bookAdapter = new BookAdapter(list, MainActivity.this);
        recyclerView.setAdapter(bookAdapter);
    }
}