package com.example.yvonmanzi.c2riminalintent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        /* this manager does hold fragment list and back stack*/
        FragmentManager fm = getSupportFragmentManager();


        /*check from 'fm' which is FManager if it has a fragment identified by the container id.
         * But why would it have it? It is possible that this activity might have been destroyed(bse, for example,
         * of rotation) after the fragment was added on the list already. When this activity dies, the list is kept, so you havee
         * to check if the fragment is not already in the list before you can create a new instance of it.
         * */
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        //fragment transactions help us add, remove, attach, detach, or replace fragments
        //from a fragment list
        if(fragment == null){
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }


    protected abstract Fragment createFragment();

}
