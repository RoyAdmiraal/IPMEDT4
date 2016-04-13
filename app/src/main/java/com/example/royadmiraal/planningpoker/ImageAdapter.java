package com.example.royadmiraal.planningpoker;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Objects;

/**
 * Created by IPMEDT4 - Groep A on 11-04-16.
 */

public class ImageAdapter extends PagerAdapter{
    Context context;
    public int[] GalImages = new int[] {
            R.drawable.kaart0,                      // array nr. 0 = kaart  0
            R.drawable.kaart0_5,                    // array nr. 1 = kaart  0.5
            R.drawable.kaart1,                      // array nr. 2 = kaart  1
            R.drawable.kaart2,                      // array nr. 3 = kaart  2
            R.drawable.kaart3,                      // array nr. 4 = kaart  3
            R.drawable.kaart5,                      // array nr. 5 = kaart  5
            R.drawable.kaart8,                      // array nr. 6 = kaart  8
            R.drawable.kaart13,                     // array nr. 7 = kaart  13
            R.drawable.kaart20,                     // array nr. 8 = kaart  20
            R.drawable.kaart40,                     // array nr. 9 = kaart  40
            R.drawable.kaart100,                    // array nr. 10 = kaart 100
            R.drawable.kaart_inf,                   // array nr. 11 = kaart oneindig
            R.drawable.kaart_vraag,                 // array nr. 12 = kaart vraagteken
            R.drawable.kaart_koffie,                // array nr. 13 = kaart koffie
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
        Log.d("Log data: ItemPosition", test);

        return super.getItemPosition(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);

    }

}