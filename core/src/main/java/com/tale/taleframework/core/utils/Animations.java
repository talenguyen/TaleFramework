package com.tale.taleframework.core.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tale on 5/14/15.
 */
public class Animations {

    // ==== show/hide by TRANSLATION_Y from TOP edge. ====
    public static Animator showTranslateDownAnimator(View target, float offset, long duration) {
        if (offset > 1) {
            offset = 1;
        } else if (offset < 0) {
            offset = 0;
        }
        target.setVisibility(View.VISIBLE);
        // Move to offscreen.
        final float translationY = target.getBottom() * offset;
        target.setTranslationY(-translationY);
        // Create animator to animate view to onscreen.
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, View.TRANSLATION_Y, 0);
        if (duration > 0) {
            animator.setDuration(duration);
        }
        return animator;
    }

    public static Animator hideTranslateUpAnimator(View target, float offset, long duration, boolean autoGone) {
        if (offset > 1) {
            offset = 1;
        } else if (offset < 0) {
            offset = 0;
        }
        target.setVisibility(View.VISIBLE);
        // Move to original position.
        target.setTranslationY(0);
        // Create animator to animate view to offscreen
        final float translationY = target.getBottom() * offset;
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, View.TRANSLATION_Y, -translationY);
        if (duration > 0) {
            animator.setDuration(duration);
        }
        if (autoGone) {
            addAutoGone(animator, target);
        }
        return animator;
    }


    // ==== show/hide by ALPHA. ====
    public static Animator showAlphaAnimator(View target, long duration) {
        target.setVisibility(View.VISIBLE);
        target.setAlpha(0f);
        final ObjectAnimator animator = ObjectAnimator.ofFloat(target, View.ALPHA, 1f);
        if (duration > 0) {
            animator.setDuration(duration);
        }
        return animator;
    }

    public static Animator hideAlphaAnimator(View target, long duration) {
        target.setVisibility(View.VISIBLE);
        target.setAlpha(1f);
        final ObjectAnimator animator = ObjectAnimator.ofFloat(target, View.ALPHA, 0f);
        if (duration > 0) {
            animator.setDuration(duration);
        }
        return animator;
    }

    // ==== show/hide by TRANSLATION_Y from BOTTOM edge. ====
    public static Animator hideTranslateDownAnimator(View target, float offset, long duration, boolean autoGone) {
        final ViewGroup parent = (ViewGroup) target.getParent();
        final float translationY = (parent.getHeight() - target.getTop()) * offset;
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, View.TRANSLATION_Y, translationY);
        if (duration > 0) {
            animator.setDuration(duration);
        }
        if (autoGone) {
            addAutoGone(animator, target);
        }
        return animator;
    }

    public static Animator showTranslateUpAnimator(View target, float offset, long duration) {
        final ViewGroup parent = (ViewGroup) target.getParent();
        final float translationY = (parent.getHeight() - target.getTop()) * offset;
        // Move to offscreen.
        target.setTranslationY(translationY);
        // Create animator to animate view to onScreen
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, View.TRANSLATION_Y, 0);
        if (duration > 0) {
            animator.setDuration(duration);
        }
        return animator;
    }

    private static void addAutoGone(ObjectAnimator animator, View target) {
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animation.removeListener(this);
                target.setVisibility(View.GONE);
            }
        });
    }
}
