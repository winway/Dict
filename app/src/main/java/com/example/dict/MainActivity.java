package com.example.dict;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText mSearchET;
    private TextView mPinyinTV;
    private TextView mBushouTV;
    private TextView mChengyuTV;
    private TextView mTuwenTV;
    private TextView mSentenceTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mSearchET = findViewById(R.id.main_search_et);
        mPinyinTV = findViewById(R.id.main_pinyin_tv);
        mBushouTV = findViewById(R.id.main_bushou_tv);
        mChengyuTV = findViewById(R.id.main_chengyu_tv);
        mTuwenTV = findViewById(R.id.main_tuwen_tv);
        mSentenceTV = findViewById(R.id.main_sentence_tv);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.main_setting_iv:
                break;
            case R.id.main_search_iv:
                String word = mSearchET.getText().toString();
                if (!TextUtils.isEmpty(word)) {
                    intent = WordDetailActivity.newIntent(this, word);
                    startActivity(intent);
                }
                break;
            case R.id.main_pinyin_tv:
                intent.setClass(this, PinyinSearchActivity.class);
                startActivity(intent);
                break;
            case R.id.main_bushou_tv:
                intent.setClass(this, BushouSearchActivity.class);
                startActivity(intent);
                break;
            case R.id.main_chengyu_tv:
                break;
            case R.id.main_tuwen_tv:
                break;
        }
    }
}