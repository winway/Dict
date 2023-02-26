package com.hui.dict;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class OcrWordActivity extends AppCompatActivity {

    private static final String KEY_WORD_LIST = "word_list";

    private GridView mWordGV;

    private ArrayAdapter<String> mGridAdapter;
    private ArrayList<String> mGridAdapterData;

    public static Intent newIntent(Context context, ArrayList<String> wordList) {
        Intent intent = new Intent(context, OcrWordActivity.class);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(KEY_WORD_LIST, wordList);
        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr_word);

        Bundle bundle = getIntent().getExtras();
        mGridAdapterData = bundle.getStringArrayList(KEY_WORD_LIST);

        mWordGV = findViewById(R.id.ocr_word_gv);
        mGridAdapter = new ArrayAdapter<>(this, R.layout.gvitem_word, R.id.gvitem_word_tv, mGridAdapterData);
        mWordGV.setAdapter(mGridAdapter);

        mWordGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String word = mGridAdapterData.get(i);
                Intent intent = WordDetailActivity.newIntent(OcrWordActivity.this, word);
                startActivity(intent);
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ocr_word_back_iv:
                finish();
                break;
        }
    }
}