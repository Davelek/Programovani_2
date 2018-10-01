package model;


import java.beans.SimpleBeanInfo;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDoItem implements Serializable {

    private String date;
    private String content;
    private Boolean done;

    public ToDoItem(String content){
        this.content = content;
        this.date = new SimpleDateFormat("d.M.yyyy").format(new Date());
        this.done = false;

    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(boolean done){
        this.done = true;
    }
    public void setContent(String st){
        this.content = st;
    }



}

