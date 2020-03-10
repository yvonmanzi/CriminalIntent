package com.example.yvonmanzi.c2riminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

    public class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private ImageView mSolvedImageView;
        private Crime mCrime;

        public CrimeHolder(View itemView) {
            super(itemView);

            mTitleTextView = itemView.findViewById(R.id.crime_title);
            mTitleTextView.setOnClickListener(this);
            mDateTextView = itemView.findViewById(R.id.crime_date);
            mSolvedImageView = itemView.findViewById(R.id.crime_solved);
        }

        public void bind(Crime crime) {
            this.mCrime = crime;
            mTitleTextView.setText(crime.getTitle());
            mDateTextView.setText(crime.getDate().toString());
            mSolvedImageView.setVisibility(crime.isSolved() ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View v) {
            //Intent intent = CrimeActivity.newIntent(new CrimeListFragment().getContext(), mCrime.getId());
            Intent intent = CrimeActivity.newIntent(v.getContext(), mCrime.getId());
            v.getContext().startActivity(intent);
        }

    }
}
