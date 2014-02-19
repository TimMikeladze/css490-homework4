package com.css490.homework4.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;


public class BookViewPager extends ViewPager {
        private Context context;
        private boolean isLocked;

        public BookViewPager(Context context) {
            super(context);
            this.context = context;
        }

        public BookViewPager(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.context = context;
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (!isLocked) {
                return super.onTouchEvent(event);
            }
            return false;
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent event) {
            if (!isLocked) {
                return super.onInterceptTouchEvent(event);
            }
            return false;
        }

        public void toggleScroll(boolean isLocked) {
            this.isLocked = isLocked;
        }
}
