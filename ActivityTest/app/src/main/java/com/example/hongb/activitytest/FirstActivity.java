package com.example.hongb.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked remove",Toast.LENGTH_SHORT).show();
                break;

                default:
        }
        return true;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity","onRestart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        Log.d("FirstActivity",this.toString());  //打印当前活动实例
        Log.d("FirstActivity","Task id is "+getTaskId());  //打印当前返回栈的id
        setContentView(R.layout.first_layout);
        Button button1 =(Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondActivity.actionStart(FirstActivity.this,"data1","data2");

                Toast.makeText(FirstActivity.this,"You clicked Button 1",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnedData);
                }
                break;
               default:
        }
    }
}
