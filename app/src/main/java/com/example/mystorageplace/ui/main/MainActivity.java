package com.example.mystorageplace.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.mystorageplace.R;
import com.example.mystorageplace.base.BaseVMActivity;
import com.example.mystorageplace.databinding.ActivityMainBinding;

public class MainActivity extends BaseVMActivity<MainViewModel, ActivityMainBinding> {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.storageRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
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
