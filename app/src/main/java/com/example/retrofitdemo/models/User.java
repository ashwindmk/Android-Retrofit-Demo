package com.example.retrofitdemo.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ashwin on 3/11/17.
 */

public class User {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
