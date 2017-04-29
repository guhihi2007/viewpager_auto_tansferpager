# viewpager_auto_tansferpager


轮播图自动切换
关键代码
 ViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state==ViewPager.SCROLL_STATE_IDLE){
                    Log.v("test","state"+state);
                    Vp.setCurrentItem(current,false);
                }
            }
        });
