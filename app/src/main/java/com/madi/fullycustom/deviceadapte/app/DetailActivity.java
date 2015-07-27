package com.madi.fullycustom.deviceadapte.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import com.madi.fullycustom.deviceadapte.app.fragments.DetailFragment;


public class DetailActivity extends ActionBarActivity  implements DetailFragment.OnFragmentInteractionListener {

    private DetailFragment detailFragment;
    private DetailFragment detailFragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_detail);

        FragmentManager manager = getSupportFragmentManager();
      //  detailFragment = (DetailFragment) manager.findFragmentById(R.id.fragment_detail);
        detailFragment1 = (DetailFragment) manager.findFragmentById(R.id.fragment_detail1);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // 获取信息 显示内容
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");

       // detailFragment.setChapter(title,content);
        detailFragment1.setChapter(title,content);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
