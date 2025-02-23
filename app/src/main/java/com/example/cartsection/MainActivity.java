package com.example.cartsection;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample cart items
        List<Product> cartItems = new ArrayList<>();
        cartItems.add(new Product("185-60-15 ÄMÄHÖKÖY", 1));
        cartItems.add(new Product("700-15 EKALTSEW", 1));

        // Set RecyclerView Adapter
        CartAdapter adapter = new CartAdapter(cartItems);
        recyclerView.setAdapter(adapter);
    }
}