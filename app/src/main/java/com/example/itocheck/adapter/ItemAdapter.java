package com.example.itocheck.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.itocheck.databinding.ItemLayoutBinding;
import com.example.itocheck.model.Apartment;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Apartment> apartmentList;
    private PassElementSelected mListener;


    public ItemAdapter(List<Apartment> apartmentList, PassElementSelected mListener) {
        this.apartmentList = apartmentList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLayoutBinding mBinding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ItemViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        Apartment apartment = apartmentList.get(position);
        holder.tv1.setText(apartment.getBuildingName());
        holder.tv2.setText(apartment.getUnitId());
        holder.tv3.setText(apartment.getAddress());
        Glide.with(holder.itemView.getContext()).load(apartment.getUrlImageBuilding()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return apartmentList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView img;
        private TextView tv1, tv2, tv3;

        public ItemViewHolder(@NonNull ItemLayoutBinding mBinding) {
            super(mBinding.getRoot());
            img = mBinding.imgEdi;
            tv1 = mBinding.tvNombreEdi;
            tv2 = mBinding.tvNumeroEdi;
            tv3 = mBinding.tvDirecc;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        int  p = getLayoutPosition();
        Apartment element = apartmentList.get(p);
        mListener.passElement(element);
        }
    }

    public interface PassElementSelected {
        void passElement(Apartment apartment);
    }


}
