package com.cm.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.cm.testrecyclerview.adapter.MultiTypeAdapter;
import com.cm.testrecyclerview.bean.DataHelp;
import com.cm.testrecyclerview.bean.MultipleTypeDataBean;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler);


        List<MultipleTypeDataBean>  list = DataHelp.getDataForMultiple();

        mAdapter = new MultiTypeAdapter(this, list);
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(10));
        GridLayoutManager gll = new GridLayoutManager(this, 4, RecyclerView.VERTICAL, false);
        gll.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            //取多个item的每行占用个数的最小公倍数，
            @Override
            public int getSpanSize(int position) { //返回值是  最小公倍数除以每行占用的item
                if (MultiTypeAdapter.ITEM_TYPE_HEADER == mAdapter.getItemViewType(position)) {
                    log("onCreate getSpanSize    header");
                    return 4;//此item占用一行
                } else if (MultiTypeAdapter.ITEM_TYPE_GROUP == mAdapter.getItemViewType(position)) {
                    log("onCreate getSpanSize    group");
                    return 4;//此item占用一行
                } else {
                    log("onCreate getSpanSize    content");
                    return 1;//此item占用一行的1/4
                }
            }

            @Override
            public int getSpanIndex(int position, int spanCount) {
                return super.getSpanIndex(position, spanCount);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(gll);
    }

    private void log(String log){
        Log.e("longwu",log);
    }

}
