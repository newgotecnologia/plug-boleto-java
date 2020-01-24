package br.com.skywalker.plugboleto.common;

public interface RequestCallback<T> {
    void onSuccess(T result);
    void onError(Throwable throwable);
}
