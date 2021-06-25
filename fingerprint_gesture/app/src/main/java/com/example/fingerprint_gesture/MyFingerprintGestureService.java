package com.example.fingerprint_gesture;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.FingerprintGestureController;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

import static android.accessibilityservice.FingerprintGestureController.*;
public class MyFingerprintGestureService extends AccessibilityService {
        private static final String TAG = "Vivek";
        @Override
        public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            Log.d(TAG, "onAccessibilityEvent");
        }

        @Override
        public void onInterrupt() {
            Log.d(TAG, "onInterrupt");
        }

        @Override
        protected boolean onGesture(int gestureId) {

            Log.d(TAG+"", "onGesture " + gestureId);
            return super.onGesture(gestureId);
        }

        @Override
        protected boolean onKeyEvent(KeyEvent event) {
            Log.d(TAG, "onKeyEvent " + event.getKeyCode());
            return super.onKeyEvent(event);
        }

        @Override
        public void onDestroy() {
            Toast.makeText(getApplicationContext(), "onDestroy" , Toast.LENGTH_SHORT).show();
            super.onDestroy();
        }



        @Override
        protected void onServiceConnected() {
            super.onServiceConnected();
            Log.d(TAG, "onServiceConnected");

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                FingerprintGestureController gestureController = getFingerprintGestureController();

                Toast.makeText(getApplicationContext(), "Is available: " + gestureController.isGestureDetectionAvailable(), Toast.LENGTH_LONG).show();
                Log.e(TAG, "Is available: " + gestureController.isGestureDetectionAvailable() );

                FingerprintGestureController.FingerprintGestureCallback callback = new
                        FingerprintGestureController.FingerprintGestureCallback() {
                            @Override
                            public void onGestureDetectionAvailabilityChanged(boolean available) {
                                super.onGestureDetectionAvailabilityChanged(available);
                                Toast.makeText(getApplicationContext(), "Gesture available change to: " + available, Toast.LENGTH_SHORT).show();
                                Log.d(TAG, "onGestureDetectionAvailabilityChanged " + available);
                            }

                            @Override
                            public void onGestureDetected(int gesture) {
                                super.onGestureDetected(gesture);
                                Toast.makeText(getApplicationContext(), "Gesture: " + gesture, Toast.LENGTH_SHORT).show();
                                Log.d(TAG, "onGestureDetected " + gesture);
                            }
                        };

                gestureController.registerFingerprintGestureCallback(callback, new Handler());
            }
        }

        @Override
        public boolean onUnbind(Intent intent) {
            Log.d(TAG, "onUnbind " );
            return super.onUnbind(intent);
        }


    }
