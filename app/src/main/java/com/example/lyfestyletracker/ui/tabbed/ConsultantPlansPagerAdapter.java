package com.example.lyfestyletracker.ui.tabbed;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.lyfestyletracker.ExerciseWorkoutPlans;
import com.example.lyfestyletracker.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class ConsultantPlansPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.food_tab_text_2, R.string.exercise_tab_text_2};
    private final Context mContext;
    private String username;

    public ConsultantPlansPagerAdapter(Context context, FragmentManager fm, String username) {
        super(fm);
        mContext = context;
        this.username = username;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = ExerciseWorkoutPlans.newInstance(username, "diet", "consultant");
                break;
            case 1:
                fragment = ExerciseWorkoutPlans.newInstance(username, "workout", "consultant");
                break;
            default:
                fragment = null;
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}