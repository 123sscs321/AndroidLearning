package com.byd.mylibrary.wallpaper;

import android.app.WallpaperManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.byd.mylibrary.R;

import java.io.IOException;

public class DetailsActivity extends AppCompatActivity {
    Bitmap bitmap;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        String title = getIntent().getStringExtra("title");
        //Bitmap bitmap = getIntent().getParcelableExtra("image");
        position = getIntent().getIntExtra("position", 0);


        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(title);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(position, -1));
        imageView.setImageBitmap(bitmap);

    }

    public void onSetWallpaperForResource(View view) {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        try {
            wallpaperManager.setResource(getResources().obtainTypedArray(R.array.image_ids).getResourceId(position, -1));
            Toast.makeText(this, "设置壁纸成功", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
