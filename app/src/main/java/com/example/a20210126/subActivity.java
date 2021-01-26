package com.example.a20210126;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class subActivity extends AppCompatActivity {
    Button btn_pre, btn_send;
    TextView textView;
    EditText edt_msg;
    //[톡 리스트 만드는 법]
    // 1. 톡 데이터 만들기  ->arraylist
    //2. 톡 하나 디자인  ->새로운 xml
    //3.  Adapter  만들어서 디자인+ 톡 데이터 합치기
    //4. Adapter listView에 부착

    //실습  ArrayList 생성하고 톡 5개 추가시키기
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        btn_pre = findViewById(R.id.btn_pre);
        btn_send = findViewById(R.id.btn_send);
        textView = (TextView) findViewById(R.id.tv_result);
        edt_msg = (EditText) findViewById(R.id.edt_msg);

        Intent intent = new Intent(this.getIntent());
        String getID = intent.getStringExtra("ID");
        //String getPW=intent.getStringExtra("PW");
        textView.setText(getID + "님 환영합니다.");

        ListView listview = findViewById(R.id.listview);

        String[] arr = {"손준호", "도한재", "오유정", "김민희", "오경민", "장현석", "오주율", "양기영", "김동준", "임마루"};
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i] + " 출석");
        }

        adapter = new ArrayAdapter<String>(subActivity.this, R.layout.simplelist, list);

        listview.setAdapter(adapter);


        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(subActivity.this, "click!", Toast.LENGTH_SHORT).show();
                Log.v("value", "버튼 클릭2");

                finish();

            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(subActivity.this, "addition", Toast.LENGTH_SHORT).show();
                Log.v("value", "버튼 클릭3" + list.toString());
                String msg = edt_msg.getText().toString();
                if (msg.length() != 0) {
                    list.add(msg);
                    //어댑터 새로고침
                    adapter.notifyDataSetChanged();




                }
                //editText에 적혀있는 글자 지우기
                edt_msg.setText("");

            }
        });


    }


}