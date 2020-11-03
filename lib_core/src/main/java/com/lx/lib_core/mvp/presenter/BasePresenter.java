package com.lx.lib_core.mvp.presenter;

import com.lx.lib_core.mvp.model.IModel;
import com.lx.lib_core.mvp.view.IView;

public
/**
 *@author : 阿森
 *@date : 2020-11-03 09:33
 *@params : 
 *@description:
 */
class BasePresenter<M extends IModel,V extends IView> implements IPresenter {

    protected M mModel;
    protected V mView;

    public BasePresenter(M mModel, V mView) {
        this.mModel = mModel;
        this.mView = mView;
    }

    @Override
    public void destroy() {
        if(mModel != null) {
            mModel.destroy();
            mModel = null;
        }
    }
}
