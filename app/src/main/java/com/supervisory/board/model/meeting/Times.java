package com.supervisory.board.model.meeting;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Times extends BaseObservable {

    @Expose
    @SerializedName("Date")
    private String date;

    @Expose
    @SerializedName("Place")
    private String place;

    @Expose
    @SerializedName("Title")
    private String title;


    public String getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public String getTitle() {
        return title;
    }
}
