package com.example.secpc.hellostranger.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by secpc on 2016-10-30.
 */
public class CustomViewPager implements ViewPager.PageTransformer {
    TranslateAnimation ani;
    public void transformPage(View view, float position) {
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.

        } else if (position <= 0) { // [-1,0]
            // Use the default slide transition when moving to the left page
//             ani = new TranslateAnimation(
//                    Animation.RELATIVE_TO_SELF, 0,
//                    Animation.RELATIVE_TO_PARENT, 1,
//                    Animation.RELATIVE_TO_SELF, 0,
//                    Animation.RELATIVE_TO_PARENT, 1);
//            ani.setFillAfter(true); // 애니메이션 후 이동한좌표에
//            ani.setDuration(300); //지속시간

        } else if (position <= 1) { // (0,1]
            // Fade the page out.
             ani = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, 0,
                    Animation.RELATIVE_TO_PARENT, -1,
                    Animation.RELATIVE_TO_SELF, 0,
                    Animation.RELATIVE_TO_PARENT, -1);
            ani.setFillAfter(true); // 애니메이션 후 이동한좌표에
            ani.setDuration(100); //지속시간
            view.startAnimation(ani);

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.

        }

    }
}