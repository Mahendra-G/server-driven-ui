package com.example.serverdrivenuiapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UIType {
    @SerializedName("type")
    private String type;

    @SerializedName("values")
    private List<Values> valuesList;

    public List<Values> getValuesList() {
        return valuesList;
    }

    public void setValuesList(List<Values> valuesList) {
        this.valuesList = valuesList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
