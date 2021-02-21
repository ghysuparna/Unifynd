package com.example.unifyndtask.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unifyndtask.Adapter.NumberAdapter;
import com.example.unifyndtask.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FragmentThree extends Fragment {
    EditText number;
    View view;
    TextView secondNumber;
    RecyclerView recyclerView;
    Button enterButton;
    LinearLayout numberLayout;
    List<Integer> numberList,sortList;
    Boolean first=false;
    NumberAdapter adapter;
    public FragmentThree() {
        // Required empty public constructor
    }
    public static FragmentThree newInstance(String param1, String param2) {
        FragmentThree fragment = new FragmentThree();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        view= inflater.inflate(R.layout.fragment_three, container, false);
        initializeAllVariable();
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number.getText().toString().isEmpty()||number.getText().toString()==null)
                {
                    Toast.makeText(getContext(),"Enter number",Toast.LENGTH_SHORT).show();
                }else {
                    int num= Integer.parseInt(number.getText().toString());
                    numberLayout.setVisibility(View.VISIBLE);
                    numberList.add(num);
                    sortList.add(num);
                    if(!first){
                        adapter=new NumberAdapter(sortList);
                        recyclerView.setAdapter(adapter);
                        first=true;
                    }else {
                        adapter.notifyDataSetChanged();
                    }
                    getNumber();
                    number.getText().clear();
                }
            }
        });
        return  view;
    }
    private void getNumber()
    {
            Collections.sort(numberList,Collections.reverseOrder());
            if(numberList.size()>0){
                if(numberList.size()==1) {
                    secondNumber.setText(String.valueOf(numberList.get(0)));
                }else {
                    secondNumber.setText(String.valueOf(numberList.get(1)));
                }
            }

    }
    private void initializeAllVariable()
    {
        number= view.findViewById(R.id.numberEditText);
        secondNumber= view.findViewById(R.id.secondNumber);
        enterButton=view.findViewById(R.id.numberButton);
        recyclerView=view.findViewById(R.id.numberRV);
        numberLayout=view.findViewById(R.id.numberLayout);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        numberList=new ArrayList<>();
        sortList=new ArrayList<>();

    }
}