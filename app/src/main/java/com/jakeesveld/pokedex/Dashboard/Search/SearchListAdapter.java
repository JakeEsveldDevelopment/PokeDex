package com.jakeesveld.pokedex.Dashboard.Search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jakeesveld.pokedex.R;
import com.jakeesveld.pokedex.models.Pokemon;

import java.util.List;

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {
    List<Pokemon> dataList;

    public SearchListAdapter(List<Pokemon> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pokemon data = dataList.get(position);
        holder.textName.setText(data.getName());
        holder.textId.setText(data.getId());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageSprite;
        TextView textName, textId;
        ViewGroup layoutTypes, parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageSprite = itemView.findViewById(R.id.image_sprite);
            textName = itemView.findViewById(R.id.text_name);
            textId = itemView.findViewById(R.id.text_id);
            layoutTypes = itemView.findViewById(R.id.layout_types);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
