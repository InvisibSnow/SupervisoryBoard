package com.supervisory.board.ui.activity.main.data;

import com.supervisory.board.api.BaseCall;
import com.supervisory.board.api.IOnErrorListener;
import com.supervisory.board.api.IOnFinishLoadListener;
import com.supervisory.board.api.RestManager;
import com.supervisory.board.model.meeting.RegisteredMeeting;
import com.supervisory.board.utils.Headers;

import java.util.List;

import retrofit2.Call;

import static com.supervisory.board.utils.Constants.API_ARCHIVE_MEETINGS;

public class MeetingsRepo implements IMeetingsRepo{

    private Call<List<RegisteredMeeting>> registeredMeetingListCall;

    @Override
    public void getRegisteredMeetings(IOnFinishLoadListener<List<RegisteredMeeting>> onFinishLoadListener, IOnErrorListener iBaseOnFinishListener) {
        cancelCall(registeredMeetingListCall);
        registeredMeetingListCall = RestManager.getApiWithTimeZone().getRegisteredMeetings(Headers.getAuthorityMap(), API_ARCHIVE_MEETINGS);
        new BaseCall<RegisteredMeeting>().retrofitListCall(registeredMeetingListCall, onFinishLoadListener, iBaseOnFinishListener);
    }

    @Override
    public void cancelAllRequest() {
        cancelCall(registeredMeetingListCall);
    }

    private void cancelCall(Call call){
        if(call != null){
            call.cancel();
        }
    }
}
