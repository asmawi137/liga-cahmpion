package com.example.ligachampion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvClub;
    private ArrayList<Club> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvClub = findViewById(R.id.recyclerView);
        rvClub.setHasFixedSize(true);

        list.addAll(ClubData.getLisData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvClub.setLayoutManager(new LinearLayoutManager(this));
        ListClubAdapter listClubAdapter = new ListClubAdapter(list);
        rvClub.setAdapter(listClubAdapter);
        listClubAdapter.setOnItemClickCallback(this::showSelectedClub);
    }

    private void showSelectedClub(Club club) {
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_NAME, club.getName());
        intent.putExtra(DetailActivity.EXTRA_DETAIL, club.getDetail());
        intent.putExtra(DetailActivity.EXTRA_PHOTO, club.getPhoto());
        intent.putExtra(DetailActivity.EXTRA_LINK, club.getLink());
        startActivity(intent);
    }
}