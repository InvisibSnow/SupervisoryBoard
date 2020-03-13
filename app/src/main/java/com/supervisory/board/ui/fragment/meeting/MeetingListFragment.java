package com.supervisory.board.ui.fragment.meeting;

import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.ViewModelProvider;

import com.supervisory.board.R;
import com.supervisory.board.databinding.FragmentMeetingListBinding;
import com.supervisory.board.mvvm.MyBindingFragment;
import com.supervisory.board.ui.activity.main.MainActivityVM;

public class MeetingListFragment extends MyBindingFragment<MeetingListFragmentVM, FragmentMeetingListBinding> {

    private MeetingListFragmentVM meetingListFragmentVM;
    private MainActivityVM mainActivityVM;

    @Override
    protected MeetingListFragmentVM onCreateViewModel(FragmentMeetingListBinding binding) {
        meetingListFragmentVM = new ViewModelProvider(this).get(MeetingListFragmentVM.class);
        mainActivityVM = new ViewModelProvider(requireActivity()).get(MainActivityVM.class);
        subscribeMeetingList();
        return meetingListFragmentVM;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_meeting_list;
    }

    private void subscribeMeetingList(){
        mainActivityVM.registeredMeetingList.observe(
                requireActivity(), registeredMeetings -> {
                        meetingListFragmentVM.setRegisteredMeetingsData(registeredMeetings);
                }
        );

        mainActivityVM.isLoading.observe(
                requireActivity(), loading -> meetingListFragmentVM.setLoadingStatus(loading)
        );
    }

    @Override
    public void refreshData() {
        mainActivityVM.refreshData();
    }
}
