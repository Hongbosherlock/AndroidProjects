package com.example.hongb.activitytest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends BaseActivity {
    public static void actionStart(Context context, String data1, String data2){
        Intent intent = new Intent(context,SecondActivity.class);
        intent.putExtra("papram1",data1);
        intent.putExtra("papram2",data2);
        context.startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent .putExtra("data_return","Hello FirstActivity");
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity","onDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity","Task id is "+getTaskId());  //打印当前返回栈的id
        setContentView(R.layout.activity_second);

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);

                Toast.makeText(SecondActivity.this,"You clicked Button 2",
                        Toast.LENGTH_SHORT).show();
                finish();  //销毁活动，返回上一个活动
            }
        });

    }
}
