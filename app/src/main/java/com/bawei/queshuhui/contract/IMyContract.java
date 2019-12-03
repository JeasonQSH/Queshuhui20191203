package com.bawei.queshuhui.contract;

import com.bawei.queshuhui.model.Bean;

/**
 * @author 阙树辉
 * @description:
 * @date :2019/12/3 10:20
 */
public interface IMyContract {
    interface IVew{
        void onMySuccess(Bean bean);
        void onFailure(Throwable throwable);
    }
    interface IModelCallBack{
        void onMySuccess(Bean bean);
        void onFailure(Throwable throwable);
    }

}
