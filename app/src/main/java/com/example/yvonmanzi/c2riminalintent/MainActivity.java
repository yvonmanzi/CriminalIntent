package com.example.yvonmanzi.c2riminalintent;


import android.support.v4.app.Fragment;

public class MainActivity extends SingleFragmentActivity {

   @Override
    protected Fragment createFragment(){
       return new CrimeFragment();
   }
}
