package com.example.mystorageplace.ui.main;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.mystorageplace.base.BaseViewModel;
import com.example.mystorageplace.data.model.Storage;
import com.example.mystorageplace.ui.main.storage.StorageListAdapter;
import com.example.mystorageplace.utils.SingleLiveEvent;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainViewModel extends BaseViewModel {

    private static final String TAG = MainViewModel.class.getSimpleName();

    private DatabaseReference mDatabaseReference;
    private StorageListAdapter storageListAdapter;
    private SingleLiveEvent _openStorageCreationDialog = new SingleLiveEvent();
    private ChildEventListener mChildEventListener;

    public LiveData openStorageCreationDialog() {
        return _openStorageCreationDialog;
    }

    public MainViewModel() {
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference().child("storage-places");
        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                GenericTypeIndicator<HashMap<Storage>> genericTypeIndicator = new GenericTypeIndicator<List<Storage>>(){};
//                List<Storage> storageList = dataSnapshot.getValue(genericTypeIndicator);
//                storageListAdapter.setData(storageList);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
    }

    public void setStorageListAdapter(StorageListAdapter storageListAdapter) {
        this.storageListAdapter = storageListAdapter;
    }

    public void fetchStorages() {
        mDatabaseReference.addChildEventListener(mChildEventListener);
    }

    public void addNewStorage() {
        openDialog();
    }

    private void openDialog() {
        _openStorageCreationDialog.call();
    }

    public void writeToFirebase(String storageName){
        Storage storage = new Storage(storageName, new ArrayList<>());
        mDatabaseReference.push().setValue(storage);
    }
}
