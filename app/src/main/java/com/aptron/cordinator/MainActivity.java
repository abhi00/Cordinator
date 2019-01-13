package com.aptron.cordinator;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements AppBarLayout.OnOffsetChangedListener{
   RecyclerView recyclerView;
    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR  = 0.6f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS     = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION              = 200;

    private boolean mIsTheTitleVisible          = false;
    private boolean mIsTheTitleContainerVisible = true;
    private LinearLayout mTitleContainer;
    private TextView mTitle;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    private static final String USER_TYPE  = "type";
    int[] img_parent ={R.drawable.homework,R.drawable.caricul_two,R.drawable.news,R.drawable.calendar,R.drawable.fee,R.drawable.debit_card,R.drawable.fee_due,R.drawable.news,R.drawable.list,R.drawable.school_bus,R.drawable.calendar,R.drawable.analytics};
    int[] img_teacher ={R.drawable.add,R.drawable.homework,R.drawable.calendar,R.drawable.caricul_two,R.drawable.fee,R.drawable.list,R.drawable.list,R.drawable.meeting};
    int[] img_admin={R.drawable.add,R.drawable.presentation,R.drawable.student,R.drawable.broadcast,R.drawable.meeting};

    RecyclerViewClickListener listener = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recy);

    // Bundle  bundle =  getIntent().getExtras();
   //String type =  bundle.getString(USER_TYPE);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MyImageAdapter(this,getResources().getStringArray(R.array.dashboard),listener,img_parent));


    /* switch (type)
        {
            case "admin":
              listener  = (view, position) -> {
                    Toast.makeText(MainActivity.this, "Position " + position, Toast.LENGTH_SHORT).show();
                };
                recyclerView.setAdapter(new MyImageAdapter(this,getResources().getStringArray(R.array.dashboard_admin),listener,img_admin));

                break;

            case "parent":
                 listener = (view, position) -> {
                    Toast.makeText(MainActivity.this, "Position " + position, Toast.LENGTH_SHORT).show();
                };
                recyclerView.setAdapter(new MyImageAdapter(this,getResources().getStringArray(R.array.dashboard),listener,img_parent));

                break;

            case "teacher":
               listener = (view, position) -> {
                    Toast.makeText(MainActivity.this, "Position " + position, Toast.LENGTH_SHORT).show();
                };
                recyclerView.setAdapter(new MyImageAdapter(this,getResources().getStringArray(R.array.dashboard_teacher),listener,img_teacher));

                break;


        }
        */
      /* recyclerView.setAdapter(new MyImageAdapter(this,getResources().getStringArray(R.array.dashboard_admin),img_admin));



    if(type =="parent")
   {

       recyclerView.setAdapter(new MyImageAdapter(this,getResources().getStringArray(R.array.dashboard_parent),img_parent));




   }

   else if(type =="teacher")
        {


            recyclerView.setAdapter(new MyImageAdapter(this,getResources().getStringArray(R.array.dashboard_teacher),img_teacher));




        }
*/





        bindActivity();

       mAppBarLayout.addOnOffsetChangedListener(this);

        mToolbar.inflateMenu(R.menu.menu_main);
        startAlphaAnimation(mTitle, 0, View.INVISIBLE);

    }
    private void bindActivity() {
        mToolbar        = findViewById(R.id.toolbar);
        mTitle          =  findViewById(R.id.title);
        mTitleContainer = findViewById(R.id.linear);
        mAppBarLayout   = findViewById(R.id.appbar);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if(!mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if(mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    public static void startAlphaAnimation (View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }
}