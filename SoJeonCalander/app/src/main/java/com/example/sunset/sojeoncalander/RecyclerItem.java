package com.example.sunset.sojeoncalander;

/**
 * Created by SunSet on 2016-11-15.
 */

public class RecyclerItem {
    private String title;
    private String desc;

    public RecyclerItem(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
