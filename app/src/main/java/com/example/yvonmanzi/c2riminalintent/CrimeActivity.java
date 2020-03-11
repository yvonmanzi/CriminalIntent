package com.example.yvonmanzi.c2riminalintent;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment(){

       return CrimeFragment.newInstance(crimeId);
   }


}
