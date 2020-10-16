package cn.fjzzy.rainanimator.entity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Rainplay extends BaseView {
    private int num = 200;
    private ArrayList<RainEntity> list = new ArrayList<>();

    public Rainplay(Context context) {
        super(context);
    }

    public Rainplay(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void drawsub(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        for (RainEntity item : list) {
            item.draw(canvas);
        }
    }

    @Override
    protected void move() {
        for (RainEntity item : list) {
            item.moveStep();
        }
    }

    @Override
    protected void init() {
        for (int i = 0; i < num; i++) {
            RainEntity rainEntity = new RainEntity(getWidth(), getHeight());
            list.add(rainEntity);
        }
    }
}
