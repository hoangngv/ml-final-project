package com.example.FlowerDetector.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.FlowerDetector.FlowerDetectionActivity;
import com.example.FlowerDetector.R;
import com.example.FlowerDetector.apiconnection.ApiManager;
import com.example.FlowerDetector.apiconnection.ApiService;
import com.example.FlowerDetector.apiconnection.FlowerDetectionResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageOverlayView extends RelativeLayout {

    private String mDeleteLabel;
    private String mFileName;
    private Context mContext;

    private ApiService mService;

    public ImageOverlayView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public ImageOverlayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImageOverlayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setDeleteLabel(String text) {
        this.mDeleteLabel = text;
    }


    public void setFileName(String text) {
        this.mFileName = text;
    }

    private void uploadImageToServer() {
        AppUtils.showCircleProgressDialog(mContext);
        AppUtils.setProgressDialogMessage("Waiting");
        String fileName = mFileName.replace("file://", "");
        //File file = new File(fileName);
        Bitmap bitmap = BitmapFactory.decodeFile(fileName);
        String base64Image = AppUtils.bitmapToBase64(bitmap);

        DebugLog.d("[FlowerDetection]" + fileName);

//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("img", file.getName(), requestFile);

        mService.getDetectionResult(base64Image).enqueue(new Callback<FlowerDetectionResponse>() {
            @Override
            public void onResponse(@NotNull Call<FlowerDetectionResponse> call, @NotNull Response<FlowerDetectionResponse> response) {
                if (response.isSuccessful()) {
                    AppUtils.dismissCircleProgressDialog();
                    assert response.body() != null;
                    showToast("Response Code: " + response.code());
                    switchToFlowerDetectionActivity(response.body().getFlowerType());
                    DebugLog.d("[FlowerDetection] Response: " + response.body().getFlowerType());
                    DebugLog.d("[FlowerDetection] Response: " + response.body().getScore());
                } else {
                    AppUtils.dismissCircleProgressDialog();
                    showToast("Response Code: " + response.code());
                    DebugLog.d("[FlowerDetection]" + response.code());
                }
            }

            @Override
            public void onFailure(@NotNull Call<FlowerDetectionResponse> call, Throwable t) {
                AppUtils.dismissCircleProgressDialog();
                showToast("Failure: " + t.getMessage());
                DebugLog.d("[FlowerDetection] Error: " + t.toString());
                DebugLog.d("[FlowerDetection] Error: " + t.getMessage());
                DebugLog.d("[FlowerDetection] Error: " + t.getCause());
                DebugLog.d("[FlowerDetection] Error: " + t.getStackTrace());
            }
        });
    }

    private void init() {
        mService = ApiManager.getApiService();
        View view = inflate(getContext(), R.layout.view_image_overlay, this);

        view.findViewById(R.id.btnUpload).setOnClickListener(v -> {
            //switchToFlowerDetectionActivity("none");
            uploadImageToServer();
        });
    }

    private void switchToFlowerDetectionActivity(String flowerType) {
        Intent intent = new Intent(mContext, FlowerDetectionActivity.class);
        intent.putExtra("flower_type", flowerType);
        intent.putExtra("file_name", mFileName);
        mContext.startActivity(intent);
    }

    private void showToast(String text) {
        Context context = mContext;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}