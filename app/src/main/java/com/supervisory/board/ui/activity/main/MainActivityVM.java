package com.supervisory.board.ui.activity.main;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.supervisory.board.R;
import com.supervisory.board.api.IOnFinishLoadListener;
import com.supervisory.board.model.TestNotificationModel;
import com.supervisory.board.model.meeting.RegisteredMeeting;
import com.supervisory.board.mvvm.MyActivityViewModel;
import com.supervisory.board.ui.activity.main.data.IMeetingsRepo;
import com.supervisory.board.ui.activity.main.data.MeetingsRepo;
import com.supervisory.board.ui.adapter.BasePagerAdapter;
import com.supervisory.board.ui.fragment.meeting.MeetingListFragment;
import com.supervisory.board.utils.Constants;

import java.util.List;

public class MainActivityVM extends MyActivityViewModel<MainActivity> implements IOnFinishLoadListener<List<RegisteredMeeting>> {

    private IMeetingsRepo iMeetingsRepo;

    public final ObservableField<TestNotificationModel> testModel = new ObservableField<>();
    public final MutableLiveData<List<RegisteredMeeting>> registeredMeetingList = new MutableLiveData<>();
    public final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public MainActivityVM() {
        iMeetingsRepo = new MeetingsRepo();
    }

    public void startSearch(){
        //todo Start search from server
    }

    public void refreshData(){
        registeredMeetingList.setValue(null);
        initMeetingList();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void initMeetingList(){
        Log.d("MyLOG","initMeetingList");
        if (registeredMeetingList.getValue() == null) {
            isLoading.setValue(true);
            iMeetingsRepo.getRegisteredMeetings(this, getOnErrorListener());
        } else {
            Log.d("MyLOG","MOT NULL");
        }
    }

    @Override
    public void onFinishedLoad(List<RegisteredMeeting> data) {
        isLoading.setValue(false);
        registeredMeetingList.setValue(data);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        iMeetingsRepo.cancelAllRequest();
    }

    @Override
    public void updateViewAfterDownloadsError() {
        isLoading.setValue(false);
    }

    @BindingAdapter({"setUpWithViewpager"})
    public static void bindViewPagerTabs(final TabLayout view, final ViewPager pagerView) {
        view.setupWithViewPager(pagerView, true);
    }

    @BindingAdapter("viewPager")
    public static void setViewPager(ViewPager viewPager, final MainActivityVM viewModel ){
        BasePagerAdapter pagerAdapter = new BasePagerAdapter(((AppCompatActivity)viewPager.getContext()).getSupportFragmentManager());

        pagerAdapter.addFragment(new MeetingListFragment(),viewPager.getContext().getString(R.string.text_current_meetings));
        pagerAdapter.addFragment(new MeetingListFragment(),viewPager.getContext().getString(R.string.text_archive_meetings));

        viewPager.setAdapter(pagerAdapter);
//        BasePagerAdapter pagerAdapter = new BasePagerAdapter(viewModel.fm);
//        for(ViewPagerFragment vpFragment: viewModel.fragmentList){
//            pagerAdapter.addFragment(vpFragment.getFragment(), vpFragment.getTitle());
//        }
//        viewPager.setOffscreenPageLimit(2);
//        viewPager.setAdapter(pagerAdapter);

    }

    protected String getListUrl(){
        return Constants.API_CURRENT_MEETINGS;
    }

}
