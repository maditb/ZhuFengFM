package com.madi.fullycustom.deviceadapte.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.madi.fullycustom.deviceadapte.app.fragments.DetailFragment;

import java.util.ArrayList;

/**
 * 支持横竖屏切换的activity，利用布局来实现功能
 */
public class EnterActivity extends ActionBarActivity implements AdapterView.OnItemClickListener,DetailFragment.OnFragmentInteractionListener {


    private ArrayAdapter adapter;
    private ArrayList<String> strings;
    // 横屏情况下的Fragment实例
    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        // 两套布局都包含的ListView，可以直接获取
        ListView listView = (ListView) findViewById(R.id.chapter_list);
        strings = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            strings.add("java 自学通 第"+(i + 1)+"天");
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, strings);
        listView.setAdapter(adapter);
        // listView的点击
        listView.setOnItemClickListener(this);
        //////////////////////////////////////
        //判断是否是横屏，横屏就创建 Fragment 添加到容器
        // 判断是否包含了 横屏才有的内容
        boolean hasContainer = findViewById(R.id.fragment_container) != null;
        if (hasContainer) {
            detailFragment = new DetailFragment();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.fragment_container,detailFragment);
            transaction.commit();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO 点击处理
        String title = strings.get(position);
        String content = "欢迎大家来学习" + title;
        // 如果内部的Fragment有值  代表当前是横屏
        if (detailFragment != null) {
            detailFragment.setChapter(title,content);
        }else {
            Intent intent = new Intent(this,DetailActivity.class);
            // 传递数据，竖屏的情况
            intent.putExtra("title",title);
            intent.putExtra("content",content);
            startActivity(intent);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void btnJump(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
