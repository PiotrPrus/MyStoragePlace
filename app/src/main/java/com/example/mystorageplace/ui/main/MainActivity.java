package com.example.mystorageplace.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.EditText;

import com.example.mystorageplace.R;
import com.example.mystorageplace.base.BaseVMActivity;
import com.example.mystorageplace.databinding.ActivityMainBinding;
import com.example.mystorageplace.ui.main.storage.StorageListAdapter;

public class MainActivity extends BaseVMActivity<MainViewModel, ActivityMainBinding> {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.storageRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        StorageListAdapter adapter = new StorageListAdapter();
        binding.storageRecyclerView.setAdapter(adapter);
        viewModel.setStorageListAdapter(adapter);
        viewModel.openStorageCreationDialog().observe(this, o ->
                showStorageDialog());
    }

    private void showStorageDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText editText = new EditText(this);
        alert.setMessage("Enter your storage name: ");
        alert.setTitle("New storage place");
        alert.setView(editText);

        alert.setPositiveButton("CREATE", (dialogInterface, i) -> {
            String storageName = editText.getText().toString();
            viewModel.writeToFirebase(storageName);
        });
        alert.setNegativeButton("CANCEL", null);
        alert.show();
    }

    @Override
    public void start() {
        super.start();
        binding.setViewmodel(viewModel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.fetchStorages();
    }

    @Override
    public MainViewModel provideViewModel(ViewModelProvider viewModelProvider) {
        return viewModelProvider.get(MainViewModel.class);
    }
}
