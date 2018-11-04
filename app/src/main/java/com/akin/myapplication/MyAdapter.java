package com.akin.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Gridholder> {
    Bitmap[] bitmaps;
    Fragment fragment1;

    public MyAdapter(Fragment context, Bitmap[] bitmaps) {
        this.bitmaps = bitmaps;
        this.fragment1=context;
    }

    @Override
    public Gridholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridview, parent, false);
        return new Gridholder(view);
    }

    @Override
    public void onBindViewHolder(Gridholder holder, int position) {
        holder.imgview.setImageBitmap(bitmaps[position]);

    }

    @Override
    public int getItemCount() {
        return bitmaps.length;
    }

    public class Gridholder extends RecyclerView.ViewHolder {

        ImageView imgview;

        public Gridholder(View itemView) {
            super(itemView);
            imgview = itemView.findViewById(R.id.imgview);

            imgview.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        //Bitmap clickedDataItem = bitmaps[pos];
                        Intent intent = new Intent(fragment1.getActivity(), SelfMade.class);
                        intent.putExtra("quotes","" );
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        fragment1.startActivity(intent);
                        Toast.makeText(v.getContext(), "Your clicked quote ", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}

