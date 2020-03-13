package com.supervisory.board.model.meeting;

import androidx.databinding.BaseObservable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Question extends BaseObservable {

    @Expose
    @SerializedName("ID")
    private long id;

    @Expose
    @SerializedName("Documents")
    private List<Document> documents;

    @Expose
    @SerializedName("Duration")
    private String duration;

    @Expose
    @SerializedName("Question")
    private String question;

    @Expose
    @SerializedName("Speakers")
    private List<String> speakers;

    private int numberOfQuestion;

    public long getId() {
        return id;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public String getDuration() {
        return duration;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getSpeakers() {
        return speakers;
    }

    public int getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public void setNumberOfQuestion(int numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }

    public String getQuestionNumber(){
        return "№ " + numberOfQuestion;
    }

    public String getSpeakersList(){
        StringBuilder speakersList = new StringBuilder();
        for(String speaker: speakers){
            if(speakersList.length() > 0) {
                speakersList.append(speaker).append("\n");
            } else {
                speakersList.append(speaker);
            }
        }
        return speakersList.toString();
    }


}
