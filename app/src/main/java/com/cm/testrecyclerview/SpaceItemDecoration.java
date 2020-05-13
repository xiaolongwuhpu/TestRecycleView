package com.cm.testrecyclerview;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author wj
 * @time 2020/5/8 16:35
 * @描述
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int space;  //位移间距

    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int pos = parent.getChildAdapterPosition(view)-2;
        if (pos < 0) {
            return;
        }
        outRect.left = space;
        outRect.top = space;
        outRect.right = space;
        outRect.bottom = space;


//        if (pos < 4) {
//            outRect.top = 0;
//        }
//
//        if (pos % 4 == 0) {
//            outRect.left = 0;
//        } else if (pos % 4 == 3) {
//            outRect.right = 0;
//        }

//        if (pos == 0) {
//            outRect.left = 0;
//            outRect.top = 0;
//        } else if (pos == 1) {
//            outRect.right = 0;
//            outRect.top = 0;
//        }
//
//        if (pos % 2 == 0) {
//            outRect.left = 0;
//        } else {
//            outRect.right = 0;
//        }




//        if (parent.getChildLayoutPosition(view) % 2 == 0) {

//        outRect.set(space, space, space, space);

//        } else {
//
//            outRect.set(0, 0, space, 0);
//        }

//        if (parent.getChildAdapterPosition(view) %2 == 0) {
//            outRect.left = 0; //第一列左边贴边
//        } else {
//            if (parent.getChildAdapterPosition(view) %2 == 1) {
//                outRect.left = space;//第二列移动一个位移间距
//            } else {
//                outRect.left = space * 2;//由于第二列已经移动了一个间距，所以第三列要移动两个位移间距就能右边贴边，且item间距相等
//            }
//        }
//
//        if (parent.getChildAdapterPosition(view) > 3) {
//            outRect.top = 10;
//        } else {
//            outRect.top = 0;
//        }
    }

}