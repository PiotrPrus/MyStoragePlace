package com.example.mystorageplace.data.model;

import java.util.List;

public class Storage {

    private String storageName;
    private List<Box> boxList;

    public Storage() {
    }

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

        public Box() {
        }

        public Box(int boxNumber, String boxName, List<StorageItem> storageItemList) {
            this.boxNumber = boxNumber;
            this.boxName = boxName;
            this.storageItemList = storageItemList;
        }

        public int getBoxNumber() {
            return boxNumber;
        }

        public void setBoxNumber(int boxNumber) {
            this.boxNumber = boxNumber;
        }

        public String getBoxName() {
            return boxName;
        }

        public void setBoxName(String boxName) {
            this.boxName = boxName;
        }

        public List<StorageItem> getStorageItemList() {
            return storageItemList;
        }

        public void setStorageItemList(List<StorageItem> storageItemList) {
            this.storageItemList = storageItemList;
        }
    }

    class StorageItem {
        private String itemName;
        private String itemDescription;
        private String itemImageUrl;
        private Double itemQuantity;

        public StorageItem() {
        }

        public StorageItem(String itemName, String itemDescription, String itemImageUrl, Double itemQuantity) {
            this.itemName = itemName;
            this.itemDescription = itemDescription;
            this.itemImageUrl = itemImageUrl;
            this.itemQuantity = itemQuantity;
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

        public String getItemImageUrl() {
            return itemImageUrl;
        }

        public void setItemImageUrl(String itemImageUrl) {
            this.itemImageUrl = itemImageUrl;
        }

        public Double getItemQuantity() {
            return itemQuantity;
        }

        public void setItemQuantity(Double itemQuantity) {
            this.itemQuantity = itemQuantity;
        }
    }
}
