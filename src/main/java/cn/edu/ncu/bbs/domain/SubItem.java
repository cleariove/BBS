package cn.edu.ncu.bbs.domain;

public class SubItem {
    private Integer subItemId;//主键

    private String subItemName;//子栏目名

    private String subItemDescription;//子栏目描述

    private Integer manager;//子栏目管理

    private Integer itemId;//所属栏目id

    public Integer getSubItemId() {
        return subItemId;
    }

    public void setSubItemId(Integer subItemId) {
        this.subItemId = subItemId;
    }

    public String getSubItemName() {
        return subItemName;
    }

    public void setSubItemName(String subItemName) {
        this.subItemName = subItemName == null ? null : subItemName.trim();
    }

    public String getSubItemDescription() {
        return subItemDescription;
    }

    public void setSubItemDescription(String subItemDescription) {
        this.subItemDescription = subItemDescription == null ? null : subItemDescription.trim();
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}