package com.example.prasannakumara.sample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by PrasannakumarA on 4/7/2017.
 */

public class FragmentforRecyclerView extends Fragment {
    RecyclerView mRecyclerView;
    ArrayList<langModelClass> langarrays;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laout, null);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_fragment);
        langarrays = new ArrayList<>();

        langarrays.add(new langModelClass("onestring"));

        for (int i = 0; i < 12; i++) {
            langarrays.add(new langModelClass(String.valueOf(i)));

        }

//        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_list);
        RecyclerAdapter adapter=new RecyclerAdapter(getActivity(),langarrays);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }
}
