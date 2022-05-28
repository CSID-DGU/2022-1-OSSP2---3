package com.example.zipgaja;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zipgaja.module.api.LessMoneyResponseData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// 리스트뷰에 붙일 어뎁터 , UI 정의
class RecyclerviewItemAdapter extends RecyclerView.Adapter<RecyclerviewItemAdapter.MyViewHolder> {

    private ArrayList<LessMoneyResponseData> list = null;
    RecyclerviewItemAdapter(ArrayList<LessMoneyResponseData> list) {
        list =  new ArrayList<>();
        this.list = list;
    }

    public void setList(ArrayList<LessMoneyResponseData> list) {
        if(list !=null){
            list.remove(0);
            this.list = list;
        }
    }

    @Override
    public RecyclerviewItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_detail, parent, false);
        return new MyViewHolder(view);
    }

    // UI에 리스트데이터 포지션 별로 데이터 초기화 하는부분
    @Override
    public void onBindViewHolder(RecyclerviewItemAdapter.MyViewHolder holder, final int position) {
        holder.num.setText(list.get(position).getTimev()+"분 / "+list.get(position).getCost() + "원");
        holder.name.setText(list.get(position).getName());
        switch (list.get(position).getType()){
            case "walk":
                holder.icon.setImageResource(R.drawable.ic_walk);
                break;
            case "bike":
                holder.icon.setImageResource(R.drawable.ic_bike);
                break;
            case "taxi":
                holder.icon.setImageResource(R.drawable.ic_taxi);
                break;
            case "bus":
                holder.icon.setImageResource(R.drawable.ic_bus);
                break;
        }
        if(position == list.size()-1){
            holder.arrow.setVisibility(View.GONE);
        }

        if(position == 0){
            holder.move.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    // UI 정의하는 Holder
    public class MyViewHolder  extends RecyclerView.ViewHolder {
        TextView name;
        TextView num;
        ImageView icon;
        ImageView arrow;
        ImageView move;
        public MyViewHolder (@NonNull View itemView) {
            super(itemView);
            num = itemView.findViewById(R.id.list_detail_cost);
            name = itemView.findViewById(R.id.list_detail_name);
            icon = itemView.findViewById(R.id.list_detail_icon_image);
            arrow = itemView.findViewById(R.id.list_detail_icon_arrow);
            move = itemView.findViewById(R.id.list_detail_icon_move);
        }
    }

}
