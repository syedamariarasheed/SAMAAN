package com.example.user.trackingapp;

import android.content.Context;
import android.content.Intent;
import android.util.EventLogTags;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {


    Context c;
    RequestDetails products;
    LayoutInflater inflater;
    ArrayList<RequestDetails> productsList;
    Adapter(Context context, ArrayList<RequestDetails> products) {
        this.c=context;
        productsList=products;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        inflater=LayoutInflater.from(c);
        View view=inflater.inflate(R.layout.row,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {


       final String Transport_=productsList.get(i).getTransport_();

        final String Location_ = productsList.get(i).getLocation_();
        final String Weight_=productsList.get(i).getWeight_();

        viewHolder.Description_.setText(productsList.get(i).getDescription_());
        viewHolder.Time_.setText(productsList.get(i).getTime_());
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(c,Main2Activity.class);
                intent.putExtra("Desc_", productsList.get(i).getDescription_());
                intent.putExtra("Time_",productsList.get(i).getTime_());
                intent.putExtra("Transport_",Transport_);
                intent.putExtra("Location_",Location_);
                intent.putExtra("Weight_",Weight_);
                c.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Description_,Time_;
       LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Description_=(TextView) itemView.findViewById(R.id.Description);
            Time_=(TextView)itemView.findViewById(R.id.TimeLimit);
           linearLayout=(LinearLayout) itemView.findViewById(R.id.DetailViewClick);

        }
    }
}