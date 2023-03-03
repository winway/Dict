package com.hui.dict.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @PackageName: com.hui.dict.adapter
 * @ClassName: CollectPagerAdapter
 * @Author: winwa
 * @Date: 2023/3/3 8:34
 * @Description:
 **/
public class CollectPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> mData;
    String[] mTitles;

    public CollectPagerAdapter(@NonNull FragmentManager fm, List<Fragment> data, String[] titles) {
        super(fm);
        mData = data;
        mTitles = titles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
