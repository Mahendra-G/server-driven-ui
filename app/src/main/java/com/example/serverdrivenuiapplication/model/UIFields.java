package com.example.serverdrivenuiapplication.model;

import com.google.gson.annotations.SerializedName;

public class UIFields {
    @SerializedName("name")
    private String name;

    @SerializedName("placeholder")
    private String placeholder;

    @SerializedName("hint_text")
    private String hint_text;

    @SerializedName("regex")
    private String regex;

    @SerializedName("ui_type")
    private UIType UITypeList;

    @SerializedName("is_mandatory")
    private boolean isIs_mandatory;

    @SerializedName("type")
    private Type type;

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isIs_mandatory() {
        return isIs_mandatory;
    }

    public void setIs_mandatory(boolean is_mandatory) {
        isIs_mandatory = is_mandatory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public UIType getUITypeList() {
        return UITypeList;
    }

    public void setUITypeList(UIType UITypeList) {
        this.UITypeList = UITypeList;
    }

    public String getHint_text() {
        return hint_text;
    }

    public void setHint_text(String hint_text) {
        this.hint_text = hint_text;
    }
}
