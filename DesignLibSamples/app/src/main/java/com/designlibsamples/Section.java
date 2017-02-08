package com.designlibsamples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fishy on 2017/2/6.
 */

public class Section {
    String name;
    List<SampleItem> items;
    boolean isPublic = true;

    Section() {

    }

    Section(String name) {
        this.name = name;
    }

    Section(String name, List<SampleItem> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SampleItem> getItems() {
        return items;
    }

    public void setItems(List<SampleItem> items) {
        this.items = items;
    }

    public List<SampleItem> getPublicIitems() {
        if (isPublic) {
            return getItems();
        } else {
            return new ArrayList<>();
        }
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
