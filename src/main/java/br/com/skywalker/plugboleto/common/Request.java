package br.com.skywalker.plugboleto.common;

import lombok.RequiredArgsConstructor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

@RequiredArgsConstructor
public class Request<T> {

    private final Call<T> call;

    public T execute() {
        try {
            return convertResponse(call.execute());
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void enqueue(RequestCallback<T> callback) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                callback.onSuccess(convertResponse(response));
            }

            @Override
            public void onFailure(Call<T> call, Throwable throwable) {
                callback.onError(throwable);
            }
        });
    }

    public void cancel() {
        call.cancel();
    }

    protected T convertResponse(Response<T> response) {
        if (response.isSuccessful()) {
            return response.body();
        }

        if(response.errorBody() == null)
            throw new RuntimeException("Response wasn't successful, HTTP Erros: " + response.code() + " => without response body");
        else {
            try {
                throw new RuntimeException("Response wasn't successful, HTTP Erros: " + response.code() + "\n" + response.errorBody().string());
            } catch (IOException e){
                throw new RuntimeException("Response wasn't successful, HTTP Erros: " + response.code() + "\n => can't show the response body");
            }
        }
    }

}
