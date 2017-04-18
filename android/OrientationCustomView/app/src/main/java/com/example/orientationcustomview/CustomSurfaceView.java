package com.example.orientationcustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Andreas on 17.04.2017.
 */

public class CustomSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder;

    public CustomSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) { }

    public void drawCanvas(float angle){
        Canvas canvas = surfaceHolder.lockCanvas();
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        canvas.drawRGB(255,255, 255);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLACK);
        int cx = width/2;
        int cy = height/2;
        int radius = width*2/5;
        canvas.drawCircle(cx, cy, radius, paint);

        for(int i = 0; i < 360; i+=30){
            float sin = (float) Math.sin(2*Math.PI*i/360);
            float cos = (float) Math.cos(2*Math.PI*i/360);
            int tickLength = 50;
            float x1 = cx + sin * (radius - tickLength);
            float x2 = cx + sin * radius;
            float y1 = cy - cos * (radius - tickLength);
            float y2 = cy - cos * radius;
            canvas.drawLine(x1, y1, x2, y2, paint);
        }

        paint.setColor(Color.RED);
        float x = (float)(Math.sin(angle) * radius);
        float y = (float)(Math.cos(angle) * radius);
        canvas.drawLine(cx, cy, cx - x, cy - y, paint);
        surfaceHolder.unlockCanvasAndPost(canvas);
    }


}