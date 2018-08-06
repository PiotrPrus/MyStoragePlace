package com.example.mystorageplace.data.model;

import java.util.List;

public class Storage {

    private String storageName;
    private List<Box> boxList;

    public Storage(String storageName, List<Box> boxList) {
        this.storageName = storageName;
        this.boxList = boxList;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public List<Box> getBoxList() {
        return boxList;
    }

    public void setBoxList(List<Box> boxList) {
        this.boxList = boxList;
    }

    class Box {
        private int boxNumber;
        private String boxName;
        private List<StorageItem> storageItemList;
    }

    class StorageItem {
        private String itemName;
        private String itemDescription;
        private String itemImageUrl;
        private int itemQuantity;
    }
}
