package com.cn.horizon.life.app.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.cn.horizon.library.basic.BasicActivity;
import com.cn.horizon.library.utils.Logger;
import com.cn.horizon.life.R;
import com.cn.horizon.life.widgets.MyListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;

/**
 * Created by horizony on 2017/3/22.
 */

public class ScrollActivity extends BasicActivity {
    @Bind(R.id.lvList)
    MyListView lvList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_scroll;
    }

    @Override
    protected void onViewCreated(Bundle saveInstanceState) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            data.add("data" + i);
        }
        lvList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, data));
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("ScrollActivity","  "+position);
            }
        });
    }

}
