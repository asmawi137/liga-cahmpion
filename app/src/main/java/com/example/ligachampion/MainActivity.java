package com.example.ligachampion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListClubAdapter adapter;
    private RecyclerView rvClub;
    private DatabaseReference reference;
    private ArrayList<Club> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvClub = findViewById(R.id.recyclerView);
        rvClub.setHasFixedSize(true);

        reference = FirebaseDatabase.getInstance().getReference().child("club");
//        list.addAll(ClubData.getLisData());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Club club = dataSnapshot.getValue(Club.class);
                    list.add(club);
                }
                adapter = new ListClubAdapter(getApplicationContext(), list);
                showRecyclerList();
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

            }
        });
    }

    private void showRecyclerList(){
        rvClub.setLayoutManager(new LinearLayoutManager(this));
        ListClubAdapter listClubAdapter = new ListClubAdapter(getApplicationContext(), list);
        rvClub.setAdapter(listClubAdapter);
        listClubAdapter.setOnItemClickCallback(this::showSelectedClub);
    }

    private void showSelectedClub(Club club) {
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_NAME, club.getName());
        intent.putExtra(DetailActivity.EXTRA_DETAIL, club.getDetail());
        intent.putExtra(DetailActivity.EXTRA_LOGO, club.getLogo());
        intent.putExtra(DetailActivity.EXTRA_LINK, club.getLink());
        startActivity(intent);
    }
}