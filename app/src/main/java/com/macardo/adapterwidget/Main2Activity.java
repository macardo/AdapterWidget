package com.macardo.adapterwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private ListView listView;
    private FruitAdapter fruitAdapter;
    private List<Fruit> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = findViewById(R.id.listView2);
        //1.数据源
        list = new ArrayList<>();//创建list实例
        listinit();
        //2.适配器绑定数据源
        fruitAdapter = new FruitAdapter(Main2Activity.this,R.layout.item,list);
        //3.ListView绑定适配器
        listView.setAdapter(fruitAdapter);
    }

    private void listinit() {
/*        Fruit fruit1 = new Fruit(R.drawable.apple,"apple");
        list.add(fruit1);
        Fruit fruit2 = new Fruit(R.drawable.banana,"banana");
        list.add(fruit2);
        Fruit fruit3 = new Fruit(R.drawable.watermelon,"watermelon");
        list.add(fruit3);
        Fruit fruit4 = new Fruit(R.drawable.pear,"pear");
        list.add(fruit4);
        Fruit fruit5 = new Fruit(R.drawable.peach,"peach");
        list.add(fruit5);*/
        int image[] = {R.drawable.apple,R.drawable.banana,R.drawable.watermelon,R.drawable.pear,R.drawable.peach};
        String data[] ={"apple","banana","watermelon","pear","peach"};
        for (int i=0;i<5;i++){
            Fruit fruit = new Fruit(image[i],data[i]);
            list.add(fruit);
        }
    }
}
