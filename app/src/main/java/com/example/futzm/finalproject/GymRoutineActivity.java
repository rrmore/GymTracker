package com.example.futzm.finalproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by futzm on 11/
 */
import java.util.HashMap;

public class GymRoutineActivity extends AppCompatActivity implements ProgramFragment.OnClickProgramsRviewListener,WeeksFragment.OnButtonClickListener,ExercisesFragment.OnClickExerciseRviewListener{
    Fragment mcontent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gym_routines_activity);
        Log.d("onCreate", "Inside task2 set content view");
        setTitle("");
        if (savedInstanceState == null)
        {
            mcontent = ProgramFragment.newInstance(R.id.recycler_view_fragment);
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.program_activity_container,
                mcontent).addToBackStack(null).commit();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return true;
    }

    public void onRecycleViewItemClicked (View v , HashMap<String,?> programs)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.program_activity_container, WeeksFragment.newInstance((Integer)programs.get("programId")));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onButtonClick(View view, int programId, String day) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.program_activity_container, ExercisesFragment.newInstance(programId,day));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
//@Override
    public void onExerciseItemClicked(View v, Exercise exercise) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.program_activity_container, ExerciseDetailsFragment.newInstance(exercise));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //@Override
    public void onClicked(View v, int position) {

    }
}
