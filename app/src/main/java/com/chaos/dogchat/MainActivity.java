package com.chaos.dogchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ChaosRecyclerView chaosRecyclerView;
    private List<DogBean> list_db;
    private int[] type_db= {R.mipmap.alsaka,R.mipmap.husky,R.mipmap.samoyed,R.mipmap.corgi,R.mipmap.sharpei,
    R.mipmap.pomeranian,R.mipmap.bordeaux,R.mipmap.pitbull,R.mipmap.tibetan,R.mipmap.corso,R.mipmap.capf};
    private String[] name_db={"Alaska","Husky","Samoyed","Corgi","Sharpei","Pomeranian","Bordeaux",
    "Pitbull","Tibetan","Corso","BlackOrder"};
    private String[] content_db={"楼下是傻狗","你才是傻狗","楼上是傻狗","[动画表情]","好吵","我美我不说话","...",
    "大家好我是孙红雷","我能打10个傻狗","哦，你好厉害","[动画表情]"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BarUtils.setColor(this,getResources().getColor(R.color.top),0);
        chaosRecyclerView = (ChaosRecyclerView) findViewById(R.id.chaos_rv);
        list_db = new ArrayList<>();
        for (int i = 0; i < name_db.length; i++) {
            DogBean dogBean = new DogBean();
            dogBean.setContent(content_db[i]);
            dogBean.setName(name_db[i]);
            dogBean.setType(type_db[i]);
            list_db.add(dogBean);
        }
        final ChaosAdapter adapter = new ChaosAdapter(this, list_db);
        chaosRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        chaosRecyclerView.setAdapter(adapter);
        chaosRecyclerView.setOnItemClickListener(new OnItemDeleteListener() {
            @Override
            public void onSignClick(int position) {
                adapter.toTopItem(position);
            }

            @Override
            public void onDeleteClick(int position) {
                adapter.removeItem(position);
            }
        });
    }
}
