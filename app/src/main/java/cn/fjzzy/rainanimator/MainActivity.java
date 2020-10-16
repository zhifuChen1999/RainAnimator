package cn.fjzzy.rainanimator;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import cn.fjzzy.rainanimator.entity.Rainplay;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private ImageView imageView;
    private View decorView;
    private Window window;
    private ViewTreeObserver viewTreeObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        initConfig();
        setContentView(R.layout.activity_main);
        init();
    }

    private void initConfig() {
        window = getWindow();
        decorView = window.getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.setStatusBarColor(Color.TRANSPARENT);
    }

    private void init() {
        frameLayout = (FrameLayout) findViewById(R.id.fl);
        imageView = (ImageView) findViewById(R.id.iv);
        Rainplay rainplay = new Rainplay(this);
        frameLayout.addView(rainplay, 0);
//        HeartView heartView = new HeartView(this);
//        frameLayout.addView(heartView);

        viewTreeObserver = decorView.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(-decorView.getHeight(), decorView.getHeight());
                valueAnimator.setDuration(8 * 1000);
                valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
                valueAnimator.setInterpolator(new LinearInterpolator());
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float animatedValue = (float) animation.getAnimatedValue();
                        imageView.setTranslationY(-animatedValue);
                    }
                });
                valueAnimator.start();

            }
        });

    }
}