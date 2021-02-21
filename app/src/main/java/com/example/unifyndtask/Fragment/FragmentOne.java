package com.example.unifyndtask.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.unifyndtask.Adapter.DataAdapter;
import com.example.unifyndtask.Data;
import com.example.unifyndtask.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class FragmentOne extends Fragment {

    RecyclerView hiphopRecyclerView,popRecyclerView,rbRecyclerView;
    View view;
    List<Data> list;
    public FragmentOne() {
        // Required empty public constructor
    }
    public static FragmentOne newInstance(String param1, String param2) {
        FragmentOne fragment = new FragmentOne();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_one, container, false);
        initializeAllVariables();
        getData();
        return  view;
    }
    private void initializeAllVariables()
    {
        hiphopRecyclerView=view.findViewById(R.id.hiphopRV);
        popRecyclerView=view.findViewById(R.id.popRV);
        rbRecyclerView=view.findViewById(R.id.rbRV);
        hiphopRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        hiphopRecyclerView.setItemAnimator(new DefaultItemAnimator());
        popRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        popRecyclerView.setItemAnimator(new DefaultItemAnimator());
        rbRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rbRecyclerView.setItemAnimator(new DefaultItemAnimator());
        list=new ArrayList<>();
    }
    private void  getData()
    {
        try {
            JSONObject object = new JSONObject(readJSON());
            JSONArray array = object.getJSONArray("data");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                String title = jsonObject.getString("title");
                String subTitle = jsonObject.getString("subTitle");
                Data model = new Data();
                model.setTitle(title);
                model.setSubTitle(subTitle);
                list.add(model);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        finally {
            DataAdapter adapter = new DataAdapter(getContext(), list);
            hiphopRecyclerView.setAdapter(adapter);
            popRecyclerView.setAdapter(adapter);
            rbRecyclerView.setAdapter(adapter);
        }
    }
    public String readJSON() {
        String json = null;
        try {
            // Opening data.json file
            InputStream inputStream = getActivity().getAssets().open("data.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return json;
        }
        return json;
    }
}