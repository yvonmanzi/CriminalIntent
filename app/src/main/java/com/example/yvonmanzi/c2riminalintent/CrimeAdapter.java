package com.example.yvonmanzi.c2riminalintent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class CrimeAdapter extends RecyclerView.Adapter<CrimeAdapter.CrimeHolder> {
    private List<Crime> mCrimes;
    LayoutInflater mInflater;

    public CrimeAdapter(Context context, List<Crime> crimes) {
        this.mCrimes = crimes;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_crime, parent, false);
        return new CrimeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
        Crime crime = mCrimes.get(position);
        holder.bind(crime);

    }

    @Override
    public int getItemCount() {
        return mCrimes.size();
    }

    public class CrimeHolder extends RecyclerView.ViewHolder {
        public TextView mTitleTextView;
        public TextView mDateTextView;

        public CrimeHolder(View itemView) {
            super(itemView);

            mTitleTextView = itemView.findViewById(R.id.crime_title);
            mDateTextView = itemView.findViewById(R.id.crime_date);
        }

        public void bind(Crime crime) {
            mTitleTextView.setText(crime.getTitle());
            mDateTextView.setText(crime.getDate().toString());
        }
    }
}
