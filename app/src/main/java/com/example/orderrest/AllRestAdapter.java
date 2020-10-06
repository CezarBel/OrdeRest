package com.example.orderrest;

import android.content.Context;
import android.content.Intent;
import android.util.AtomicFile;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AllRestAdapter extends RecyclerView.Adapter<AllRestAdapter.ViewHolder> implements Filterable {

    private static final String TAG = "AllRestAdapter";

    private ArrayList<String> mRestNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    List<String> rest;
    private Context mContext;

    public AllRestAdapter(ArrayList<String> mRestNames, ArrayList<String> mImages, Context mContext) {
        this.mRestNames = mRestNames;
        this.mImages = mImages;
        this.mContext = mContext;
        this.rest = new ArrayList<>(mRestNames);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_all_rest,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(mContext).asBitmap().load(mImages.get(position)).into(holder.image);

        holder.restName.setText(mRestNames.get(position));
        holder.restLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0 :
                        Intent intent0 = new Intent(mContext, BenedictActivity.class);
                        intent0.putExtra("image_url",mImages.get(position));
                        intent0.putExtra("restaurants_names",mRestNames.get(position));
                        mContext.startActivity(intent0);
                        break;
                    case 1:  Intent intent1 = new Intent(mContext, HamburgActivity.class);
                        intent1.putExtra("image_url",mImages.get(position));
                        intent1.putExtra("restaurants_names",mRestNames.get(position));
                        mContext.startActivity(intent1);
                        break;
                    case 2: Intent intent2 = new Intent(mContext, SunsetActivity.class);
                        intent2.putExtra("image_url",mImages.get(position));
                        intent2.putExtra("restaurants_names",mRestNames.get(position));
                        mContext.startActivity(intent2);
                        break;
                    case 3: Intent intent3 = new Intent(mContext, Hanasi1Activity.class);
                        intent3.putExtra("image_url",mImages.get(position));
                        intent3.putExtra("restaurants_names",mRestNames.get(position));
                        mContext.startActivity(intent3);
                        break;
                    case 4: Intent intent4 = new Intent(mContext, ArchieActivity.class);
                        intent4.putExtra("image_url",mImages.get(position));
                        intent4.putExtra("restaurants_names",mRestNames.get(position));
                        mContext.startActivity(intent4);
                        break;
                    case 5: Intent intent5 = new Intent(mContext, AromaActivity.class);
                        intent5.putExtra("image_url",mImages.get(position));
                        intent5.putExtra("restaurants_names",mRestNames.get(position));
                        mContext.startActivity(intent5);
                        break;
                    case 6:Intent intent6 = new Intent(mContext, LandwerActivity.class);
                        intent6.putExtra("image_url",mImages.get(position));
                        intent6.putExtra("restaurants_names",mRestNames.get(position));
                        mContext.startActivity(intent6);
                        break;
                    case 7:Intent intent7 = new Intent(mContext, CafecafeActivity.class);
                        intent7.putExtra("image_url",mImages.get(position));
                        intent7.putExtra("restaurants_names",mRestNames.get(position));
                        mContext.startActivity(intent7);
                        break;
                    case 8:Intent intent8 = new Intent(mContext, JapanicaActivity.class);
                        intent8.putExtra("image_url",mImages.get(position));
                        intent8.putExtra("restaurants_names",mRestNames.get(position));
                        mContext.startActivity(intent8);
                        break;
                    case 9:Intent intent9 = new Intent(mContext, PizzahutActivity.class);
                        intent9.putExtra("image_url",mImages.get(position));
                        intent9.putExtra("restaurants_names",mRestNames.get(position));
                        mContext.startActivity(intent9);
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mRestNames.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<String> filteredRest = new ArrayList<>();
            if(charSequence.toString().isEmpty()){
                filteredRest.addAll(rest);
            }else {
                for(String restaurants : rest){
                    if(restaurants.toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filteredRest.add(restaurants);
                    }
                }
            }
        FilterResults filterResults = new FilterResults();
            filterResults.values = filteredRest;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        mRestNames.clear();
        mRestNames.addAll((Collection<? extends String>) filterResults.values);
        notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView restName;
        RelativeLayout restLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            restName = itemView.findViewById(R.id.rest_name);
            restLayout = itemView.findViewById(R.id.recycler_all_rest);

        }
    }
}
