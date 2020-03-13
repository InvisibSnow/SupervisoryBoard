package com.supervisory.board.model.meeting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Document {

    @Expose
    @SerializedName("ID")
    private long id;

    @Expose
    @SerializedName("Title")
    private String title;

    @Expose
    @SerializedName("Author")
    private String author;

    @Expose
    @SerializedName("Comments")
    private long comments;

    @Expose
    @SerializedName("FileSize")
    private String fileSize;

    @Expose
    @SerializedName("FileType")
    private String fileType;

    @Expose
    @SerializedName("Lang")
    private String language;

    @Expose
    @SerializedName("Modified")
    private Date modifiedDate;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getComments() {
        return comments;
    }

    public String getFileSize() {
        return fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public String getLanguage() {
        return language;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }
}
