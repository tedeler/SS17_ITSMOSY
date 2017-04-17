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

    public void drawCanvas(){
        Canvas canvas = surfaceHolder.lockCanvas();
		// hier kann auf das Canvas-Objekt gezeichnet werden...
		
		// Beispiel: rotes Rechteck
		Paint paint = new Paint();
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(Color.RED);   
		Rect rect = new Rect(10, 20, 100, 399);
		canvas.paintRect(rect, paint);

        surfaceHolder.unlockCanvasAndPost(canvas);
    }


}