package br.com.skywalker.plugboleto.util;

import br.com.skywalker.plugboleto.common.Response;
import br.com.skywalker.plugboleto.common.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericErrorResponse {
    @JsonProperty("_status")
    private ResponseStatus status;

    @JsonProperty("_mensagem")
    private String message;

    @JsonProperty("_dados")
    private List<GenericErrorResponseData> data;

    public String getErrorMessages(){
        StringBuilder messages = new StringBuilder();
        for(GenericErrorResponseData data : this.data){
            messages.append(data.errorMessage).append("\n");
        }

        return messages.toString();
    }

    @Getter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GenericErrorResponseData {
        @JsonProperty("_campo")
        private String errorField;

        @JsonProperty("_erro")
        private String errorMessage;
    }
}