package com.macardo.adapterwidget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int itemLayout;

    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        itemLayout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1.获取列表项的实例
        Fruit fruit = getItem(position);
        View view;

        ViewHolder viewHolder;
        if (convertView == null){
            //2.设置列表项的布局
            view = LayoutInflater.from(getContext()).inflate(itemLayout,null);
            //3.绑定控件实例
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.imageView);
            viewHolder.textView = view.findViewById(R.id.textView2);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.imageView.setImageResource(fruit.getImageid());
        viewHolder.textView.setText(fruit.getName());
        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
