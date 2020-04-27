package br.com.skywalker.plugboleto.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {
    @JsonProperty("_status")
    private ResponseStatus status;

    @JsonProperty("_mensagem")
    private String message;

    @JsonProperty("_dados")
    private T data;

    public Response(ResponseStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
