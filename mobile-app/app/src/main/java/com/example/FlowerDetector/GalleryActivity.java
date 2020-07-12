package com.example.FlowerDetector;

import android.os.Bundle;
import android.widget.GridView;

import com.example.FlowerDetector.base.BaseActivity;
import com.example.FlowerDetector.utils.AppUtils;
import com.example.FlowerDetector.utils.DebugLog;
import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends BaseActivity {

    protected String[] mImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        mImageList = AppUtils.getLocalImageUri();
        DebugLog.d("[Custom Grid] mImageList array length: " + mImageList.length);
        final GridView gridView = findViewById(R.id.gridView);
        CustomGridAdapter adapter = new CustomGridAdapter(this, mImageList);
        gridView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}