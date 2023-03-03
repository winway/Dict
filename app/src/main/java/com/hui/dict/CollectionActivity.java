package com.hui.dict;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hui.dict.adapter.CollectPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CollectionActivity extends AppCompatActivity {

    private final String[] mTitles = {"汉字", "成语"};

    private TabLayout mTL;
    private ViewPager mVP;

    private CollectPagerAdapter mPagerAdapter;
    private List<Fragment> mPagerAdapterData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        mTL = findViewById(R.id.collection_tl);
        mVP = findViewById(R.id.collection_vp);

        initPager();
    }

    private void initPager() {
        mPagerAdapterData = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            CollectionFragment collectionFragment = CollectionFragment.newInstance(mTitles[i]);
            mPagerAdapterData.add(collectionFragment);
        }

        mPagerAdapter = new CollectPagerAdapter(getSupportFragmentManager(), mPagerAdapterData, mTitles);
        mVP.setAdapter(mPagerAdapter);
        mTL.setupWithViewPager(mVP);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.collection_back_iv:
                finish();
                break;
        }
    }
}