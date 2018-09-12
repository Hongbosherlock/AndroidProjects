package com.example.hongb.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.lang.ref.SoftReference;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
//    private ImageView imageView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        为Button的点击事件注册一个监听器
        Button button= (Button) findViewById(R.id.button);
//        通过id获取实例
        editText = (EditText)findViewById(R.id.edit_text);
//        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button:
                        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                        progressDialog.setTitle("This is ProgressDialog");
                        progressDialog.setMessage("Loading...");
                        progressDialog.setCancelable(true);
                        progressDialog.show();

                       int progress =progressBar.getProgress();
                       progress = progress+10;
                       progressBar.setProgress(progress);
//                        imageView.setImageResource(R.drawable.spider);
                        String inputText = editText.getText().toString();
                        Toast.makeText(MainActivity.this,inputText,
                                Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }

            }
        });
    }
}
