package com.example.linux.restgetrequestdemo.retrofituse.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by linux on 28/8/17.
 */

public class Region {


// [{"ID":10061,"Name":"MyNewRegion","NumberOfUsers":4},{"ID":10059,"Name":"NikleshTest Default Region","NumberOfUsers":5}]

    @SerializedName("ID")
    private long ID;

    @SerializedName("Name")
    private String Name;

    @SerializedName("NumberOfUsers")
    private int NumberOfUsers;


    public long getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public int getNumberOfUsers() {
        return NumberOfUsers;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        NumberOfUsers = numberOfUsers;
    }
}
