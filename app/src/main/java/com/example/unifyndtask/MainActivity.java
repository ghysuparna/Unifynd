package com.example.unifyndtask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.unifyndtask.Fragment.FragmentOne;
import com.example.unifyndtask.Fragment.FragmentThree;
import com.example.unifyndtask.Fragment.FragmentTwo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    Fragment selectedFragment = null;
    private BottomNavigationView navView;
   static  Dialog dialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeAllVariables();
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contentfordata,new FragmentOne());
        transaction.commit();
    }
    private void initializeAllVariables()
    {
        navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_first:
                    callFragment(1);
                    return true;
                case R.id.navigation_second:
                    callFragment(2);
                    return  true;
                case R.id.navigation_third:
                    callFragment(3);
                    return true;
            }
            return false;
        }
    };
    public void callFragment(Integer count)
    {
        if (count==1)
        {
            selectedFragment = new FragmentOne();
        }
        if(count==2)
        {
            selectedFragment = new FragmentTwo();
        }
        if(count==3)
        {
            selectedFragment = new FragmentThree();
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contentfordata, selectedFragment);
        transaction.commit();
    }
    @Override
    public void onBackPressed() {
// super.onBackPressed();
    }
    private void changeTextColor()
    {
        if(navView.isSelected())
        {

        }else {

        }
    }
    public static void showView(Data data)
    {

        dialog.show();
        TextView title=dialog.findViewById(R.id.title);
        TextView subTitle=dialog.findViewById(R.id.subtitle);
        ImageView closeDialog= dialog.findViewById(R.id.close_dialog);
        title.setText("Title-"+data.getTitle());
        subTitle.setText("Sub title-"+data.getSubTitle());
        dialog.setCancelable(false);
        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }


}