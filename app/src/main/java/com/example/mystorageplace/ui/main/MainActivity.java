package com.example.mystorageplace.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

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
