package com.example.FlowerDetector.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.FlowerDetector.SplashActivity;

import java.util.ArrayList;
import java.util.List;

public class PermissionHelper {
    public static boolean requestRuntimePermission(Context context){
        boolean isNeededRequestRuntime = false;
        List<String> permissions = new ArrayList<>();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context,
                    Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
            if (ContextCompat.checkSelfPermission(context,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
            if (ContextCompat.checkSelfPermission(context,
                    Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.CAMERA);
            }

            if (ContextCompat.checkSelfPermission(context,
                    Manifest.permission.ACCESS_NETWORK_STATE)
                    != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.ACCESS_NETWORK_STATE);
            }

            if (permissions.size() != 0) {
                ActivityCompat.requestPermissions((SplashActivity) context,
                        permissions.toArray(new String[permissions.size()]),
                        AppConstants.Common.COMMON_REQUEST_PERMISSION_CODE);
                isNeededRequestRuntime = true;
            }
        }

        return isNeededRequestRuntime;
    }
}
