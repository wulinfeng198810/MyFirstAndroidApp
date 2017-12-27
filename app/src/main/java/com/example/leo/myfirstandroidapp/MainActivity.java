package com.example.leo.myfirstandroidapp;
//MainActivity


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {


        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return 10;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            if (convertView == null) {
                view = new View(mContext);

                Resources resources = MainActivity.this.getResources();
                DisplayMetrics dm = resources.getDisplayMetrics();
                float density1 = dm.density;
                int width = (int)(dm.widthPixels/4 - 9);
                view.setLayoutParams(new GridView.LayoutParams(100, 100));
                view.setLayoutParams(new GridView.LayoutParams(width, width));
                view.setBackgroundColor(Color.parseColor("#ff0000"));
            } else {
                view = convertView;
            }
            return view;

//            GridItemView gridItemView = null;
//            if (convertView == null) {
//                gridItemView = new GridItemView();
//                convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item_layout, null);
//                gridItemView.imageView = convertView.findViewById(R.id.item_imageView);
//                gridItemView.textView = convertView.findViewById(R.id.item_textView);
//                convertView.setLayoutParams(new GridView.LayoutParams(gridview.getWidth()/4, gridview.getWidth()/4));
//                gridItemView.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
////                convertView.setPadding(8, 8, 8, 8);
//                convertView.setTag(gridItemView);
//            } else {
//                gridItemView = (GridItemView) convertView.getTag();
//            }
//            gridItemView.imageView.setImageResource(mThumbIds[0]);
////            Glide.with(mContext).load("https://lh6.ggpht.com/9SZhHdv4URtBzRmXpnWxZcYhkgTQurFuuQ8OR7WZ3R7fyTmha77dYkVvcuqMu3DLvMQ=w300").into(gridItemView.imageView);
//            gridItemView.textView.setText("标题");
//            return convertView;
        }
    }

    class GridItemView {
        ImageView imageView;
        TextView textView;
    }
}
