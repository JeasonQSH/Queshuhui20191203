package com.bawei.queshuhui.presenter;

import com.bawei.queshuhui.contract.IMyContract;
import com.bawei.queshuhui.model.Bean;
import com.bawei.queshuhui.model.MyModel;

/**
 * @author 阙树辉
 * @description:
 * @date :2019/12/3 10:28
 */
public class MyPresenter {
    public void getMyData(final IMyContract.IVew iVew){
        MyModel myModel = new MyModel();
        myModel.getMyData(new IMyContract.IModelCallBack() {
            @Override
            public void onMySuccess(Bean bean) {
                iVew.onMySuccess(bean);
            }

            @Override
            public void onFailure(Throwable throwable) {
                iVew.onFailure(throwable);
            }
        });
    }
}
