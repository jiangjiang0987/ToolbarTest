package com.qingtai.qingtai.toolbartest;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

public class Main2Activity extends AppCompatActivity {

    private Toolbar mtoolbar;
    private ListView listView;
    private int mTouchSlop;
    private ObjectAnimator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }
    public void initView(){
        mtoolbar = (Toolbar)findViewById(R.id.toolbar1);
        listView = (ListView)findViewById(R.id.lv);
//        setSupportActionBar(mtoolbar);
        View header = new View(this);
        header.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,(int)getResources().getDimension(R.dimen.abc_action_bar_default_height_material)));
        listView.addHeaderView(header);
        String[] str = new String []{"1","2","2","3","3","1","2","2","3","3","1","2","2","3","3"};
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,str));


        //获得TouchSlop
        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        //设置监听
        listView.setOnTouchListener(myTouchListener);


    }
    View.OnTouchListener myTouchListener = new View.OnTouchListener() {

        public boolean mShow;
        public int direction;
        public float mCurrentY;
        public float mFirstY;

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()){
                case MotionEvent.ACTION_DOWN:
                    mFirstY = motionEvent.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    mCurrentY = motionEvent.getY();
                    if(mCurrentY - mFirstY >mTouchSlop){
                        direction = 0;
                    }
                    else if(mFirstY - mCurrentY > mTouchSlop){
                        direction = 1;
                    }
                    if(direction == 1){
                        if(mShow){
                            toolbarAnim(0);
                            mShow = !mShow;
                        }
                    }else if(direction == 0){
                        if(!mShow){
                            toolbarAnim(1);
                            mShow = !mShow;
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return false;
        }

    };
    private void toolbarAnim(int flag){
        if(mAnimator != null && mAnimator.isRunning()){
            mAnimator.cancel();
        }
        if(flag == 0){
            mAnimator = ObjectAnimator.ofFloat(mtoolbar,"translationY",-mtoolbar.getHeight());
//            mAnimator = ObjectAnimator.ofFloat(mtoolbar,"translationY",mtoolbar.getTranslationY());

        }else {
            mAnimator = ObjectAnimator.ofFloat(mtoolbar,"translationY",-mtoolbar.getHeight(),0);
        }
        mAnimator.start();
    }
}
