package com.ysr.listviewcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        init();

    }

    private void init() {

        String[] mListArrays = new String[100];
        for (int i = 0; i < mListArrays.length; i++) {
            mListArrays[i] = "item" + i;
        }
        MyAdapter adapter = new MyAdapter(this, mListArrays);
        lv.setAdapter(adapter);
    }


}
