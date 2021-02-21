package com.example.unifyndtask.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unifyndtask.Data;
import com.example.unifyndtask.Fragment.FragmentOne;
import com.example.unifyndtask.MainActivity;
import com.example.unifyndtask.R;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.Adapter> {
    List<Data> list;
Context context;

    public DataAdapter(Context context, List<Data> list) {
        this.context=context;
        this.list=list;

    }

    @NonNull
    @Override
    public DataAdapter.Adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_items, parent, false);
        return new DataAdapter.Adapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.Adapter holder, int position) {
        final  Data date=list.get(position);
        holder.textView1.setText(String.valueOf(date.getTitle()));
        holder.textView2.setText(String.valueOf(date.getSubTitle()));
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.showView(date);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Adapter extends RecyclerView.ViewHolder {
        TextView textView1,textView2;
        LinearLayout layout;
        public Adapter(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.text1);
            textView2=itemView.findViewById(R.id.text2);
            layout=itemView.findViewById(R.id.layout);

        }
    }
}
