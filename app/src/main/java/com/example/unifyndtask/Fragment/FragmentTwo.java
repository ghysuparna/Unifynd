package com.example.unifyndtask.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.example.unifyndtask.Adapter.DataAdapter;
import com.example.unifyndtask.Adapter.DataListAdapter;
import com.example.unifyndtask.Adapter.QuoteDataAdapter;
import com.example.unifyndtask.Data;
import com.example.unifyndtask.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FragmentTwo extends Fragment {
    RecyclerView hozRecyclerView, gridRecyclerView;
    View view;
    List<Data> list,listQuote;

    public FragmentTwo() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentTwo newInstance(String param1, String param2) {
        FragmentTwo fragment = new FragmentTwo();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_two, container, false);
        initializeAllVariables();
        getData();
        getQuoteData();
        return view;
    }

    private void initializeAllVariables() {
        hozRecyclerView = view.findViewById(R.id.hoz);
        gridRecyclerView = view.findViewById(R.id.grid);
        hozRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        hozRecyclerView.setItemAnimator(new DefaultItemAnimator());
        GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        gridRecyclerView.setLayoutManager(mLayoutManager);
        gridRecyclerView.setItemAnimator(new DefaultItemAnimator());
        list = new ArrayList<>();
        listQuote = new ArrayList<>();

    }

    private void getData() {
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
        } finally {
            DataListAdapter adapter = new DataListAdapter(getContext(), list);
            hozRecyclerView.setAdapter(adapter);
        }
    }

    public String readJSON() {
        String json = null;
        try {
            // Opening data.json file
            InputStream inputStream = getActivity().getAssets().open("dataHorizontal.json");
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
    private void getQuoteData() {
        try {
            JSONObject object = new JSONObject(readQuoteJSON());
            JSONArray array = object.getJSONArray("data");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                String title = jsonObject.getString("title");
                Data model = new Data();
                model.setTitle(title);
                model.setSubTitle("");
                listQuote.add(model);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            QuoteDataAdapter adapter = new QuoteDataAdapter(getContext(), listQuote);
            gridRecyclerView.setAdapter(adapter);
        }
    }

    public String readQuoteJSON() {
        String json = null;
        try {
            // Opening data.json file
            InputStream inputStream = getActivity().getAssets().open("dataQuote.json");
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