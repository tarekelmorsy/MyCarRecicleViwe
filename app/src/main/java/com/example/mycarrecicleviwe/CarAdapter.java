package com.example.mycarrecicleviwe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder>
{
    private ArrayList<Car> cars;
    private Itemvlecd activity;

    public interface Itemvlecd{


         void onClicked(int index);
    }



    public CarAdapter(ArrayList<Car> list, Context context){

        cars= list;
        activity =(Itemvlecd) context;

    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivMake;
        TextView tvModel, tvOwner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMake = itemView.findViewById(R.id.ivmake);
            tvModel = itemView.findViewById(R.id.tvmodel);
            tvOwner = itemView.findViewById(R.id.tvowner);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.onClicked(cars.indexOf((Car) v.getTag()));
                }
            });
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new ViewHolder( view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.itemView.setTag(cars.get(position));
        holder.tvOwner.setText(cars.get(position).getOwnerName());
        holder.tvModel.setText(cars.get(position).getModel());
        if (cars.get(position).getMake().equals("Volkswagen")){

            holder.ivMake.setImageResource(R.drawable.volkswagen);
        }
        else if (cars.get(position).getMake().equals("Nissan")){

            holder.ivMake.setImageResource(R.drawable.nissan);
        }
        else {

            holder.ivMake.setImageResource(R.drawable.mercedes);
        }
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
