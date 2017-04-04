package com.example.rgb;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBarRed;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get Seekbar objects
        seekBarRed = (SeekBar) findViewById(R.id.seekBarRed);
        seekBarGreen = (SeekBar) findViewById(R.id.seekBarGreen);
        seekBarBlue = (SeekBar) findViewById(R.id.seekBarBlue);

        // define and Listener (anonymous inner class)
        SeekBar.OnSeekBarChangeListener seekbarListener = new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setBackgroundColor();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        };

        seekBarRed.setOnSeekBarChangeListener(seekbarListener);
        seekBarGreen.setOnSeekBarChangeListener(seekbarListener);
        seekBarBlue.setOnSeekBarChangeListener(seekbarListener);
        setBackgroundColor();
    }


    private void setBackgroundColor() {
        int r = seekBarRed.getProgress() * 255 / 100;
        int g = seekBarGreen.getProgress() * 255 / 100;
        int b = seekBarBlue.getProgress() * 255 / 100;
        this.getWindow().getDecorView().getRootView().setBackgroundColor(Color.argb(255, r, g, b));
    }

}
