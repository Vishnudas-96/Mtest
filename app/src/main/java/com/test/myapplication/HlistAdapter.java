package com.test.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HlistAdapter extends RecyclerView.Adapter<HlistAdapter.HViewHolder> {
    Context context;
    List<Latlong> shows;

    public HlistAdapter(Context applicationContext, List<Latlong> latlongList) {
        this.context = applicationContext;
        this.shows = latlongList;
    }


    @NonNull
    @Override
    public HViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hlist,parent,false);
        return new HViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull HlistAdapter.HViewHolder holder, int position) {
        Latlong show = shows.get(position);
        holder.textViewTitle.setText(show.getId()+","+show.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(v.getContext(), MainActivity2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("name", show.getName());
                    intent.putExtra("id", show.getId());
                    intent.putExtra("mob", show.getMobile());
                    intent.putExtra("web", show.getWebsite());
                    v.getContext().startActivity(intent);

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return shows.size();
    }

    public class HViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;

        public HViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle =itemView.findViewById(R.id.tv_hname);

        }
    }
}
