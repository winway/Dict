package com.hui.dict.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hui.dict.R;
import com.hui.dict.bean.PinyinAndBushouWordBean;

import java.util.List;

/**
 * @PackageName: com.hui.dict.adapter
 * @ClassName: WordGridAdapter
 * @Author: winwa
 * @Date: 2023/2/20 8:06
 * @Description:
 **/
public class WordGridAdapter extends BaseAdapter {
    private Context mContext;
    private List<PinyinAndBushouWordBean.ResultBean.ListBean> mData;

    public WordGridAdapter(Context context, List<PinyinAndBushouWordBean.ResultBean.ListBean> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.gvitem_word, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.mWordTV.setText(mData.get(i).getZi());

        return view;
    }

    class ViewHolder {
        TextView mWordTV;

        public ViewHolder(View view) {
            mWordTV = view.findViewById(R.id.gvitem_word_tv);
        }
    }
}
