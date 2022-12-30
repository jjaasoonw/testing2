package com.example.cardviewgamesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 1 - data
    ArrayList<GameModel> gamelist;

    // 2 - Adapter View
    RecyclerView recyclerView;


    // 3 - Adapter
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        gamelist = new ArrayList<>();
        gamelist.add(new GameModel("Horizon Chase", R.drawable.card1));
        gamelist.add(new GameModel("PUBG", R.drawable.card2));
        gamelist.add(new GameModel("Head Ball 2", R.drawable.card3));
        gamelist.add(new GameModel("Hooked On You", R.drawable.card4));
        gamelist.add(new GameModel("Fifa 2022", R.drawable.card5));
        gamelist.add(new GameModel("Fortnite", R.drawable.card6));

        adapter = new MyAdapter(this, gamelist);

        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);;
        recyclerView.setAdapter(adapter);

    }
}