package com.bawei.queshuhui.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.queshuhui.R;
import com.bawei.queshuhui.model.Bean;
import com.bawei.queshuhui.util.NetUtil;

import java.util.List;

/**
 * @author 阙树辉
 * @description:
 * @date :2019/12/3 10:37
 */
public class Myadapter extends BaseAdapter {
    private List<Bean.ShopGridDataBean> shopGridData;

    public Myadapter(List<Bean.ShopGridDataBean> shopGridData) {
        this.shopGridData = shopGridData;
    }

    @Override
    public int getCount() {
        return shopGridData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Viewholder viewholder = null;
        if(view==null){
            view = View.inflate(viewGroup.getContext(), R.layout.item,null);
            viewholder = new Viewholder();
            viewholder.imageView = view.findViewById(R.id.imageview);
            viewholder.textView = view.findViewById(R.id.text);
            viewholder.textView = view.findViewById(R.id.price);
            view.setTag(viewholder);
        }else{
            viewholder = (Viewholder) view.getTag();
        }
        Bean.ShopGridDataBean shopGridDataBean = shopGridData.get(i);
        viewholder.textView.setText(shopGridDataBean.getTitle());

        NetUtil.getInstance().getPhoto(shopGridDataBean.getImageurl(),viewholder.imageView);
        return view;
    }
    class Viewholder{
        TextView textView;
        TextView textView1;
        ImageView imageView;
    }
}
