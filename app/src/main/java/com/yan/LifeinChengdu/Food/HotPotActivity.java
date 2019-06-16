package com.yan.LifeinChengdu.Food;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.yan.LifeinChengdu.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HotPotActivity extends ListActivity implements Runnable {

    Handler handler;
    private final String TAG = "food";
    private ArrayList<HashMap<String, String>> listItems2;//存放文字、图片信息
    private SimpleAdapter listItemAdapter2;//适配器

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        initListView();

        //MyAdapter myAdapter = new MyAdapter(this,R.layout.list_item,listItems);
        //this.setListAdapter(myAdapter);

        Thread thread = new Thread(this);
        thread.start();

        handler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 10) {
                    List<HashMap<String, String>> list2 = (List<HashMap<String, String>>) msg.obj;
                    listItemAdapter2 = new SimpleAdapter(HotPotActivity.this, list2,//listItems 数据源
                            R.layout.activity_hot_pot, //ListItem的XML布局实现
                            new String[]{"ItemTitle1", "ItemDetail1","ItemDetail2","ItemDetail3"},
                            new int[]{R.id.itemTitle1, R.id.itemDetail1, R.id.itemDetail2,R.id.itemDetail3}
                    );
                    setListAdapter(listItemAdapter2);
                }
                super.handleMessage(msg);
            }
        };
    }

    private void initListView() {
        listItems2 = new ArrayList<HashMap<String, String>>();

        //生成适配器的Item和动态数组对应的元素
        listItemAdapter2 = new SimpleAdapter(this, listItems2,//listItems 数据源
                R.layout.activity_hot_pot, //ListItem的XML布局实现
                new String[]{"ItemTitle1", "ItemDetail1","ItemDetail2","ItemDetail3"},
                new int[]{R.id.itemTitle1, R.id.itemDetail1,R.id.itemDetail2,R.id.itemDetail3}
        );
    }

    @Override
    public void run() {
        //获取数据，放入list带回到主线程
        List<HashMap<String, String>> retList = new ArrayList<>();
        HashMap<String,String> map = new HashMap<String,String>();

        String str1="小龙坎老火锅(春熙路店）";
        String str2 = "东大街下东大街36号蓝光郁金香花园广场";
        String str3 = "028-81479050";
        String str4 = "93元";


            map.put("ItemTitle1",str1);
            map.put("ItemDetail1","位置："+str2);
            map.put("ItemDetail2","电话："+str3);
            map.put("ItemDetail3","人均消费："+str4);

            retList.add(map);

        HashMap<String,String> map1 = new HashMap<String,String>();
        String str5="大龙燚(太古里店）";
        String str6 = "锦江区东大街下东大街段166号";
        String str7 = "028-61190606";
        String str8 = "93元";


        map1.put("ItemTitle1",str5);
        map1.put("ItemDetail1","位置："+str6);
        map1.put("ItemDetail2","电话："+str7);
        map1.put("ItemDetail3","人均消费："+str8);
        retList.add(map1);


        HashMap<String,String> map2 = new HashMap<String,String>();
        String str9="晓宇火锅(凯旋店）";
        String str10 = "中环路锦绣大道3688号华润凯旋天地";
        String str11 = "- -";
        String str12= "62元";

        map2.put("ItemTitle1",str9);
        map2.put("ItemDetail1","位置："+str10);
        map2.put("ItemDetail2","电话："+str11);
        map2.put("ItemDetail3","人均消费："+str12);

        retList.add(map2);

        HashMap<String,String> map3 = new HashMap<String,String>();
        String str13="皇城老妈（国金店）";
        String str14 = "锦江区红星路三段1号IFS";
        String str15 = "028-84451986";
        String str16= "118元";

        map3.put("ItemTitle1",str13);
        map3.put("ItemDetail1","位置："+str14);
        map3.put("ItemDetail2","电话："+str15);
        map3.put("ItemDetail3","人均消费："+str16);

        retList.add(map3);

        HashMap<String,String> map4 = new HashMap<String,String>();
        String str17="蜀九香火锅（SM店）";
        String str18 = "成华区建设路南路20号附1号";
        String str19 = "028-84300666";
        String str20= "103元";

        map4.put("ItemTitle1",str17);
        map4.put("ItemDetail1","位置："+str18);
        map4.put("ItemDetail2","电话："+str19);
        map4.put("ItemDetail3","人均消费："+str20);

        retList.add(map4);




        Message msg = handler.obtainMessage(10);
        //msg.what = 10;
        msg.obj =retList;
        handler.sendMessage(msg);
    }

}
