package com.cm.testrecyclerview.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cm.testrecyclerview.R;

/**
 * @author wj
 * @time 2020/5/12 20:49
 * @描述
 */
public class HeaderViewHolder extends RecyclerView.ViewHolder {

    TextView imageView;

    public HeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.text_title);
    }

    void bindData(int res) {
//        imageView.setImageResource(res);
    }
}
