package com.example.hongb.uibestpractice;

/**
 * Created by Hongb on 2018/9/5.
 */

public class Msg {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    private String content;   //表示消息内容
    private int type;       //表示消息类型
    public Msg(String content,int type){
        this.content = content;
        this.type = type;
    }

    public String getContent(){
        return content;
    }
    public int getType(){
        return  type;
    }
}
