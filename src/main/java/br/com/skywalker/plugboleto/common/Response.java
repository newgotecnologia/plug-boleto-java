package br.com.skywalker.plugboleto.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Response<T> {

    @JsonProperty("_status")
    private ResponseStatus status;

    @JsonProperty("_mensagem")
    private String message;

    @JsonProperty("_dados")
    private T data;

}
