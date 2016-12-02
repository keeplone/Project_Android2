package com.example.keeplone.project_android2;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogaclejapan.smarttablayout.SmartTabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {

    private SmartTabLayout tabLayout;
    private ViewPager viewPager;


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup foodView = (ViewGroup) inflater.inflate(R.layout.fragment_food,
                container, false);
        tabLayout = (SmartTabLayout) foodView.findViewById(R.id.tab);
        viewPager = (ViewPager) foodView.findViewById(R.id.pager);

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return new CleanFoodFragment();
                    case 1:
                        return new DessertFragment();
                    default:
                        return null;

                }
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                String title = null; if (position == 0) {
                    title = "CleanFood";
                } else if (position == 1) {
                    title = "Dessert"; }

                return title;

            }
        };

        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager);

        getActivity().setTitle("Food");

        // Inflate the layout for this fragment
        return foodView;
    }

}
