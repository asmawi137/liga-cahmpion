package com.example.ligachampion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class ListClubAdapter extends RecyclerView.Adapter<ListClubAdapter.ListViewHolder> {
    private Context context;
    private ArrayList<Club> listClub;

    public ListClubAdapter(Context context, ArrayList<Club> list) {
        this.context = context;
        this.listClub = list;
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListClubAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_club,parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder (@NonNull ListViewHolder holder, int position) {
        Club club = listClub.get(position);
        Glide.with(holder.itemView.getContext())
            .load(club.getLogo())
            .apply(new RequestOptions().override(  50,  50))
            .into(holder.imgPhoto);

        holder.tvName.setText(club.getName());
        holder.tvDetail.setText(club.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listClub.get(holder.getAdapterPosition()));
            }
        });

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
