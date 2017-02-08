package com.designlibsamples;

/**
 * Created by Fishy on 2017/2/6.
 */

public class SampleItem {
    Class className;
    String content;

    SampleItem() {

    }

    SampleItem(Class className, String content) {
        this.className = className;
        this.content = content;
    }

    public Class getClassName() {
        return className;
    }

    public void setClassName(Class className) {
        this.className = className;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
