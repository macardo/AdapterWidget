package com.macardo.adapterwidget;

import android.graphics.Color;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerTabStrip pagerTabStrip;
    private List<View> viewList;
    private List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        viewPager = findViewById(R.id.viewPager);
        pagerTabStrip = findViewById(R.id.pagerTabStrip);
        viewList = new ArrayList<>();
        titleList = new ArrayList<>();
        //2.准备数据源
        View view1 = View.inflate(this,R.layout.page1,null);
        View view2 = View.inflate(this,R.layout.page2,null);
        View view3 = View.inflate(this,R.layout.page3,null);
        View view4 = View.inflate(this,R.layout.page4,null);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
        titleList.add("第一页");
        titleList.add("第二页");
        titleList.add("第三页");
        titleList.add("第四页");

        //3.修改TAB样式
        pagerTabStrip.setBackgroundColor(Color.GRAY);
        pagerTabStrip.setTextColor(Color.BLACK);
        pagerTabStrip.setTabIndicatorColor(Color.RED);

        //4.创建PagerAdapter适配器，绑定数据源
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(viewList,titleList);
        //5.ViewPager绑定适配器
        viewPager.setAdapter(myPagerAdapter);
        //6.ViewPager添加监听器
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Toast.makeText(ViewPagerActivity.this,"第"+(i+1)+"页",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
