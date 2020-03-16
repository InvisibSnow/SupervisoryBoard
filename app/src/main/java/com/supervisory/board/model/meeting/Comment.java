package com.supervisory.board.model.meeting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Comment {

    @Expose
    @SerializedName("ID")
    private long id;

    @Expose
    @SerializedName("Author")
    private String author;

    @Expose
    @SerializedName("Date")
    private Date date;

    @Expose
    @SerializedName("Title")
    private String title;

    @Expose
    @SerializedName("Text")
    private String text;

}
