package com.example.yvonmanzi.c2riminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class CrimeLab {
    private static CrimeLab sCrimeLab;
    List<Crime> mCrimes;

    public static CrimeLab getInstance(Context context) {
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }
    public Crime getCrime(UUID id){
        for(Crime crime : mCrimes){
            if(crime.getId().equals(id)) return crime;
        }
        return  null;
    }
    public void addCrime(Crime crime){
        mCrimes.add(crime);

    }
}
