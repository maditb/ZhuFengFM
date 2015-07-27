package com.madi.fullycustom.deviceadapte.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获取手机硬件 屏幕信息的操作
        Display display = getWindowManager().getDefaultDisplay();
        // 用于获取屏幕的尺寸数据
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        StringBuilder sb = new StringBuilder();
        sb.append("density:").append(metrics.density).append('\n');
        sb.append("dpi:").append(metrics.densityDpi).append('\n');
        sb.append("w:").append(metrics.widthPixels).append('\n');
        sb.append("h:").append(metrics.heightPixels).append('\n');
        sb.append("sd:").append(metrics.scaledDensity).append('\n');
        sb.append("xdpi:").append(metrics.xdpi).append('\n');
        sb.append("ydpi:").append(metrics.ydpi).append('\n');
        sb.append("wdp:").append(metrics.widthPixels/metrics.scaledDensity).append('\n');
        sb.append("hdp:").append(metrics.heightPixels/metrics.scaledDensity).append('\n');

        // px = (dpi/160)*dp
        // scaledDensity = dpi/160
        //dp = px/scaledDensity

        String s = sb.toString();
        TextView textView  = (TextView) findViewById(R.id.txt_info);
        textView.setText(s);


    }

}
