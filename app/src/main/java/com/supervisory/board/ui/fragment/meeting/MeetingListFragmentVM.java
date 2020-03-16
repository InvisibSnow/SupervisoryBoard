package com.supervisory.board.ui.fragment.meeting;

import android.util.Log;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableBoolean;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.supervisory.board.model.meeting.RegisteredMeeting;
import com.supervisory.board.mvvm.MyFragmentViewModel;
import com.supervisory.board.ui.adapter.meeting.MeetingListAdapter;

import java.util.List;

public class MeetingListFragmentVM extends MyFragmentViewModel<MeetingListFragment>  {

    public MeetingListAdapter meetingListAdapter;
    public final ObservableBoolean isLoading = new ObservableBoolean();

    public MeetingListFragmentVM() {
        meetingListAdapter = new MeetingListAdapter();
    }

    void setRegisteredMeetingsData(List<RegisteredMeeting> dataList){
        Log.d("MyLOG","RegisteredMeeting set");
        meetingListAdapter.setDataList(dataList);
    }

    void setLoadingStatus(boolean status){
        isLoading.set(status);
    }

    @BindingAdapter("refresh")
    public static void setOnRefreshListener(SwipeRefreshLayout view, final MeetingListFragmentVM viewModel){
        view.setOnRefreshListener(() -> {
            viewModel.refreshData();
            view.setRefreshing(false);
        });
    }
}
