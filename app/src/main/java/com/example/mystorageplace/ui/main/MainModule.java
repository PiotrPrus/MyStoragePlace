package com.example.mystorageplace.ui.main;

import android.arch.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainModule {

    @Binds
    @IntoMap
    abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);

}
