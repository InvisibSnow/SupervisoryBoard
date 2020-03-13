package com.supervisory.board.model;

import androidx.databinding.BaseObservable;

public class TestNotificationModel extends BaseObservable {

    private int notificationsCount;

    public TestNotificationModel(int notificationsCount) {
        this.notificationsCount = notificationsCount;
    }

    public boolean isCount(){
        return notificationsCount > 0;
    }

    public int getNotificationsCount() {
        return notificationsCount;
    }
}
