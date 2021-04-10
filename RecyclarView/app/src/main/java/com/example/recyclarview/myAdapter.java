package com.example.recyclarview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {
    private Context context;
    private List<ListItem> listItems;

    public myAdapter(MainActivity mainActivity, List<ListItem> listItems) {

        this.context = context;
        this.listItems = listItems;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recyclar_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem item = listItems.get(position);
        holder.heading.setText(item.getHeading());
        holder.description.setText(item.getDescription());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView heading;
        public TextView description;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            heading = (TextView) itemView.findViewById(R.id.Heading);
            description = (TextView) itemView.findViewById(R.id.description);
        }
    }
}
