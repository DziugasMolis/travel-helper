package com.travel.helper.model;

public class MandatoryItem {
    private MandatoryItemType type;
    private Integer count;

    public MandatoryItem(MandatoryItemType type, Integer count) {
        this.type = type;
        this.count = count;
    }

    public MandatoryItemType getType() {
        return type;
    }

    public void setType(MandatoryItemType type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
