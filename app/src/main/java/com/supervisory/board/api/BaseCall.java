package com.supervisory.board.api;

import androidx.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseCall<T> {

    public BaseCall() {
    }

    public void retrofitCall(Call<T> call, IOnFinishLoadListener<T> iOnFinishLoadListener, IOnErrorListener iOnErrorListener) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                if (response.isSuccessful() && response.body() != null) {
                    iOnFinishLoadListener.onFinishedLoad(response.body());
                } else if (response.code() == 401) {
                    iOnErrorListener.errorToken();
                } else {
                    iOnErrorListener.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                if (!call.isCanceled()) {
                    iOnErrorListener.onFailure(t);
                }
            }
        });
    }

    public void retrofitListCall(Call<List<T>> call, IOnFinishLoadListener<List<T>> iOnFinishLoadListener, IOnErrorListener iOnErrorListener) {
        call.enqueue(new Callback<List<T>>() {
            @Override
            public void onResponse(@NonNull Call<List<T>> call, @NonNull Response<List<T>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    iOnFinishLoadListener.onFinishedLoad(response.body());
                } else if (response.code() == 401) {
                    iOnErrorListener.errorToken();
                } else {
                    iOnErrorListener.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<T>> call, @NonNull Throwable t) {
                if (!call.isCanceled()) {
                    iOnErrorListener.onFailure(t);
                }
            }
        });
    }
}
