package com.example.serverdrivenuiapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultResponse {
    @SerializedName("number_of_fields")
    private int number_of_fields;

    @SerializedName("screen_title")
    private String screen_title;

    @SerializedName("service_id")
    private int service_id;

    @SerializedName("fields")
    private List<UIFields> uiFields = new ArrayList<>();


    public int getNumber_of_fields() {
        return number_of_fields;
    }

    public void setNumber_of_fields(int number_of_fields) {
        this.number_of_fields = number_of_fields;
    }

    public String getScreen_title() {
        return screen_title;
    }

    public void setScreen_title(String screen_title) {
        this.screen_title = screen_title;
    }

    public List<UIFields> getUiFields() {
        return uiFields;
    }

    public void setUiFields(List<UIFields> uiFields) {
        this.uiFields = uiFields;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }
}
