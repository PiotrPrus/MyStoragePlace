package com.example.mystorageplace;

import com.example.mystorageplace.di.AppComponent;
import com.example.mystorageplace.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MyStoragePlaceApp extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
         AppComponent appComponent = DaggerAppComponent.builder()
                 .application(this)
                 .build();
         appComponent.inject(this);
         return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //TODO: initialize Fabric here
    }
}
