package com.example.orientationcustomview;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class SensorActivity extends Activity implements SensorEventListener {
    private CustomSurfaceView customSurfaceView;
    private SensorManager mSensorManager;
    private Sensor sensor;

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        customSurfaceView = (CustomSurfaceView)findViewById(R.id.customSurfaceView);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        // Umrechnung Rotationsvektor --> Rotationsmatrix
        float[] rotationMatrix = new float[9];
        SensorManager.getRotationMatrixFromVector(rotationMatrix, event.values);
        // Umrechnung Rotationsmatrix --> Orientierung (3 Winkel)
        final float[] orientationAngles = new float[3];
        SensorManager.getOrientation(rotationMatrix, orientationAngles);
        // Azimuth darstellen
        customSurfaceView.drawCanvas(orientationAngles[0]);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
