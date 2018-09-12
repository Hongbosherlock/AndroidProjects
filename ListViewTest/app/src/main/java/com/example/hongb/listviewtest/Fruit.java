package com.example.hongb.listviewtest;

/**
 * Created by Hongb on 2018/8/7.
 */

public class Fruit {
    private String name;
    private int imageId;

    public Fruit(String name, int imageId){
        this.name =name;
        this.imageId = imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
