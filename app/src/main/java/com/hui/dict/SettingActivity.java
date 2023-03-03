package com.hui.dict;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_back_iv:
                finish();
                break;
            case R.id.setting_collect_tv:
                Intent intent = new Intent(this, CollectionActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_feedback_tv:
                break;
            case R.id.setting_evalute_tv:
                break;
            case R.id.setting_share_tv:
                shareApp();
                break;
            case R.id.setting_about_tv:
                break;
        }
    }

    private void shareApp() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "快来下载中华字典APP吧！");
        startActivity(Intent.createChooser(intent, "分享到……"));
    }
}