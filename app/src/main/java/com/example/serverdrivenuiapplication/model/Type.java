package com.example.serverdrivenuiapplication.model;

import com.google.gson.annotations.SerializedName;

public class Type {

    @SerializedName("data_type")
    private String data_type;

    @SerializedName("is_array")
    private String is_array;

    @SerializedName("array_name")
    private String array_name;

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public String getIs_array() {
        return is_array;
    }

    public void setIs_array(String is_array) {
        this.is_array = is_array;
    }

    public String getArray_name() {
        return array_name;
    }

    public void setArray_name(String array_name) {
        this.array_name = array_name;
    }
}
