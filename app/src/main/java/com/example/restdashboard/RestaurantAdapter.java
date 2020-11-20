package com.example.restdashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Restaurant> sourceArrayList;
    private OnItemClickListener onItemClickListener;
    private Context context;



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newsitems,parent,false);
        return new RestaurantAdapter.ItemViewHolder(view,  onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        Restaurant currentItem = sourceArrayList.get(position);


        itemViewHolder.textView2.setText( currentItem.getRest_name());
        itemViewHolder.textView3.setText( currentItem.getRest_tag());

    }

    @Override
    public int getItemCount() {
        return sourceArrayList.size();
    }

    public interface OnItemClickListener{
        void onItemClick(int position, View view);
    }

    public RestaurantAdapter(ArrayList<Restaurant> sourceArrayList, Context context){
        this.context = context;
        this.sourceArrayList = sourceArrayList;
    }

    public void  setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener = listener;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        public Button button2,button;
        public TextView textView3,textView2;


        public ItemViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
            textView2 = itemView.findViewById(R.id.textView2);
            button2 = itemView.findViewById(R.id.button2);
            textView3 = itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            listener.onItemClick(pos,v);
                        }
                    }
                }
            });
        }
    }



}
