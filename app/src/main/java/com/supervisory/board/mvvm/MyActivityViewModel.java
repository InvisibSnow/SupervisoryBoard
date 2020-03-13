package com.supervisory.board.mvvm;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.supervisory.board.api.IOnErrorListener;

import static com.supervisory.board.mvvm.MyBindingFragment.ERROR_TOKEN_ACTION;

public class MyActivityViewModel<A extends AppCompatActivity> extends ViewModel implements IOnErrorListener, LifecycleObserver {

    protected MutableLiveData<String> data;
    private MutableLiveData<Throwable> errorData;
    private MutableLiveData<String> errorServiceData;

    public final ObservableField<String> searchText = new ObservableField<String>(){
        @Override
        public void set(String value) {
            super.set(value);
            if(value.length()==3){
                startSearch(value);
            }
        }
    };

    protected A activity;

    public MyActivityViewModel(A activity) {
        this.activity = activity;
    }

    public MyActivityViewModel() {
    }

    public A getActivity() {
        return activity;
    }

    /**
     * Activity lifecycle
     */
    public boolean onBackKeyPress() {
        return false;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

    }

    public void onPostCreate(Bundle savedInstanceState) {

    }

    public void onOptionsItemSelected(MenuItem item) {

    }

    public void onConfigurationChanged(Configuration newConfig) {

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    public void onSaveInstanceState(Bundle outState){

    }

    public void onCreateOptionsMenu(Menu menu) {

    }

    public void onPrepareOptionsMenu(Menu menu){

    }

    public void onWindowFocusChanged(boolean hasFocus){

    }

    /**
     * -----------------------
     */

    protected IOnErrorListener getOnErrorListener(){
        return this;
    }



    public LiveData<String> getData() {
        data = new MutableLiveData<>();
        return data;
    }

    public LiveData<Throwable> getErrorData() {
        errorData = new MutableLiveData<>();
        return errorData;
    }

    public LiveData<String> getErrorServiceData() {
        errorServiceData = new MutableLiveData<>();
        return errorServiceData;
    }

    @Override
    public void onFailure(String error) {
        errorServiceData.postValue(error);
        updateViewAfterDownloadsError();
    }

    @Override
    public void onFailure(Throwable throwable) {
        errorData.postValue(throwable);
        updateViewAfterDownloadsError();
    }

    @Override
    public void errorToken() {
        data.postValue(ERROR_TOKEN_ACTION);
        updateViewAfterDownloadsError();
    }

    public void updateViewAfterDownloadsError(){}

    public void startSearch(String searchText){
    }
}
