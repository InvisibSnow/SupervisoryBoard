package com.supervisory.board.api;

public interface IOnErrorListener {
    void onFailure(String error);
    void onFailure(Throwable throwable);
    void errorToken();
}
