
package com.cm.testrecyclerview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.cm.testrecyclerview.R;
import com.cm.testrecyclerview.bean.MultipleTypeDataBean;
import com.cm.testrecyclerview.holder.GroupViewHolder;
import com.cm.testrecyclerview.holder.HeaderViewHolder;
import com.cm.testrecyclerview.holder.TurntableViewHolder;

import java.util.List;

public class MultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ITEM_TYPE_HEADER = 1;
    public static final int ITEM_TYPE_GROUP = 2;
    public static final int ITEM_TYPE_CONTENT = 3;
    private Context mContext;
    private List<MultipleTypeDataBean> list;

    public MultiTypeAdapter(Context context, List<MultipleTypeDataBean> pics) {
        this.mContext = context;
        this.list = pics;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case ITEM_TYPE_HEADER:
                View header = LayoutInflater.from(mContext).inflate(R.layout.item_header, parent, false);
                log("onCreateViewHolder___  header");
                return new HeaderViewHolder(header);
            case ITEM_TYPE_GROUP:
                View group = LayoutInflater.from(mContext).inflate(R.layout.item_group, parent, false);
                log("onCreateViewHolder___  group");
                return new GroupViewHolder(group);
            default:
                log("onCreateViewHolder___  content");
                View content = LayoutInflater.from(mContext).inflate(R.layout.item_content, parent, false);
                return new TurntableViewHolder(content);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder holder1 = (HeaderViewHolder) holder;
            log("onBindViewHolder header");
        } else if (holder instanceof GroupViewHolder) {
            GroupViewHolder holder2 = (GroupViewHolder) holder;
            log("onBindViewHolder group");
        } else if (holder instanceof TurntableViewHolder) {
            log("onBindViewHolder content");
            TurntableViewHolder holder3 = (TurntableViewHolder) holder;
            holder3.bindData(list.get(position).resId);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    //取多个item的每行占用个数的最小公倍数，
                    //比如item1一行2个，item2一行3个，item3一行1个，就取6
                    //他们对应的return 3，return 2，return 6
                    if (ITEM_TYPE_HEADER == getItemViewType(position)) {
                        log("getSpanSize    header");
                        return 4;
                    } else if (ITEM_TYPE_GROUP == getItemViewType(position)) {
                        log("getSpanSize    group");
                        return 2;
                    } else {
                        log("getSpanSize    content");
                        return 1;
                    }
                }
            });
        }
    }
    private int realItemCount = 0;

    @Override
    public int getItemCount() {
        realItemCount = list.size();
        return realItemCount;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).type;
    }


    private void log(String log){
        Log.e("longwu",log);
    }

}
