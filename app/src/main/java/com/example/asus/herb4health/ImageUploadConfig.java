package com.example.asus.herb4health;

/**
 * Created by sirawich on 9/2/2017 AD.
 */

public class ImageUploadConfig {
    public String name;
    public String url;
    public String option;

    public String getname(){
        return name;

    }
    public String getOption(){
        return option;
    }
    public String geturl(){
        return url;
    }
    public ImageUploadConfig(String name ,String url,String option){
        this.name = name;
        this.url = url;
        this.option = option;
    }
    public ImageUploadConfig(){}
}
