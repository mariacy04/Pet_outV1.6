package com.example.pet_out.model;
import java.io.Serializable;

public class Step implements Serializable {
    private int id;
    private int raw_resource;
    private String title, sub_title;
    private boolean show_title, show_sub_title;

    public Step() {
    }

    public Step(int raw_resource, String title) {
        this.raw_resource = raw_resource;
        this.title = title;
        show_title =true;
        show_sub_title = false;
    }

    public Step(int raw_resource, String title, String sub_title) {
        this.raw_resource = raw_resource;
        this.title = title;
        this.sub_title = sub_title;
        show_title = true;
        show_sub_title = sub_title != null;
    }

    public int getRaw_resource() {
        return raw_resource;
    }

    public void setRaw_resource(int raw_resource) {
        this.raw_resource = raw_resource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public boolean isShow_title() {
        return show_title ;
    }

    public void setShow_title(boolean show_title) {
        this.show_title = show_title ;
    }

    public boolean isShow_sub_title() {
        return show_sub_title ;
    }

    public void setShow_sub_title(boolean show_sub_title) {
        this.show_sub_title = show_sub_title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

