package com.example.mystorageplace.di;

import android.app.Application;

import com.example.mystorageplace.MyStoragePlaceApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application app);

        AppComponent build();
    }

    void inject(MyStoragePlaceApp app);
}
