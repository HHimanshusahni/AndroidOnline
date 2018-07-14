package com.online.firebase;

// This is a POJO class
public class Note {
    String title;
    String subtitle;

    public Note(){

    }
    public Note(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }


}


