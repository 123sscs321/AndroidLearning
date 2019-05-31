package com.byd.myapplication.gallery;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.byd.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends Activity {
    private List<Gallerys> lists = new ArrayList<>();
    private ListView listView;
    private int[] imageViews = {android.R.drawable.btn_minus, android.R.drawable.btn_radio, android.R.drawable.ic_lock_idle_low_battery, android.R.drawable.ic_menu_camera};

    @Override
    public void onCreate(Bundle savedStates) {
        super.onCreate(savedStates);
        setContentView(R.layout.activity_gallery);
        listView = (ListView) findViewById(R.id.listView);
        for (int i = 0; i < imageViews.length; i++) {
            lists.add(new Gallerys(imageViews[i]));
        }
        listView.setAdapter(new GalleryAdapter(lists, this));

    }
}
