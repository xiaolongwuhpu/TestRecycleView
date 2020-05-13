package com.cm.testrecyclerview.bean;

import com.cm.testrecyclerview.R;
import com.cm.testrecyclerview.adapter.MultiTypeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wj
 * @time 2020/5/12 20:27
 * @描述
 */
public class DataHelp {

    public static List<MultipleTypeDataBean> getDataForMultiple() {
        List<MultipleTypeDataBean> list = new ArrayList<>();
        /**
         * header 占位数据
         */
        list.add(new MultipleTypeDataBean(MultiTypeAdapter.ITEM_TYPE_HEADER));
        /**
         * group 占位数据
         */
        list.add(new MultipleTypeDataBean(MultiTypeAdapter.ITEM_TYPE_GROUP));

        /**
         * content 模拟后台拉取的数据,转换成adapter需要的数据
         */
        int[] pics = {R.mipmap.pic1, R.mipmap.pic2, R.mipmap.pic3, R.mipmap.pic4,
                R.mipmap.pic5, R.mipmap.pic6, R.mipmap.pic7, R.mipmap.pic8, R.mipmap.pic9,
                R.mipmap.pic10, R.mipmap.pic11};
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < pics.length; i++) {
            for (int j = 0; j < pics.length; j++) {
                data.add(pics[j]);
                list.add(new MultipleTypeDataBean(MultiTypeAdapter.ITEM_TYPE_CONTENT, pics[j]));
            }
        }
        return list;
    }
}
