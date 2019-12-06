package cn.edu.ncu.bbs.domain;


public class Item {

  private long itemId;
  private String itemName;
  private String itemDescription;
  private long manager;


  public long getItemId() {
    return itemId;
  }

  public void setItemId(long itemId) {
    this.itemId = itemId;
  }


  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
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
