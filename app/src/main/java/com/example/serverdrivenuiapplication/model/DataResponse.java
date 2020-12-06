package com.example.serverdrivenuiapplication.model;

import com.google.gson.annotations.SerializedName;

public class DataResponse {
    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("result")
    private ResultResponse responses;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultResponse getResponses() {
        return responses;
    }

    public void setResponses(ResultResponse responses) {
        this.responses = responses;
    }
}
