package com.example.hongb.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecycleView;
    private MsgAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiMsgs(); //初始化消息数据
        inputText = (EditText)  findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecycleView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecycleView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecycleView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);
                    // 当有消息时，刷新RecycleView中的显示
                    msgRecycleView.scrollToPosition(msgList.size()-1); //将RecyclerView定位到最后一行
                    inputText.setText(""); //清除输入框中的内容
                }
            }
        });

    }
    private void intiMsgs(){
        Msg msg1 = new Msg("Hello, I'm Lulu.",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hi, I'm Hongbo",Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("What's up?",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
        Msg msg4 = new Msg("I'm here to say....",Msg.TYPE_SENT);
        msgList.add(msg4);
        Msg msg5 = new Msg("I LOVE YOU.",Msg.TYPE_SENT);
        msgList.add(msg5);
    }
}
