package com.example.FlowerDetector;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.FlowerDetector.base.BaseActivity;
import com.example.FlowerDetector.utils.DebugLog;
import com.example.FlowerDetector.utils.ImageOverlayView;
import com.example.FlowerDetector.utils.StylingOptions;
import com.stfalcon.frescoimageviewer.ImageViewer;

public class ImageReviewActivity extends BaseActivity {

    private ImageView mTakenPhoto;
    private String[] mImages;
    private ImageOverlayView mImageOverlayView;
    private StylingOptions mStyleOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_review);
        initViewComponents();
        initImageReviewScreen();
    }

    private void initViewComponents() {
        mTakenPhoto = (ImageView) findViewById(R.id.iv_taken_photo);
        mStyleOptions = new StylingOptions();
    }

    private void initImageReviewScreen() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String imagePath = extras.getString("image_path");
            mImages = new String[] {"file://" + imagePath};
        }
        //Glide.with(this).load(mImages[0]).into(mTakenPhoto);
        showImage(mImages);
    }

    private void showImage(String[] path) {
        ImageViewer.Builder builder = new ImageViewer.Builder<>(this, path)
                .setOnDismissListener(getDismissListener());

        builder.hideStatusBar(mStyleOptions.get(StylingOptions.Property.HIDE_STATUS_BAR));
        builder.allowSwipeToDismiss(mStyleOptions.get(StylingOptions.Property.SWIPE_TO_DISMISS));
        builder.allowZooming(mStyleOptions.get(StylingOptions.Property.ZOOMING));

        if (mStyleOptions.get(StylingOptions.Property.SHOW_OVERLAY)) {
            mImageOverlayView = new ImageOverlayView(this);
            builder.setOverlayView(mImageOverlayView);
            builder.setImageChangeListener(getImageChangeListener());
        }

        builder.show();
    }

    private ImageViewer.OnImageChangeListener getImageChangeListener() {
        return position -> {
            // TODO
            DebugLog.d("[Custom Grid] ImageViewer.onImageChange...");
            String uri = mImages[position];
            mImageOverlayView.setFileName(uri);
        };
    }

    private ImageViewer.OnDismissListener getDismissListener() {
        return () -> {
            // TODO
            ImageReviewActivity.super.onBackPressed();
            DebugLog.d("[Custom Grid] ImageViewer.onDismiss...");
        };
    }
}
