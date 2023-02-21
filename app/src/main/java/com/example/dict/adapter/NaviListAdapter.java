package com.example.dict.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.dict.R;
import com.example.dict.bean.PinyinAndBushouMappingBean;

import java.util.List;

/**
 * @PackageName: com.example.dict.adapter
 * @ClassName: NaviListAdapter
 * @Author: winwa
 * @Date: 2023/2/19 9:38
 * @Description:
 **/
public class NaviListAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private String mType;
    private List<String> mGroupData;
    private List<List<PinyinAndBushouMappingBean.ResultBean>> mChildData;

    private int mSelectedGroupPos = 0;
    private int mSelectedChildPos = 0;

    public NaviListAdapter(Context context, String type, List<String> parentData, List<List<PinyinAndBushouMappingBean.ResultBean>> childData) {
        mContext = context;
        mType = type;
        mGroupData = parentData;
        mChildData = childData;
    }

    public void setSelectedGroupPos(int selectedGroupPos) {
        mSelectedGroupPos = selectedGroupPos;
    }

    public void setSelectedChildPos(int selectedChildPos) {
        mSelectedChildPos = selectedChildPos;
    }

    @Override
    public int getGroupCount() {
        return mGroupData.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mChildData.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return mGroupData.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return mChildData.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.elvitem_group_navigate, null);
            holder = new GroupViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (GroupViewHolder) view.getTag();
        }

        if (mType.equals("pinyin")) {
            holder.mGroupTV.setText(mGroupData.get(i));
        } else {
            holder.mGroupTV.setText(mGroupData.get(i) + "画");
        }

        if (mSelectedGroupPos == i) {
            view.setBackgroundColor(Color.BLACK);
            holder.mGroupTV.setTextColor(Color.RED);
        } else {
            view.setBackgroundResource(R.color.grey_200);
            holder.mGroupTV.setTextColor(Color.BLACK);
        }

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.elvitem_child_navigate, null);
            holder = new ChildViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ChildViewHolder) view.getTag();
        }

        PinyinAndBushouMappingBean.ResultBean resultBean = mChildData.get(i).get(i1);
        if (mType.equals("pinyin")) {
            holder.mChildTV.setText(resultBean.getPinyin());
        } else {
            holder.mChildTV.setText(resultBean.getBushou());
        }

        if (mSelectedGroupPos == i && mSelectedChildPos == i1) {
            view.setBackgroundColor(Color.WHITE);
            holder.mChildTV.setTextColor(Color.RED);
        } else {
            view.setBackgroundResource(R.color.grey_200);
            holder.mChildTV.setTextColor(Color.BLACK);
        }

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    class GroupViewHolder {
        TextView mGroupTV;

        public GroupViewHolder(View view) {
            mGroupTV = view.findViewById(R.id.elvitem_group_navigate_tv);
        }
    }

    class ChildViewHolder {
        TextView mChildTV;

        public ChildViewHolder(View view) {
            mChildTV = view.findViewById(R.id.elvitem_child_navigate_tv);
        }
    }
}
