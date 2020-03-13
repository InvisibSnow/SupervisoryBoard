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
import com.supervisory.board.model.meeting.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionListAdapter  extends RecyclerView.Adapter<QuestionListAdapter.ViewHolder> {

    private List<Question> questionList = new ArrayList<>();

    @NonNull
    @Override
    public QuestionListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ViewDataBinding binding= DataBindingUtil.inflate(inflater, R.layout.item_question, parent,false);

        final QuestionListAdapter.ViewHolder holder = new QuestionListAdapter.ViewHolder(binding);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo Make with Interface
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionListAdapter.ViewHolder holder, int position) {
        final Question question = questionList.get(position);
        question.setNumberOfQuestion(position + 1);
        holder.bind(question);
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public void setDataList(List<Question> dataList){
        questionList.clear();
        if(dataList != null) {
            questionList.addAll(dataList);
        }
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ViewDataBinding binding;

        ViewHolder(ViewDataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.binding = dataBinding;
        }

        void bind(Question question){
            this.binding.setVariable(BR.item, question );
            this.binding.executePendingBindings();
        }
    }
}
