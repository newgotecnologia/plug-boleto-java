package br.com.skywalker.plugboleto.common;

import br.com.skywalker.plugboleto.exception.ConvertionException;
import br.com.skywalker.plugboleto.exception.RequestFailed;
import br.com.skywalker.plugboleto.exception.ValidationException;
import br.com.skywalker.plugboleto.util.GenericErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

@RequiredArgsConstructor
public class Request<T> {

    private final Call<T> call;

    public T execute() throws RequestFailed, ConvertionException, ValidationException {
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
                try {
                    callback.onSuccess(convertResponse(response));
                } catch (RequestFailed | ConvertionException | ValidationException | IOException e) {
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

    protected T convertResponse(Response<T> response) throws RequestFailed, ConvertionException, ValidationException, IOException {

        if (response.isSuccessful()) {
            return response.body();
        }

        if (response.errorBody() == null) {
            throw new RequestFailed("Response wasn't successful, HTTP Error: " + response.code() + " => without response body");
        } else {
            try {
                System.out.println(response.errorBody().string());
                throw new ValidationException("There is a validation error in your request", new ObjectMapper().readValue(response.errorBody().string(), GenericErrorResponse.class));
            } catch (IOException parseException) {
                parseException.printStackTrace();
                throw new ConvertionException("Response wasn't successful, HTTP Error: " + response.code() + " => can't convert the response body");
            }
        }
    }

}
