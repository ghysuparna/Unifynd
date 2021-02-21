package com.example.unifyndtask.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unifyndtask.Data;
import com.example.unifyndtask.R;

import java.util.List;

public class QuoteDataAdapter extends RecyclerView.Adapter<QuoteDataAdapter.Adapter> {
    List<Data> list;
    Context context;

    public QuoteDataAdapter(Context context, List<Data> list) {
        this.context=context;
        this.list=list;

    }

    @NonNull
    @Override
    public QuoteDataAdapter.Adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_quote, parent, false);
        return new QuoteDataAdapter.Adapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteDataAdapter.Adapter holder, int position) {
        final  Data date=list.get(position);
        holder.textView1.setText(String.valueOf(date.getTitle()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Adapter extends RecyclerView.ViewHolder {
        TextView textView1;
        public Adapter(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.text1);
        }
    }
}
