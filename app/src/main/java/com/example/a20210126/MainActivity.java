package com.example.a20210126;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_next;
    String id="junho";
    String pw="1234";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 누르면 sbuActivity이동
        //1. 버튼을 findViewByID
        //2. 버튼에 onClick(enventListner) set
        //3. 버튼 눌렀을때 click! toast 메시지 출력

        btn_next = findViewById(R.id.btn_next);
        final EditText edit_text_id=(EditText)findViewById(R.id.edit_id);
        final EditText edit_text_pw=(EditText)findViewById(R.id.edit_pw);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v("value", "다음버튼 클릭1");

                String id_input=edit_text_id.getText().toString();
                String pw_input=edit_text_pw.getText().toString();
                //1. intent 준비(출발 액티비티, 도착 액티비티 순서대로)

                if(id_input.equals(id)&&pw_input.equals(pw)) {
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    Log.v("value", "로그인 성공");
                    Intent myIntent = new Intent(MainActivity.this, subActivity.class);


                    myIntent.putExtra("ID", id_input);
                    myIntent.putExtra("PW", pw_input);
                    //2. 인텐트 실행
                    startActivity(myIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "fail...", Toast.LENGTH_SHORT).show();
                    Log.v("value", "로그인 실패");
                }
            }
        });

    }
}


