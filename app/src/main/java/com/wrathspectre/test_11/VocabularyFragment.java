package com.wrathspectre.test_11;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VocabularyFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vocabulary_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppBarLayout layout = view.findViewById(R.id.appBar);
        //layout.setBackgroundColor(getArguments().getInt("color"));
        layout.setBackgroundColor(Color.parseColor("#3A526C"));

        ViewPager mViewPager = view.findViewById(R.id.viewpager);
        VocabularyViewPagerAdapter mViewPagerAdapter = new VocabularyViewPagerAdapter(getActivity().getSupportFragmentManager());
        mViewPagerAdapter.addFragment(new AddVocabularyFragment(), "All");
        mViewPagerAdapter.addFragment(new DemoFragment(), "Marked");
        mViewPager.setAdapter(mViewPagerAdapter);

        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }
}
