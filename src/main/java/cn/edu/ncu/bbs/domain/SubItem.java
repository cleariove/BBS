package cn.edu.ncu.bbs.domain;


public class SubItem
{

  private long subItemId;
  private String subItemName;
  private long itemId;
  private String itemDescription;
  private long manager;


  public long getSubItemId() {
    return subItemId;
  }

  public void setSubItemId(long subItemId) {
    this.subItemId = subItemId;
  }


  public String getSubItemName() {
    return subItemName;
  }

  public void setSubItemName(String subItemName) {
    this.subItemName = subItemName;
  }


  public long getItemId() {
    return itemId;
  }

  public void setItemId(long itemId) {
    this.itemId = itemId;
  }


  public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }


  public long getManager() {
    return manager;
  }

  public void setManager(long manager) {
    this.manager = manager;
  }

}
