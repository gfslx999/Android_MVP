package com.lx.lib_core.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lx.lib_core.mvp.presenter.IPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public
/**
 *@author : 阿森
 *@date : 2020-11-03 09:35
 *@params : 
 *@description:
 */
abstract class BaseFragment<P extends IPresenter> extends Fragment implements IView {

    protected P mPresenter;
    private Unbinder bind;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(bindLayout(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = ButterKnife.bind(this, view);
        initView();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
        if(mPresenter != null) {
            mPresenter.destroy();
            mPresenter = null;
        }
    }
}
