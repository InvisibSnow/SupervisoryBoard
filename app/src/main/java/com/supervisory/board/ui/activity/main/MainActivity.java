package com.supervisory.board.ui.activity.main;

import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.ViewModelProvider;

import com.supervisory.board.R;
import com.supervisory.board.databinding.ActivityMainBinding;
import com.supervisory.board.mvvm.MyBindingActivity;

public class MainActivity extends MyBindingActivity<ActivityMainBinding, MainActivityVM> {


    @Override
    public MainActivityVM onCreate() {
        return new ViewModelProvider(this).get(MainActivityVM.class);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
