package com.flurgle.camerakit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by faridhadiselklik on 02/05/2017.
 */

public class MyCameraView extends CameraView {

    public MyCameraView(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs);
        mCameraImpl = new MyCamera1(mCameraListener, mPreviewImpl);
    }
}
