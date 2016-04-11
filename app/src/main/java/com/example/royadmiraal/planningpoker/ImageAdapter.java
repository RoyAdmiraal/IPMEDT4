package com.example.royadmiraal.planningpoker;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Objects;

/**
 * Created by Royadmiraal on 11-04-16.
 */
public class ImageAdapter extends PagerAdapter{
    Context context;
public int[] GalImages = new int[] {
        R.drawable.kaart0_5,
        R.drawable.kaart0,
        R.drawable.kaart1,
        R.drawable.kaart2,
        R.drawable.kaart3,
        R.drawable.kaart5,
        R.drawable.kaart8,
        R.drawable.kaart13,
        R.drawable.kaart20,
        R.drawable.kaart40,
        R.drawable.kaart100,
        R.drawable.kaartoneindig,
        R.drawable.kaartvraagteken,
        R.drawable.kaartkoffie,

};

        ImageAdapter(Context context){
        this.context=context;
        }
@Override
public int getCount() {
        return GalImages.length;

        }

@Override
public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);


        }

@Override
public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        int padding = context.getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin);
        imageView.setPadding(padding, padding, padding, padding);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setImageResource(GalImages[position]);

        ((ViewPager) container).addView(imageView, 0);
        return imageView;
        }


        @Override
        public int getItemPosition(Object object) {

                String test = String.valueOf(super.getItemPosition(object));
                Log.d("", test);
                return super.getItemPosition(object);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);

        }
        }