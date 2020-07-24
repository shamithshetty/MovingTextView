package com.example.movingtextview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.support.v4.text.HtmlCompat;
import android.support.v7.widget.AppCompatTextView;
import android.text.Html;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Toast;

public class MovingTextView extends AppCompatTextView {
    private CharSequence[] movingtexts;
    private Interpolator mInterpolator;
    private ValueAnimator animator;
    private String StaringValue;
    private int Startingcolor;
    private int Movingcolor;
    private int Duration;
    private boolean bold;

    //contractors
    public MovingTextView(Context context) {
        super(context);
        init();
    }
    public MovingTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }
    //initaolise
    private void init() {
        mInterpolator = new DecelerateInterpolator();
        movingtexts = null;
        StaringValue="";
        Duration=3000;
        Movingcolor=Color.BLACK;
        Startingcolor=Color.BLACK;
        bold=false;
    }

    private void init(Context context, AttributeSet attrs) {
        mInterpolator = new DecelerateInterpolator();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Textview);
        try {
            // getting letterDuration from XML attribute
            StaringValue=typedArray.getString(R.styleable.Textview_startstring);
            movingtexts = typedArray.getTextArray(R.styleable.Textview_movingtext);
            Startingcolor=typedArray.getColor(R.styleable.Textview_startcolor, Color.BLACK);
            Movingcolor=typedArray.getColor(R.styleable.Textview_movingcolor,Color.BLACK);
            Duration=typedArray.getInt(R.styleable.Textview_duration,3000);
            bold=typedArray.getBoolean(R.styleable.Textview_stylebold,false);
        } finally {
            typedArray.recycle();
        }
    }

    //methods

    public boolean isBold() {return bold;}
    public void setBold(boolean bold) {this.bold = bold; }
    public int getStartingcolor() {return Startingcolor;}
    public void setStartingcolor(int startingcolor) {Startingcolor = startingcolor;}
    public int getDuration() {return Duration;}
    public void setDuration(int duration) {Duration = duration;}
    public int getMovingcolor() {return Movingcolor;}
    public void setMovingcolor(int movingcolor) {Movingcolor = movingcolor;}
    private Interpolator getInterpolator(){
        return mInterpolator;
    }
    public void setMovingtexts(String[] text){
        movingtexts=text;
    }
    public void setStaringValue(String start) {
       StaringValue=start;
    }


    //animation
    public void startAnimation(){
        final String startcolor=String.format("#%06X",0xFFFFFF & Startingcolor);
        final String movingcolor=String.format("#%06X",0xFFFFFF & Movingcolor);
        final ValueAnimator animator = ValueAnimator.ofInt(0, movingtexts.length);
        animator.setInterpolator(getInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if((Integer) animator.getAnimatedValue()==movingtexts.length)
                    setText(StaringValue);
                else {
                    if(bold)
                        setText(Html.fromHtml("<b><font color='" + startcolor + "'> " + StaringValue + "</font> </b>" + "<font color='" + movingcolor + "'> " + movingtexts[(Integer) animator.getAnimatedValue()] + "</font> "));
                    else
                        setText(Html.fromHtml("<font color='" + startcolor + "'> " + StaringValue + "</font> " + "<font color='" + movingcolor + "'> " + movingtexts[(Integer) animator.getAnimatedValue()] + "</font> "));

                }
            }
        });
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(Duration);

        if (this.animator != null) {
            this.animator.cancel();
        }
        this.animator = animator;
        animator.start();
    }

    public void stopAnimation(){
       animator.cancel();
    }
}
