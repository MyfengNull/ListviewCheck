package com.ysr.listviewcheck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/11/13.
 */
public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mListArrays;
    private LayoutInflater mInflater;
    //用于存储CheckBox选中状态
    public Map<Integer, Boolean> mCBFlag = null;

    public MyAdapter(Context c, String[] arrays) {
        this.mContext = c;
        this.mListArrays = arrays;
        mInflater = LayoutInflater.from(mContext);
        mCBFlag = new HashMap<Integer, Boolean>();
        init();
    }

    //初始化CheckBox状态
    void init() {
        for (int i = 0; i < mListArrays.length; i++) {
            mCBFlag.put(i, false);
        }
    }

    @Override
    public int getCount() {
        return mListArrays.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item, null);
            holder.mTextView = (TextView) convertView.findViewById(R.id.tv);
            holder.mCheckBox = (CheckBox) convertView.findViewById(R.id.cb);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //状态保存
        holder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mCBFlag.put(position, true);
                } else {
                    mCBFlag.put(position, false);
                }
            }
        });
   /*CheckBox监听事件必须放在setChecked之前，否则后果自负*/
        holder.mCheckBox.setChecked(mCBFlag.get(position));
        holder.mTextView.setText(mListArrays[position]);

        return convertView;
    }

    public final class ViewHolder {
        public TextView mTextView;
        public CheckBox mCheckBox;
    }
}

