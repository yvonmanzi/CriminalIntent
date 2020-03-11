package com.example.yvonmanzi.c2riminalintent;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;

    @Nullable
    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);

        //get a handle to rv
        mCrimeRecyclerView = view.findViewById(R.id.crime_recycler_view);
        updateUI();


        return view;
    }

    private void updateUI() {

        //set an adapter to the rv
        CrimeLab crimeLab = CrimeLab.getInstance(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        //mCrimeRecyclerView.setAdapter(adapter);
        //first check if the adapter aint already set.
        if(mAdapter == null){
            mAdapter = new CrimeAdapter(getActivity(), crimes);
            mCrimeRecyclerView.setAdapter(mAdapter);
        }
        else mAdapter.notifyDataSetChanged();

        //set default LManager
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }
}


