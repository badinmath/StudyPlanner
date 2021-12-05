package com.example.navwihatbbed;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class fragment1 extends Fragment {

    RecyclerView recyclerView;
    RecyclerView_Adapter recyclerView_adapter;
    mySQLiteDBHandler dbHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        recyclerView = view.findViewById(R.id.recyclerview_study_plan);

        dbHandler = new mySQLiteDBHandler(getContext());
//        delete_button = fin

        List<EventModel> everyone = dbHandler.getType(getResources().getStringArray(R.array.types)[0]);

        recyclerView_adapter = new RecyclerView_Adapter(getContext(),everyone);
        recyclerView.setAdapter(recyclerView_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}