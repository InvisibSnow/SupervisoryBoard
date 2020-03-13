package com.supervisory.board.api;
import com.supervisory.board.model.meeting.RegisteredMeeting;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Url;

public interface ApiService {

    @GET()
    Call<List<RegisteredMeeting>> getRegisteredMeetings(@HeaderMap Map<String, String> headers, @Url String url);

}
