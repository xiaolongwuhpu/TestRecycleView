package com.cm.testrecyclerview.bean;

import java.util.List;

/**
 * @author wj
 * @time 2020/5/12 20:25
 * @描述
 */
public class MultipleTypeDataBean {

    public int type;
    public int resId;

    public MultipleTypeDataBean(int type) {
        this.type = type;
    }

    public MultipleTypeDataBean(int type, int resId) {
        this.type = type;
        this.resId = resId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
