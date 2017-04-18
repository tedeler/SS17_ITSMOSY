package com.example.orientationsensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

// Quelle: https://developer.android.com/guide/topics/sensors/sensors_overview.html
public class SensorActivity extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor sensor;

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {  }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        // Umrechnung Rotationsvektor --> Rotationsmatrix
        float[] rotationMatrix = new float[9];
        SensorManager.getRotationMatrixFromVector(rotationMatrix, event.values);
        // Umrechnung Rotationsmatrix --> Orientierung (3 Winkel)
        final float[] orientationAngles = new float[3];
        SensorManager.getOrientation(rotationMatrix, orientationAngles);
        // Azimuth darstellen
        double azimuth = orientationAngles[0] * 360 / (2 * Math.PI);
        ((TextView)findViewById(R.id.textView)).setText(String.format("%.0f", azimuth));
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