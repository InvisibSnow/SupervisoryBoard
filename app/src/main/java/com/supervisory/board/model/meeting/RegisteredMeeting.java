package com.supervisory.board.model.meeting;

import android.animation.ObjectAnimator;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableBoolean;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.supervisory.board.ui.adapter.meeting.QuestionListAdapter;

import java.util.Date;
import java.util.List;

public class RegisteredMeeting extends BaseObservable {

    public final ObservableBoolean agendaVisibility = new ObservableBoolean();
    private ImageView imageView;
    @Expose
    @SerializedName("ID")
    private long id;

    @Expose
    @SerializedName("DateEnd")
    private Date dateEnd;

    @Expose
    @SerializedName("DateStart")
    private Date dateStart;

    @Expose
    @SerializedName("Documents")
    private List<Document> documents;

    @Expose
    @SerializedName("Portal")
    private String portal;

    @Expose
    @SerializedName("Questions")
    private List<Question> questions;

    @Expose
    @SerializedName("RegNumber")
    private String regNumber;

    @Expose
    @SerializedName("State")
    private String state;

    @Expose
    @SerializedName("Times")
    private Times times;

    public long getId() {
        return id;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public String getPortal() {
        return portal;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public Times getTimes() {
        return times;
    }

    public String getState() {
        return state;
    }

    public void setAgendaVisibility(){
        if(agendaVisibility.get()){
            agendaVisibility.set(false);
            ObjectAnimator.ofFloat(imageView, "rotation", 180, 360).start();
        } else {
            agendaVisibility.set(true);
            ObjectAnimator.ofFloat(imageView, "rotation", 0, 180).start();
        }
    }

    @BindingAdapter("ivArrow")
    public static void setImageView(ImageView imageView, RegisteredMeeting registeredMeeting ){
        registeredMeeting.imageView = imageView;
    }

    @BindingAdapter("questions")
    public static void setRecyclerView(RecyclerView recyclerView, RegisteredMeeting registeredMeeting ){
        LinearLayoutManager llm = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(llm);
        QuestionListAdapter questionListAdapter = new QuestionListAdapter();
        recyclerView.setAdapter(questionListAdapter);
        questionListAdapter.setDataList(registeredMeeting.questions);
    }
}
