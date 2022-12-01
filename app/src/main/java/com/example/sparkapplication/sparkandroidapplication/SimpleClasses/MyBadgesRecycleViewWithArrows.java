package com.example.sparkapplication.sparkandroidapplication.SimpleClasses;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE;

import com.example.sparkapplication.R;

public class MyBadgesRecycleViewWithArrows extends RelativeLayout implements View.OnClickListener {
    RecyclerView recyclerView;
    AppCompatImageView leftArrow;
    AppCompatImageView rightArrow;

    //To track the position of the current visible item .for navigation with arrows
    int currentVisibleItem = 0;
    //To check whether user scrolled the recycler view or used arrows to navigate.
    private boolean programaticallyScrolled;
    //LinearLayoutManagerWithSmoothScroller linearLayoutManagerWithSmoothScroller;
    private LinearLayoutManager linearLayoutManager;

    public MyBadgesRecycleViewWithArrows(Context context) {
        super(context);
        init();
    }

    public MyBadgesRecycleViewWithArrows(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyBadgesRecycleViewWithArrows(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivLeftArrow:
                programaticallyScrolled = true;
                //Decrement current visible item position to navigate back to previous item
                currentVisibleItem-=3;
                handleWritingViewNavigationArrows(true);
                break;
            case R.id.ivRightArrow:
                programaticallyScrolled = true;
                //Increment current visible item position to navigate next item
                currentVisibleItem+=3;
                handleWritingViewNavigationArrows(true);
                break;
            default:
                break;
        }
    }
    private void init() {
        inflate(getContext(), R.layout.my_badges_recycleview, this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        leftArrow = (AppCompatImageView) findViewById(R.id.ivLeftArrow);
        rightArrow = (AppCompatImageView) findViewById(R.id.ivRightArrow);
        linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getContext(), R.dimen.recyclerview_item_offset);
        recyclerView.addItemDecoration(itemDecoration);
        leftArrow.setOnClickListener(this);
        rightArrow.setOnClickListener(this);
        SnapHelper snapHelper = new StartSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {
                    case SCROLL_STATE_DRAGGING:
                        //Indicated that user scrolled.
                        programaticallyScrolled = false;
                        break;
                    case SCROLL_STATE_IDLE:
                        if (!programaticallyScrolled) {
                            currentVisibleItem = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                            handleWritingViewNavigationArrows(false);
                        }
                        break;
                    default:
                        break;
                }
            }
        });
    }
    private void handleWritingViewNavigationArrows(boolean scroll) {
        if (currentVisibleItem == (recyclerView.getAdapter().getItemCount() - 1)) {
            rightArrow.setVisibility(View.GONE);
            leftArrow.setVisibility(View.VISIBLE);
        } else if (currentVisibleItem != 0) {
            rightArrow.setVisibility(View.VISIBLE);
            leftArrow.setVisibility(View.VISIBLE);
        } else if (currentVisibleItem == 0) {
            leftArrow.setVisibility(View.GONE);
            rightArrow.setVisibility(View.VISIBLE);
        }
        if (scroll) {
            recyclerView.smoothScrollToPosition(currentVisibleItem);
        }
    }
    public void setAdapter(RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
