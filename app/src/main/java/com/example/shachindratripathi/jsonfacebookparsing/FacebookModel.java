package com.example.shachindratripathi.jsonfacebookparsing;

import java.util.ArrayList;

/**
 * Created by shachindratripathi on 28/7/17.
 */

public class FacebookModel {

    private String id;
    private String message;
    private String type;
    private String created_time;
    private String updated_time;
    private ArrayList<ActionsModel>actionsModel;
    private ArrayList<FromModel>fromModel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(String updated_time) {
        this.updated_time = updated_time;
    }

    public ArrayList<ActionsModel> getActionsModel() {
        return actionsModel;
    }

    public void setActionsModel(ArrayList<ActionsModel> actionsModel) {
        this.actionsModel = actionsModel;
    }

    public ArrayList<FromModel> getFromModel() {
        return fromModel;
    }

    public void setFromModel(ArrayList<FromModel> fromModel) {
        this.fromModel = fromModel;
    }
}
