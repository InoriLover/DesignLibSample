package com.designlibsamples.toolbar;

/**
 * Created by Fishy on 2017/2/8.
 */

public class MenuItem {
    int resourceId;
    String content;

    public MenuItem(int resourceId, String content) {
        this.resourceId = resourceId;
        this.content = content;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
