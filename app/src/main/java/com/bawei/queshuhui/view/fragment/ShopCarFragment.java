package com.bawei.queshuhui.view.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.bawei.queshuhui.R;
import com.bawei.queshuhui.base.BaseFragment;
import com.bawei.queshuhui.contract.IMyContract;
import com.bawei.queshuhui.model.Bean;
import com.bawei.queshuhui.presenter.MyPresenter;
import com.bawei.queshuhui.view.adapter.Myadapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopCarFragment extends BaseFragment implements IMyContract.IVew {

    private Button button;
    private GridView gridView;

    @Override
    protected void initView(View view) {
        button = view.findViewById(R.id.btn);
        gridView = view.findViewById(R.id.gv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeFragment.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_shop_car;
    }

    @Override
    protected void initData() {
        MyPresenter myPresenter = new MyPresenter();
        myPresenter.getMyData(this);
    }

    @Override
    public void onMySuccess(Bean bean) {
        Toast.makeText(getContext(),"请求成功",Toast.LENGTH_SHORT);
        List<Bean.ShopGridDataBean> shopGridData = bean.getShopGridData();
        Myadapter myadapter = new Myadapter(shopGridData);
        gridView.setAdapter(myadapter);
    }

    @Override
    public void onFailure(Throwable throwable) {
        Toast.makeText(getContext(),"请求失败",Toast.LENGTH_SHORT);
    }
}
