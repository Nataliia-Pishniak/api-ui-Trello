package com.trello.api.models;

import com.google.gson.annotations.SerializedName;

public class Card {

    public String id;
    public String desc;
    public String idBoard;
    public String idList;
    public String name;
    public String url;

    public Card(){}

    public Card(String name){
        this.name = name;
    }


    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", idList='" + idList + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}