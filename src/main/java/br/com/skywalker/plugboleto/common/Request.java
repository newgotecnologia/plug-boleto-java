package br.com.skywalker.plugboleto.common;

import br.com.skywalker.plugboleto.exception.ConvertionException;
import br.com.skywalker.plugboleto.exception.RequestFailed;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

@RequiredArgsConstructor
public class Request<T> {

    private final Call<T> call;

    public T execute(Class<T> type) throws RequestFailed, ConvertionException {
        try {
            return convertResponse(call.execute(), type);
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void enqueue(RequestCallback<T> callback, Class<T> type) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                try {
                    callback.onSuccess(convertResponse(response, type));
                } catch (RequestFailed | ConvertionException e) {
                    e.printStackTrace();
                }
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

    protected T convertResponse(Response<T> response, Class<T> type) throws RequestFailed, ConvertionException {
        if (response.isSuccessful()) {
            return response.body();
        }

        if(response.errorBody() == null) {
            throw new RequestFailed("Response wasn't successful, HTTP Error: " + response.code() +  " => without response body");
        }else {
            try {
                return new ObjectMapper().readValue(response.errorBody().string(), type);
            } catch (Exception e){
                e.printStackTrace();
                throw new ConvertionException("Response wasn't successful, HTTP Error: " + response.code() + " => can't convert the response body");
            }
        }
    }

}
