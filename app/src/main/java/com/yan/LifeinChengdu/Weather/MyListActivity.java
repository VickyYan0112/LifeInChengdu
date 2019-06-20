package com.yan.LifeinChengdu.Weather;

import android.app.ListActivity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
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

public class MyListActivity extends ListActivity implements Runnable{

    Handler handler;
    private final String TAG = "weather";
    private ArrayList<HashMap<String,String>> listItems;//存放文字、图片信息
    private SimpleAdapter listItemAdapter;//适配器
    String data[] = {"小都儿努力加载中，请耐心等待"};

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        initListView();

        //MyAdapter myAdapter = new MyAdapter(this,R.layout.list_item,listItems);
        //this.setListAdapter(myAdapter);
        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        setListAdapter(adapter);

        Thread t = new Thread(this);
        t.start();

        handler = new Handler(){
            public void handleMessage(Message msg){
                if (msg.what==10){
                    List<HashMap<String,String>>list1 = (List<HashMap<String, String>>) msg.obj;
                    listItemAdapter = new SimpleAdapter(MyListActivity.this,list1,//listItems 数据源
                            R.layout.list_item, //ListItem的XML布局实现
                            new String[]{"ItemTitle","ItemDetail"},
                            new int[]{R.id.itemTitle,R.id.itemDetail}
                    );
                    setListAdapter(listItemAdapter);
                }
                super.handleMessage(msg);
            }
        };
    }
    private void  initListView(){
        listItems = new ArrayList<HashMap<String, String>>();
        for (int i=0; i<10;i++){
            HashMap<String,String> map = new HashMap<String, String>();
            map.put("ItemTitle","日期:"+i);//标题文字
            map.put("ItemDetail",""+i);//详情描述
            listItems.add(map);
        }

        //生成适配器的Item和动态数组对应的元素
        listItemAdapter = new SimpleAdapter(this,listItems,//listItems 数据源
                R.layout.list_item, //ListItem的XML布局实现
                new String[]{"ItemTitle","ItemDetail"},
                new int[]{R.id.itemTitle,R.id.itemDetail}
        );
    }

    @Override
    public void run() {
        //获取网络数据，放入list带回到主线程
        List<HashMap<String, String>> retList =  new ArrayList<>();

        Document doc = null;
        try {
            Thread.sleep(3000);
            doc = Jsoup.connect("http://www.tianqihoubao.com/weather/top/chengdu.html").get();
            //doc = Jsoup.parse(html);
            Log.i(TAG, "run: " + doc.title());
            Elements tables = doc.getElementsByTag("table");
            Log.i(TAG,"run: table = "+tables);
            Element table2 = tables.get(0);

            Elements tds = table2.getElementsByTag("td");
            for (int i = 10; i < tds.size(); i += 8) {
                Element td1 = tds.get(i);
                Element td2 = tds.get(i+1);
                Element td3 = tds.get(i + 2);
                Element td4 = tds.get(i + 3);
                Element td5 = tds.get(i + 4);
                Element td6 = tds.get(i + 5);
                Element td7 = tds.get(i + 6);
                Element td8 = tds.get(i + 7);
                Log.i(TAG, "run: 城市" + td1.text());
                Log.i(TAG,"run: 日期" + td2.text());
                Log.i(TAG, "run: 白天天气状况" + td3.text());
                Log.i(TAG, "run: 白天风力方向" + td4.text());
                Log.i(TAG, "run: 白天最高温度" + td5.text());
                Log.i(TAG, "run: 夜间天气状况" + td6.text());
                Log.i(TAG, "run: 夜间风力方向" + td7.text());
                Log.i(TAG, "run: 夜间最高温度" + td8.text());
                String str1 = td1.text();
                String str2 = td2.text();
                String str3 = td3.text();
                String str4 = td4.text();
                String str5 = td5.text();
                String str6 = td6.text();
                String str7 = td7.text();
                String str8 = td8.text();

                HashMap<String,String> map = new HashMap<String,String>();
                map.put("ItemTitle",str2);
                map.put("ItemDetail","天气情况："+str3+"  最高："+str5+"  最低："+str8);
                retList.add(map);

            }
            for (Element td : tds) {
                Log.i(TAG, "run : td=" + td);
                Log.i(TAG, "run : text=" + td.text());
                Log.i(TAG, "run : html=" + td.html());

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Message msg = handler.obtainMessage(10);
        //msg.what = 10;
        msg.obj =retList;
        handler.sendMessage(msg);

    }
}

