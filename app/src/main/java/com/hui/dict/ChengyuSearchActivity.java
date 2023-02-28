package com.hui.dict;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.hui.dict.db.DBManager;

import java.util.ArrayList;
import java.util.List;

public class ChengyuSearchActivity extends AppCompatActivity {
    private static final String TAG = "ChengyuSearchActivity";

    private EditText mSearchET;
    private GridView mHistoryGV;

    private ArrayAdapter<String> mGridAdapter;
    private ArrayList<String> mGridAdapterData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chengyu_search);

        mSearchET = findViewById(R.id.chengyu_search_et);
        mHistoryGV = findViewById(R.id.chengyu_search_history_gv);

        initGridAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSearchET.setText("");
        refreshGridAdapter();
    }

    private void refreshGridAdapter() {
        List<String> chengyuList = DBManager.queryChengyuList();
        mGridAdapterData.clear();
        mGridAdapterData.addAll(chengyuList);
        mGridAdapter.notifyDataSetChanged();
    }

    private void initGridAdapter() {
        mGridAdapterData = new ArrayList<>();
        mGridAdapter = new ArrayAdapter<>(this, R.layout.gvitem_chengyu, R.id.gvitem_chengyu_tv, mGridAdapterData);
        mHistoryGV.setAdapter(mGridAdapter);

        mHistoryGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String chengyu = mGridAdapterData.get(i);
                Intent intent = ChengyuDetailActivity.newIntent(ChengyuSearchActivity.this, chengyu);
                startActivity(intent);
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chengyu_search_back_iv:
                finish();
                break;
            case R.id.chengyu_search_iv:
                String chengyu = mSearchET.getText().toString();
                if (TextUtils.isEmpty(chengyu)) {
                    return;
                }
                Intent intent = ChengyuDetailActivity.newIntent(ChengyuSearchActivity.this, chengyu);
                startActivity(intent);
                break;
        }
    }
}