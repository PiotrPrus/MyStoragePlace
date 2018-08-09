package com.example.mystorageplace.ui.main.storage;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mystorageplace.R;
import com.example.mystorageplace.data.model.Storage;
import com.example.mystorageplace.databinding.StorageItemBinding;

import java.util.ArrayList;
import java.util.List;

public class StorageListAdapter extends RecyclerView.Adapter<StorageListAdapter.ViewHolder> {

    private List<Storage> storageList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        StorageItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.storage_item, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(storageList.get(position));
    }

    @Override
    public int getItemCount() {
        return storageList.size();
    }

    public void setData(List<Storage> data){
        this.storageList = data;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private final StorageItemBinding binding;
        private StorageViewModel viewModel = new StorageViewModel();

        public ViewHolder(StorageItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Storage storage){
            viewModel.bind(storage);
            binding.setViewModel(viewModel);
        }
    }
}
