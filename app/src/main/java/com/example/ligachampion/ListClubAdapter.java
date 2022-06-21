package com.example.ligachampion;


import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.behavior.SwipeDismissBehavior;

import org.w3c.dom.Text;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;


public class ListClubAdapter extends RecyclerView.Adapter<ListClubAdapter.ListViewHolder {
    private ArrayList<Club> listClub;

    public ListClubAdapter(ArrayList<Club> list) {
        this.listClub = list;
    }
    @NonNull
    @Override
    public ListClubAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_club,parent, false)
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder (@NonNull ListViewHolder holder, int position) {
        Club club = listClub.get(position);
        Glide.with(holder.itemView.getContext()) RequestManager
            .load(club.getPhoto())RequestBuilder<Drawable>
            .apply(new RequestOptions().override( width; 50, height; 50))
            .into(holder.imgPhoto);

    }

    @Override
    public int getItemCount() {
        return  listClub.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        TextView tvDetail;

        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_club);
            tvName = itemview.findViewById(R.id.tv_item_name);
            tvDetail = itemview.findViewById(R.id.tv_detail);
        }
    }
}
