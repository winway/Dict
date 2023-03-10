package com.hui.dict;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.google.gson.Gson;
import com.hui.dict.bean.OcrResultBean;
import com.hui.dict.utils.FileUtil;
import com.hui.dict.utils.RecognizeService;
import com.hui.dict.utils.RegexpUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final int REQUEST_CODE_GENERAL_BASIC = 106;

    private EditText mSearchET;
    private TextView mPinyinTV;
    private TextView mBushouTV;
    private TextView mChengyuTV;
    private TextView mTuwenTV;
    private TextView mSentenceTV;

    private boolean hasGotToken = false;
    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alertDialog = new AlertDialog.Builder(this);

        initAccessTokenWithAkSk();

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
                intent.setClass(this, SettingActivity.class);
                startActivity(intent);
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
                intent.setClass(this, ChengyuSearchActivity.class);
                startActivity(intent);
                break;
            case R.id.main_tuwen_tv:
                if (!checkTokenStatus()) {
                    return;
                }
                intent.setClass(MainActivity.this, CameraActivity.class);
                intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(getApplication()).getAbsolutePath());
                intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                        CameraActivity.CONTENT_TYPE_GENERAL);
                startActivityForResult(intent, REQUEST_CODE_GENERAL_BASIC);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // ???????????????????????????????????????
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_GENERAL_BASIC && resultCode == Activity.RESULT_OK) {
            RecognizeService.recGeneralBasic(this, FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
                    new RecognizeService.ServiceListener() {
                        @Override
                        public void onResult(String result) {
                            Log.i(TAG, "onResult: " + result);
                            OcrResultBean ocrResultBean = new Gson().fromJson(result, OcrResultBean.class);
                            List<OcrResultBean.WordsResultBean> wordResultList = ocrResultBean.getWords_result();

                            ArrayList<String> wordList = new ArrayList<>();

                            if (wordResultList != null) {
                                for (int i = 0; i < wordResultList.size(); i++) {
                                    OcrResultBean.WordsResultBean wordResultBean = wordResultList.get(i);
                                    String words = wordResultBean.getWords();
                                    words = RegexpUtils.replaceAll(words, "[^\\u4e00-\\u9fa5]");

                                    for (int j = 0; j < words.length(); j++) {
                                        String word = String.valueOf(words.charAt(j));
                                        if (!wordList.contains(word)) {
                                            wordList.add(word);
                                        }
                                    }
                                }
                            }

                            if (wordList.size() == 0) {
                                Toast.makeText(MainActivity.this, "????????????????????????", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intent = OcrWordActivity.newIntent(MainActivity.this, wordList);
                                startActivity(intent);
                            }
                        }
                    });
        }
    }

    /**
     * ?????????ak???sk?????????
     */
    private void initAccessTokenWithAkSk() {
        OCR.getInstance(this).initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken result) {
                String token = result.getAccessToken();
                hasGotToken = true;
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
                alertText("AK???SK????????????token??????", error.getMessage());
            }
        }, getApplicationContext(), "MSaY1m8CryxI44ILaMu3e76H", "iqZmCIIWOwTKCrsQP8h7ps54yOS4KSXc");
    }

    private boolean checkTokenStatus() {
        if (!hasGotToken) {
            Toast.makeText(getApplicationContext(), "token??????????????????", Toast.LENGTH_LONG).show();
        }
        return hasGotToken;
    }

    private void alertText(final String title, final String message) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                alertDialog.setTitle(title)
                        .setMessage(message)
                        .setPositiveButton("??????", null)
                        .show();
            }
        });
    }
}