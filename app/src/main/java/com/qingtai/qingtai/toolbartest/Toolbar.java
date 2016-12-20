package com.qingtai.qingtai.toolbartest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/12/20.
 */
public class Toolbar extends RelativeLayout {
    private int mLeftTextColor;
    private Drawable mLeftBackGround;
    private String mLeftText;

    private int mRightTextColor;
    private Drawable mRightBackground;
    private String mRightText;

    private float mTitleTextSize;
    private int mTitleTextColor;
    private String mTitle;

    private Button mLeftButton;
    private Button mRightBUtton;
    private TextView mTitleView;

    private LayoutParams mLeftPArams;
    private LayoutParams mRigthParams;
    private LayoutParams mTitlePArams;

    public Toolbar(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        TypedArray ta = context.obtainStyledAttributes(attributeSet,R.styleable.TopBar);
        mLeftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor,0);
        mLeftBackGround = ta.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText = ta.getString(R.styleable.TopBar_lefttext);

        mRightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
        mRightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor,0);
        mRightText = ta.getString(R.styleable.TopBar_rightText);

        mTitleTextSize = ta.getDimensionPixelSize(R.styleable.TopBar_titleTextSize,10);
        mTitle = ta.getString(R.styleable.TopBar_title);
        mTitleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor,0);
        ta.recycle();

        mLeftButton = new Button(context);
        mRightBUtton = new Button(context);
        mTitleView = new TextView(context);


        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setText(mLeftText);
        mLeftButton.setBackground(mLeftBackGround);

        mRightBUtton.setTextColor(mRightTextColor);
        mRightBUtton.setText(mRightText);
        mRightBUtton.setBackground(mRightBackground);

        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);

        mLeftPArams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        mLeftPArams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(mLeftButton,mLeftPArams);

        mRigthParams = new LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mRigthParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(mRightBUtton,mRigthParams);

        mTitlePArams = new LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mTitlePArams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(mTitleView,mTitlePArams);
    }
}
