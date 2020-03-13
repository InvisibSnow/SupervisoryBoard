package com.supervisory.board.ui.activity.main.data;

import com.supervisory.board.api.IBase;
import com.supervisory.board.api.IOnErrorListener;
import com.supervisory.board.api.IOnFinishLoadListener;
import com.supervisory.board.model.meeting.RegisteredMeeting;

import java.util.List;

public interface IMeetingsRepo extends IBase {
    void getRegisteredMeetings(IOnFinishLoadListener<List<RegisteredMeeting>> onFinishLoadListener, IOnErrorListener iBaseOnFinishListener);
}
