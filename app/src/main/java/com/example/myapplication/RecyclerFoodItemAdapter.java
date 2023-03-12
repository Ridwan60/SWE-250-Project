package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerFoodItemAdapter extends RecyclerView.Adapter<RecyclerFoodItemAdapter.myViewHolder> {



    ArrayList<FoodDetailModel> dataHolder;
    Home_Fragment context;



    public RecyclerFoodItemAdapter(Home_Fragment home_fragment, ArrayList<FoodDetailModel> dataHolder) {
        context = home_fragment;
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_details_card,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.img.setImageResource(dataHolder.get(position).getImg());
        holder.foodName.setText(String.valueOf(dataHolder.get(position).getFoodName()));
        holder.foodPrice.setText(String.valueOf(dataHolder.get(position).getFoodPrice()));

    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView foodName, foodPrice;
        public myViewHolder(View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.imgFood);
            foodName = itemView.findViewById(R.id.txtFoodName);
            foodPrice = itemView.findViewById(R.id.txtPrice);
        }
    }
}
