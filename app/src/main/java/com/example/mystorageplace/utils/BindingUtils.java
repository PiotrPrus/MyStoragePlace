package com.example.mystorageplace.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

public class BindingUtils {

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView view, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        view.setAdapter(adapter);
    }
}
