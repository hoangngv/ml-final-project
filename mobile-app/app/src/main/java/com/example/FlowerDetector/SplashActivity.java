package com.example.FlowerDetector;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;

import com.example.FlowerDetector.base.BaseActivity;
import com.example.FlowerDetector.utils.AppConstants;
import com.example.FlowerDetector.utils.PermissionHelper;

import static com.example.FlowerDetector.utils.AppConstants.Common.SPLASH_TIME_OUT;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(!PermissionHelper.requestRuntimePermission(this)){
            redirectScreen();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case AppConstants.Common.COMMON_REQUEST_PERMISSION_CODE: {
                boolean permissionAllowed = true;
                for (int i = 0; i < permissions.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        //TODO Define a toast here
                        permissionAllowed = false;
                        finish();
                    }
                }
                if (permissionAllowed){
                    redirectScreen();
                }
            }
        }
    }

    private void redirectScreen(){
        new Handler().postDelayed(() -> switchToMainScreen(), SPLASH_TIME_OUT);
    }

    private void switchToMainScreen() {
        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}