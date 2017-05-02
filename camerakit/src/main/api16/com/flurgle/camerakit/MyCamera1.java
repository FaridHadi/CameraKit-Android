package com.flurgle.camerakit;

import android.util.Log;

import java.io.IOException;

/**
 * Created by faridhadiselklik on 02/05/2017.
 */

public class MyCamera1 extends Camera1 {
    private String TAG = MyCamera1.class.getSimpleName();

    MyCamera1(CameraListener callback, PreviewImpl preview) {
        super(callback, preview);
    }

    @Override
    void endVideo() {
        boolean isMediaRecorder = mMediaRecorder == null;
        Log.d(TAG, "media recorder : " + Boolean.toString(isMediaRecorder));
        super.endVideo();
    }

    private void releaseMediaRecorder(){
        if (mMediaRecorder != null) {
            mMediaRecorder.reset();   // clear recorder configuration
            mMediaRecorder.release(); // release the recorder object
            mMediaRecorder = null;
            mCamera.lock();           // lock camera for later use
        }
    }

    private boolean prepareMediaRecorder(){
        try {
            mMediaRecorder.prepare();
        } catch (IllegalStateException e) {
            Log.d(TAG, "IllegalStateException preparing MediaRecorder: " + e.getMessage());
            releaseMediaRecorder();
            return false;
        } catch (IOException e) {
            Log.d(TAG, "IOException preparing MediaRecorder: " + e.getMessage());
            releaseMediaRecorder();
            return false;
        }
        return true;
    }

    @Override
    void startVideo() {
//        super.startVideo();
        initMediaRecorder();
//        prepareMediaRecorder();
//        mMediaRecorder.start();
        if (prepareMediaRecorder()){
            mMediaRecorder.start();
        } else {
            releaseMediaRecorder();
        }
    }


}
