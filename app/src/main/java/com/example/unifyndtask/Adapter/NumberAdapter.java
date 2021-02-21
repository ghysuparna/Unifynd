package com.example.unifyndtask.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unifyndtask.R;

import java.util.List;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.Adapter> {
    List<Integer> number;

    public NumberAdapter(List<Integer> numberList) {
        this.number=numberList;
    }

    @NonNull
    @Override
    public NumberAdapter.Adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_numbers, parent, false);
        return new NumberAdapter.Adapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberAdapter.Adapter holder, int position) {
        holder.textView2.setText(String.valueOf(number.get(position)));
    }

    @Override
    public int getItemCount() {
        return number.size();
    }

    public class Adapter extends RecyclerView.ViewHolder {
        TextView textView2;
        public Adapter(@NonNull View itemView) {
            super(itemView);
            textView2=itemView.findViewById(R.id.text2);

        }
    }
}
