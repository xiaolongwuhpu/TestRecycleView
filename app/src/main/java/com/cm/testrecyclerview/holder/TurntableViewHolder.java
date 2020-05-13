package com.cm.testrecyclerview.holder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cm.testrecyclerview.R;

/**
 * @author wj
 * @time 2020/5/12 20:49
 * @描述
 */
public class TurntableViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;

    public TurntableViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.item_turntable_image);
    }

   public void bindData(int res) {
        imageView.setImageResource(res);
    }
}
