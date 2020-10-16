package cn.fjzzy.rainanimator.entity;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Random;

public class RainEntity {
    private int width;
    private int height;
    private int sizeY;
    private int sizeX;
    private int startY;
    private int startX;
    private int stopY;
    private int stopX;
    private float of = 0.5f;
    private Random random = new Random();
    private Paint paint;

    /**
     *
     * @param width
     * @param height
     */
    public RainEntity(int width, int height) {
        this.width = width;
        this.height = height;
        init();
    }

    private void init() {
        sizeX = 1 + random.nextInt(10);//线的大小
        sizeY = 10 + random.nextInt(20);//
        startX = random.nextInt(width);//线开始的位置的X坐标
        startY = random.nextInt(height);//线开始的位置的Y坐标
        stopX = startX + sizeX;//
        stopY = startY + sizeY;//
        of = (float) (0.2+ random.nextFloat());
//        of = (float) (1+ random.nextFloat());
        paint = new Paint();
    }

    public void draw(Canvas canvas) {
        paint.setARGB(255, random.nextInt(255), random.nextInt(255), random.nextInt(255));
        canvas.drawLine(startX, startY, stopX, startY, paint);
    }

    ;

    public void moveStep() {
        startX += sizeX * of;
        stopX += sizeX * of;

        startY += sizeY * of;
        stopY += sizeY * of;
        if (startY > height) {
            init();
        }
    }
}
