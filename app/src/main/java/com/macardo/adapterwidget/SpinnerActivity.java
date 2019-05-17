package com.macardo.adapterwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {
    private TextView textView;
    private Spinner spinner;
    private List<String> fruitList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        textView = findViewById(R.id.textView3);
        spinner = findViewById(R.id.spinner);
        //1.数据源
        fruitList = new ArrayList<>();
        init();
        //2.适配器
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,fruitList);
        //选择下拉列表样式
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        //3.Spinner绑定适配器
        spinner.setAdapter(adapter);
        //4.Spinner添加监听器
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String fruitName = adapter.getItem(position);
                textView.setText("今天打算吃"+ fruitName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void init() {
        String data[] ={"apple","banana","watermelon","pear","peach"};
        for (int i=0;i<5;i++){
            fruitList.add(data[i]);
        }
    }
}
