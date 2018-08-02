package com.example.mystorageplace.base;

import android.arch.lifecycle.ViewModelProvider;
import android.databinding.ViewDataBinding;

public abstract class BaseVMActivity<VM extends BaseViewModel, VDB extends ViewDataBinding> extends BaseActivity<VDB> {

    protected VM viewModel;

    public abstract VM provideViewModel(ViewModelProvider viewModelProvider);
}
