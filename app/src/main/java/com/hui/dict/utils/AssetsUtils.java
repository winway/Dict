package com.hui.dict.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @PackageName: com.hui.dict.utils
 * @ClassName: AssetsUtils
 * @Author: winwa
 * @Date: 2023/2/19 8:11
 * @Description:
 **/
public class AssetsUtils {

    public static String readAssetFile(Context context, String filename) {
        AssetManager am = context.getResources().getAssets();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            InputStream inputStream = am.open(filename);

            int len = 0;
            byte[] buf = new byte[1024];
            while (true) {
                len = inputStream.read(buf);
                if (len == -1) {
                    break;
                } else {
                    outputStream.write(buf, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return outputStream.toString();
    }
}
