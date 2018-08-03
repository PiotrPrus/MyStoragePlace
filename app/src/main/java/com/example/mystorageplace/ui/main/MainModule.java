package com.example.mystorageplace.ui.main;

import android.arch.lifecycle.ViewModel;

import com.example.mystorageplace.di.annotation.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);

}
