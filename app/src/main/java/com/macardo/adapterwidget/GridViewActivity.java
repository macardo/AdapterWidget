package com.macardo.adapterwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridViewActivity extends AppCompatActivity {
    private GridView gridView;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>> fruitList;

    int image[] = {R.drawable.apple,R.drawable.banana,R.drawable.watermelon,R.drawable.pear,R.drawable.peach};
    String data[] ={"apple","banana","watermelon","pear","peach"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridView = findViewById(R.id.gridView);
        //2.准备数据源
        fruitList = new ArrayList<>();
        listinit();
        //3.适配器绑定数据源
        simpleAdapter = new SimpleAdapter(GridViewActivity.this,fruitList,R.layout.item2,new String[]{"image","data"},new int[]{R.id.imageView2,R.id.textView3});
        //4.GridView绑定适配器
        gridView.setAdapter(simpleAdapter);
        //5.给GridView添加监听器
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,position+":"+ data[position],Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void listinit() {

        for (int i=0;i<data.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("image",image[i]);
            map.put("data",data[i]);
            fruitList.add(map);
        }
    }
}
