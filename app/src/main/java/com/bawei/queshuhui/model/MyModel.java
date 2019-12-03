package com.bawei.queshuhui.model;

import com.bawei.queshuhui.contract.IMyContract;
import com.bawei.queshuhui.util.NetUtil;
import com.google.gson.Gson;

/**
 * @author 阙树辉
 * @description:
 * @date :2019/12/3 10:23
 */
public class MyModel {
    public void getMyData(final IMyContract.IModelCallBack iModelCallBack){
        NetUtil.getInstance().getJson("http://blog.zhaoliang5156.cn/api/mall/mall.json", new NetUtil.MyCallBack() {
            @Override
            public void ongetString(String s) {
                Bean bean = new Gson().fromJson(s, Bean.class);
                iModelCallBack.onMySuccess(bean);
            }

            @Override
            public void Error(Throwable throwable) {
                iModelCallBack.onFailure(throwable);
            }
        });
    }
}
