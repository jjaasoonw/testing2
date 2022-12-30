package com.example.cardviewgamesapp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    // 1 - Data
    private Context context;
    private ArrayList<GameModel> gameList;

    // 2 - Constructor


    public MyAdapter(Context context, ArrayList<GameModel> gameList) {
        this.context = context;
        this.gameList = gameList;
    }



    // 3 - View Holder
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView gameImage;
        private TextView gameType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gameImage = itemView.findViewById(R.id.cardViewImage);
            gameType = itemView.findViewById(R.id.textViewCard);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GameModel model = gameList.get(position);
        holder.gameType.setText(model.getGameName());
        holder.gameImage.setImageResource(model.getGameImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You have selected: " + gameList.get(position).getGameName() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

}
