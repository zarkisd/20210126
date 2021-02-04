package com.example.a20210126;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


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
    ArrayList<TalkVO> talk = new ArrayList<>();
    TalkAdapter adapter;


    //GoogleCloud Server - FireBase 연동해보기

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://junhotalk-0203-default-rtdb.firebaseio.com/");
    DatabaseReference ref = database.getReference("msg");






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        ref.addChildEventListener(new ChildEventListener() {
            // 하위 경로에 무슨일이 생겼을떄를 감지
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
//추가
                TalkVO temp=dataSnapshot.getValue(TalkVO.class);
                talk.add(temp);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//자식 바뀜
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//자식 제거
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//자식 옮김
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
//에러 오류
            }
        });


        btn_pre = findViewById(R.id.btn_pre);
        btn_send = findViewById(R.id.btn_send);
        textView = (TextView) findViewById(R.id.tv_result);
        edt_msg = (EditText) findViewById(R.id.edt_msg);

        Intent intent = new Intent(this.getIntent());
        String getID = intent.getStringExtra("ID");
        //String getPW=intent.getStringExtra("PW");
        textView.setText(getID + "님 환영합니다.");

        ListView listview = findViewById(R.id.listview);


        //talk.add(new TalkVO(R.drawable.image1, "김민희", "다 죽어라!!!", "23:58"));
        //talk.add(new TalkVO(R.drawable.image2, "오경민", "미니 술먹었어? ㅋㅋㅋㅋ", "00:01"));
        //talk.add(new TalkVO(R.drawable.image3, "오유정", "오매오매 언닠ㅋㅋㅋㅋㅋㅋ", "00:02"));
        //talk.add(new TalkVO(R.drawable.image4, "손준호", "어차피 내일이면 기억못해 저 누나", "00:03"));

        //실습!!
        //ArrayAdapter textview로 단독으로 있을떄만 사용가능
        // baseAdaper상속받은 새로운 어댑터 설계
        adapter = new TalkAdapter(subActivity.this, R.layout.talklayout, talk);

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


                long now = System.currentTimeMillis();
                Date mDate = new Date(now);
                SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm");
                String getTime = simpleDate.format(mDate);


                Log.v("value", getTime);



                Toast.makeText(subActivity.this, "addition", Toast.LENGTH_SHORT).show();
                Log.v("value", "버튼 클릭3" + talk.toString());
                String msg = edt_msg.getText().toString();
                if (msg.length() != 0) {
                    //talk.add(new TalkVO(R.drawable.image4, "손준호", msg, getTime));
                    //firebase로 데이터 전송하기


                    ref.push().setValue(new TalkVO(R.drawable.image4, "손준호", msg, getTime));
                    
                    
                    //어댑터 새로고침
                    adapter.notifyDataSetChanged();

                }
                //editText에 적혀있는 글자 지우기
                edt_msg.setText("");

            }
        });


    }


}