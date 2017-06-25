package com.dtrix.listview;

/**
 * Created by Soumya on 12-06-2017.
 */

public class Place {
    private String name=null;
    private int zip=0;
    private String image="icon";
    private String popup=null;

    Place(String name, int zip,String popup){
        this.name=name;
        this.zip=zip;
//        this.image=image;
        this.popup=popup;
    }

    public String getName() {
        return name;
    }

    public int getZip() {
        return zip;
    }

    public String getImage() {
        return image;
    }

    public String getPopup() {
        return popup;
    }
}
