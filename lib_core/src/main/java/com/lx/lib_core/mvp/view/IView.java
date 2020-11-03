package com.lx.lib_core.mvp.view;

import androidx.annotation.LayoutRes;

public
/**
 *@author : 阿森
 *@date : 2020-11-03 09:32
 *@params : 
 *@description:
 */
interface IView {
    @LayoutRes
    int bindLayout();

    void initView();

    void showToast(String msg);
}
