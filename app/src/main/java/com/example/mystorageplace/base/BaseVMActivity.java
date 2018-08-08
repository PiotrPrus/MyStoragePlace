package com.example.mystorageplace.base;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.ViewDataBinding;

public abstract class BaseVMActivity<VM extends BaseViewModel, VDB extends ViewDataBinding> extends BaseActivity<VDB> {

    protected VM viewModel;

    public abstract VM provideViewModel(ViewModelProvider viewModelProvider);

    @Override
    public void start() {
        super.start();
        viewModel = provideViewModel(ViewModelProviders.of(this));
    }
}
