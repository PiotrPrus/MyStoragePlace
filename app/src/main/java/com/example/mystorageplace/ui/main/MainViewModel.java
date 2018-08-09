package com.example.mystorageplace.ui.main;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mystorageplace.base.BaseViewModel;
import com.example.mystorageplace.data.model.Storage;
import com.example.mystorageplace.ui.main.storage.StorageListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends BaseViewModel {

    private static final String TAG = MainViewModel.class.getSimpleName();

    private DatabaseReference mDatabase;
    public StorageListAdapter storageListAdapter = new StorageListAdapter();

    public MainViewModel() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public StorageListAdapter getStorageListAdapter() {
        return storageListAdapter;
    }

    public void setStorageListAdapter(StorageListAdapter storageListAdapter) {
        this.storageListAdapter = storageListAdapter;
    }

    public void fetchStorages() {
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    storageListAdapter.setData(toStorageList(dataSnapshot));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, "Fetching storage list failed: "  + databaseError);
            }
        });
    }

    private List<Storage> toStorageList(DataSnapshot dataSnapshot) {
        List<Storage> storageList = new ArrayList<>();
        for (DataSnapshot child : dataSnapshot.getChildren()) {
            Storage storage = child.getValue(Storage.class);
            storageList.add(storage);
        }
        return storageList;
    }

    public void addNewStorage() {
        writeTestData();
    }

    private void writeTestData() {
        Storage storage = new Storage("piwnica", new ArrayList<>());
        mDatabase.child("storage-places").setValue(storage);
    }

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView view, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        view.setAdapter(adapter);
    }
}
