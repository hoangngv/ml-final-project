package com.example.FlowerDetector.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Base64;
import android.view.WindowManager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AppUtils {

    private static ProgressDialog progressDialog;

    public static String getFileDir(String fileName) {
        File file = new File(Environment.getExternalStorageDirectory(), "CAMERA-ML");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                DebugLog.d("Can't create file path");
            }
        }
        return file.getAbsolutePath() + "/" + fileName;
    }

    private static final String CAMERA_DIRECTORY = Environment.getExternalStorageDirectory().toString() + "/CAMERA-ML";

    public static String[] getLocalImageUri() {
        ArrayList<String> imagePaths = new ArrayList<>();
        File[] files = new File(CAMERA_DIRECTORY).listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isFile()){
                imagePaths.add("file://" + file.getAbsolutePath());
                DebugLog.d("AppUtils: " + "file://" + file.getAbsolutePath());
            }
        }
        String[] sortedPaths = imagePaths.toArray(new String[imagePaths.size()]);
        Arrays.sort(sortedPaths, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        return sortedPaths;
    }

    public static String bitmapToBase64(Bitmap bitmap) {
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String encoded = Base64.encodeToString(byteArray, Base64.NO_WRAP);
            return encoded;
        }
        return "";
    }

    public static void showCircleProgressDialog(Context mContext) {
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setCancelable(false);
        try {
            progressDialog.show();
        } catch (WindowManager.BadTokenException e) {

        }
    }

    public static void setProgressDialogMessage(String message){
        progressDialog.setMessage(message);
    }

    public static void dismissCircleProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
