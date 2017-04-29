package org.demo_viewpager_auto;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager Vp;
    private List<View> list;
    private int[] image = new int[]{R.mipmap.p1, R.mipmap.p2, R.mipmap.p3, R.mipmap.p4};
    private int current=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        addList();
        Vp = (ViewPager) findViewById(R.id.Vp);
        Vp.setAdapter(new mPagerAdp(this, list));
        Vp.setCurrentItem(current);
        Vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.v("test","Scrolled:"+position);
            }

            @Override
            public void onPageSelected(int position) {
                Log.v("test","Selected:"+position);
                if (position==0){
                    current=image.length;
                }else if (position==image.length+1){
                    current=1;
                }else {
                    current=position;
                }
//                Vp.setCurrentItem(current,false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state==ViewPager.SCROLL_STATE_IDLE){
                    Log.v("test","state"+state);
                    Vp.setCurrentItem(current,false);
                }
            }
        });
    }

    private void addList() {
        list = new ArrayList<>();
        for (int i = 0; i < image.length+2 ; i++) {
            ImageView imageview = new ImageView(this);
               if (i==0){
                   imageview.setImageResource(image[image.length-1]);
                   list.add(imageview);
               }else if (i==image.length+1){
                   imageview.setImageResource(image[0]);
                   list.add(imageview);
               }else {
                   imageview.setImageResource(image[i-1]);
                   list.add(imageview);
               }

        }
    }
}
