package com.supervisory.board.ui.adapter.meeting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.supervisory.board.R;
import com.supervisory.board.model.meeting.RegisteredMeeting;

import java.util.ArrayList;
import java.util.List;

public class MeetingListAdapter extends RecyclerView.Adapter<MeetingListAdapter.ViewHolder> {

    private List<RegisteredMeeting> registeredMeetingList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ViewDataBinding binding= DataBindingUtil.inflate(inflater, R.layout.item_meeting, parent,false);

        final ViewHolder holder = new ViewHolder(binding);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo Make with Interface
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RegisteredMeeting registeredMeeting = registeredMeetingList.get(position);
        holder.bind(registeredMeeting);
    }

    @Override
    public int getItemCount() {
        return registeredMeetingList.size();
    }

    public void setDataList(List<RegisteredMeeting> dataList){
        registeredMeetingList.clear();
        if(dataList != null) {
            registeredMeetingList.addAll(dataList);
        }
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ViewDataBinding binding;

        ViewHolder(ViewDataBinding dataBinding) {
          super(dataBinding.getRoot());
          this.binding = dataBinding;
        }

        void bind(RegisteredMeeting registeredMeeting){
            this.binding.setVariable(BR.item, registeredMeeting );
            this.binding.executePendingBindings();
        }
    }

}
