package com.example.variousobjects;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.CalendarView;

public class ScrollCalendar extends CalendarView {
    public ScrollCalendar(@NonNull Context context) {
        super(context);
    }

    public ScrollCalendar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollCalendar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {
            ViewParent p = this.getParent();
            if (p != null) {
                p.requestDisallowInterceptTouchEvent(true);
            }
        }
        return false;
    }
}
