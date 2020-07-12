package com.example.FlowerDetector;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.FlowerDetector.base.BaseActivity;

import static com.example.FlowerDetector.utils.AppConstants.Locale.LANGUAGE_OPTIONS;

public class HomeActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Button mBtnOpenCamera, mBtnOpenGallery;
    private Spinner mLanguageChooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initComponents();
        initEvents();
    }

    private void initComponents() {
        mBtnOpenCamera = findViewById(R.id.btn_open_camera);
        mBtnOpenGallery = findViewById(R.id.btn_open_gallery);
        mLanguageChooser = findViewById(R.id.spn_language);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, LANGUAGE_OPTIONS);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLanguageChooser.setAdapter(dataAdapter);
    }

    private void initEvents() {
        mBtnOpenCamera.setOnClickListener(this);
        mBtnOpenGallery.setOnClickListener(this);
        mLanguageChooser.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_open_camera:
                switchToCameraActivity();
                break;
            case R.id.btn_open_gallery:
                switchToGallery();
                break;
        }
    }

    private void switchToGallery() {
        startActivity(new Intent(this, GalleryActivity.class));
    }

    private void switchToCameraActivity() {
        startActivity(new Intent(this, CameraActivity.class));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
