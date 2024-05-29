package com.example.recyclerviewtp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View

            textView = (TextView) v.findViewById(R.id.textview);
        }

        public TextView getTextView() {
            return textView;
        }

    }

    public MyAdapter(List<String> localDataSet) {
        this.localDataSet = localDataSet;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.getTextView().setText(localDataSet.get(position));
        // add a click listener to the item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add Clicked to the text of the item
                // Get the current text of the item
                String currentText = holder.getTextView().getText().toString();
                // Add Clicked to the text of the item
                holder.getTextView().setText( "Clicked " + currentText);
                // Change the data in the dataset
                localDataSet.set(holder.getAdapterPosition() , "Clicked " + currentText);
            }
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
