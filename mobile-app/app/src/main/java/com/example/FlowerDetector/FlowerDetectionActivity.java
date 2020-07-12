package com.example.FlowerDetector;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.FlowerDetector.utils.AppConstants;
import com.example.FlowerDetector.utils.DebugLog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;

public class FlowerDetectionActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnShowMore;
    private TextView mDetectedFlower;
    private TextView mFlowerType;
    private TextView mFlowerDescription;
    private TextView mInformationSource;
    private ImageView mFlowerView;

    private TextView mFlowerDefinition;
    private TextView mSecondSource;
    private Button mBtnSecondShowMore;

    private TextView mReference;
    private CardView mViewBiology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_detection);
        initViewComponents();
        initEvents();
    }

    private void initViewComponents() {
        // cardview 1
        mBtnShowMore = (Button) findViewById(R.id.btn_show_more);
        mDetectedFlower = (TextView) findViewById(R.id.tv_detected_flower);
        mFlowerType = (TextView) findViewById(R.id.tv_flower_type);
        mFlowerDescription = (TextView) findViewById(R.id.tv_flower_description);
        mInformationSource = (TextView) findViewById(R.id.tv_info_source);
        mFlowerView = (ImageView) findViewById(R.id.iv_flower_type);

        // cardview 2
        mSecondSource = (TextView) findViewById(R.id.tv_second_info_source);
        mFlowerDefinition = (TextView) findViewById(R.id.tv_flower_definition);
        mBtnSecondShowMore = (Button) findViewById(R.id.btn_second_show_more);
        mReference = findViewById(R.id.tv_reference);
        mViewBiology = (CardView) findViewById(R.id.card_biology);

        displayFlowerInformation();
        displayCapturedPhoto();
    }

    private void displayFlowerInformation() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String flowerType = extras.getString("flower_type");
            assert flowerType != null;
            if (flowerType.equals("null")) {
                // Wiki
                mDetectedFlower.setText(R.string.no_flower);
                mFlowerType.setText("");
                mFlowerDescription.setText(R.string.no_content);
                mBtnShowMore.setVisibility(View.GONE);
                mInformationSource.setText(R.string.no_result);

                // Biology
                mReference.setVisibility(View.GONE);
                mViewBiology.setVisibility(View.GONE);
            } else {
                String prefix = getString(R.string.prefix_flower);
                String detectedFlower = prefix + " " + "<b>" + flowerType + "</b>";

                // Wiki
                mDetectedFlower.setText(Html.fromHtml(detectedFlower));
                mFlowerType.setText(flowerType);
                mFlowerDescription.setText(AppConstants.FLOWER_DESCRIPTION.get(flowerType));

                // Biology
                mFlowerDefinition.setText(AppConstants.FLOWER_DEFINITION.get(flowerType));
            }
        }
    }

    private void displayCapturedPhoto() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String fileName = extras.getString("file_name");
            Glide.with(this).load(fileName).into(mFlowerView);
        }
    }

    private void initEvents() {
        mBtnShowMore.setOnClickListener(this);
        mBtnSecondShowMore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show_more:
                DebugLog.d("Button Show more pressed");
                openWikipedia();
                break;
            case R.id.btn_second_show_more:
                openBiologyDictionaryOnline();
                break;
        }
    }

    private void openWikipedia() {
        String url = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String flowerType = extras.getString("flower_type");
            url = AppConstants.FLOWER_WIKI_URL.get(flowerType);
        }
        if (url != null) {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(this, Uri.parse(url));
        } else {
            showToast(getString(R.string.toast_no_url));
        }
    }

    private void openBiologyDictionaryOnline() {
        String url = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String flowerType = extras.getString("flower_type");
            url = AppConstants.FLOWER_BIOLOGY_URL.get(flowerType);
        }
        if (url != null) {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(this, Uri.parse(url));
        } else {
            showToast(getString(R.string.toast_no_url));
        }
    }

    private void showToast(String text) {
        Context context = this;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
