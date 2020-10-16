package cn.fjzzy.rainanimator.entity;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public abstract class BaseView extends View {

    private control thread;

    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected abstract void drawsub(Canvas canvas);

    protected abstract void move();

    protected abstract void init();

    @Override
    protected void onDraw(Canvas canvas) {
        if (thread == null) {
            thread = new control();
            thread.start();
        }
        drawsub(canvas);
    }

    public class control extends Thread {
        @Override
        public void run() {
            init();
            while (true) {
                move();
                postInvalidate();
                try {
                    sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
