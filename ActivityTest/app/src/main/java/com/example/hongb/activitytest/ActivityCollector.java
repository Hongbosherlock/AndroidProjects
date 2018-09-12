package com.example.hongb.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hongb on 2018/5/12.
 */

public class ActivityCollector {
    public static List<Activity> activities=new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);  //添加活动
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        for (Activity activity : activities){  //遍历activities数组
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
    }
}
