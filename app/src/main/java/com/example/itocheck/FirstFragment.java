package com.example.itocheck;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itocheck.adapter.Data;
import com.example.itocheck.adapter.ItemAdapter;
import com.example.itocheck.databinding.FragmentFirstBinding;
import com.example.itocheck.model.Apartment;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements ItemAdapter.PassElementSelected{

    private FragmentFirstBinding mBinding;
    private RecyclerView mRecyclerView;
    private ItemAdapter mItemAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment

        mBinding = FragmentFirstBinding.inflate(inflater,container,false);
        mRecyclerView = mBinding.rvItem;
        mItemAdapter = new ItemAdapter(Data.apartmentList(), this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mItemAdapter);

        return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void passElement(Apartment apartment) {
        Bundle b = new Bundle();
        b.putString("edi", apartment.getBuildingName());
        b.putString("num", apartment.getUnitId());
        b.putString("dir", apartment.getAddress());
        b.putString("url", apartment.getUrlImageBuilding());
        b.putInt("id",apartment.getId());
        Navigation.findNavController(mBinding.getRoot()).navigate(R.id.action_FirstFragment_to_SecondFragment,b);

    }
}