package com.example.prasannakumara.sample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by PrasannakumarA on 4/7/2017.
 */

public class RecyclerviewMain extends AppCompatActivity {
    RecyclerView recyclerlist;
    ArrayList<langModelClass> langarrays;
    Fragment recyclerFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerviewmain);

        //code for recyclerview
//        recyclerlist = (RecyclerView) findViewById(R.id.recycler_list);
//        langarrays = new ArrayList<>();
//
//        langarrays.add(new langModelClass("onestring"));
//
//        for (int i = 0; i < 12; i++) {
//            langarrays.add(new langModelClass(String.valueOf(i)));
//
//        }
//
//        recyclerlist = (RecyclerView) findViewById(R.id.recycler_list);
//        RecyclerAdapter adapter=new RecyclerAdapter(this,langarrays);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerlist.setLayoutManager(mLayoutManager);
//        recyclerlist.setAdapter(adapter);
//        adapter.notifyDataSetChanged();


        FragmentManager fm =getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.recycler_fragment, new FragmentforRecyclerView());
        ft.commit();





    }

}
