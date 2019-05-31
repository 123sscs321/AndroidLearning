package com.byd.myapplication.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.byd.myapplication.R;

import java.util.List;

public class GalleryAdapter extends BaseAdapter {
    private List<Gallerys> Datas;
    private LayoutInflater mInflater;

    public GalleryAdapter(List<Gallerys> datas, Context context) {
        Datas = datas;
        mInflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return Datas.size();
    }

    @Override
    public Object getItem(int i) {
        return Datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = mInflater.inflate(R.layout.list_item,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_gallery);
        Gallerys item = Datas.get(i);
        imageView.setImageResource(item.imageResId);
        return view;

    }


}
