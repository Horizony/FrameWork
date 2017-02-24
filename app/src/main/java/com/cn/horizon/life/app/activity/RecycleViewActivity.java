package com.cn.horizon.life.app.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.horizon.life.R;
import com.cn.horizon.life.basic.BasicActivity;
import com.cn.horizon.life.widgets.MyLayoutManager;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by horizony on 2016/11/21.
 */

public class RecycleViewActivity extends BasicActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rvList)
    RecyclerView rvList;


    private ArrayList<String> data;
    private MyAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recycleview;
    }

    @Override
    protected void onViewCreated(Bundle saveInstanceState) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addTestData();
        adapter = new MyAdapter(mContext, data);
        rvList.setAdapter(adapter);

        //system manager
//        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        rvList.setLayoutManager(layoutManager);

        //custom manager
        rvList.setLayoutManager(new MyLayoutManager());
    }


    /**
     * test data
     */
    private void addTestData() {
        if (data == null) data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("the " + i);
        }
    }


    /**
     * adapter
     */
    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private Context mContent;
        private ArrayList<String> data = new ArrayList<>();

        public MyAdapter(Context mContent, ArrayList<String> data) {
            this.mContent = mContent;
            this.data = data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View layoutView = LayoutInflater.from(mContent).inflate(R.layout.activity_recycleview_item, null);
            MyViewHolder holder = new MyViewHolder(layoutView);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tvName.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data == null ? 0 : data.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView tvName;

            public MyViewHolder(View view) {
                super(view);
                tvName = (TextView) view.findViewById(R.id.tvName);
            }
        }
    }
}
