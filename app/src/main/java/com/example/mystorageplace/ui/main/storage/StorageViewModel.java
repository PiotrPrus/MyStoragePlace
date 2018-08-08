package com.example.mystorageplace.ui.main.storage;

import android.arch.lifecycle.MutableLiveData;

import com.example.mystorageplace.base.BaseViewModel;
import com.example.mystorageplace.data.model.Storage;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StorageViewModel extends BaseViewModel {
    private MutableLiveData<String> storageTitle = new MutableLiveData<>();

    public void bind(Storage storage) {
        storageTitle.setValue(storage.getStorageName());
    }

    private MutableLiveData<String> getStorageTitle(){
        return storageTitle;
    }
}
