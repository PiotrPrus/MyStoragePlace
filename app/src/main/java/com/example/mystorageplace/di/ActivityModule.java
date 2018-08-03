package com.example.mystorageplace.di;

import com.example.mystorageplace.ui.main.MainActivity;
import com.example.mystorageplace.ui.main.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity bindMainActivity();
}
