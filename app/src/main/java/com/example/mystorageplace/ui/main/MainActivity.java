package com.example.mystorageplace.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mystorageplace.R;
import com.example.mystorageplace.base.BaseVMActivity;

public class MainActivity extends BaseVMActivity<MainViewModel, ActivityMainBinding> {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public MainViewModel provideViewModel(ViewModelProvider viewModelProvider) {
        return viewModelProvider.get(MainViewModel.class);
    }
}
