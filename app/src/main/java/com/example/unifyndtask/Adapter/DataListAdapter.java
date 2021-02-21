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
import com.example.unifyndtask.MainActivity;
import com.example.unifyndtask.R;

import java.util.List;

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.Adapter> {
    List<Data> list;
Context context;

    public DataListAdapter(Context context, List<Data> list) {
        this.context=context;
        this.list=list;

    }

    @NonNull
    @Override
    public DataListAdapter.Adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_items, parent, false);
        return new DataListAdapter.Adapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataListAdapter.Adapter holder, int position) {
        final  Data date=list.get(position);
        if(position%2==0) {
            holder.layout.setBackground(context.getResources().getDrawable(R.drawable.rounded_view));
        }else if(position==1) {
            holder.layout.setBackground(context.getResources().getDrawable(R.drawable.rounded_view1));
        }else {
            holder.layout.setBackground(context.getResources().getDrawable(R.drawable.rounded_view1));
        }
        holder.layout.setPadding(10,10,10,10);
        holder.textView1.setText(String.valueOf(date.getTitle()));
        holder.textView1.setPadding(10,10,10,10);
        holder.textView2.setPadding(10,10,10,10);
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
