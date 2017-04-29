package org.demo_viewpager_auto;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/25.
 */

class mPagerAdp extends PagerAdapter {

    private List<View> list;
    private Context context;

    public mPagerAdp(Context context, List<View> list) {
        this.list = list;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        if (position == 0) container.addView(list.get(list.size() - 1));
//        else if (position == list.size() - 1) {
//            container.addView(list.get(0));
//        } else {
            container.addView(list.get(position));
//        }
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size() ;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
