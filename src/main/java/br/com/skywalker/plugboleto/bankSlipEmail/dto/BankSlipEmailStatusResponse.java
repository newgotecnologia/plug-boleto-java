package br.com.skywalker.plugboleto.bankSlipEmail.dto;

import br.com.skywalker.plugboleto.common.Response;
import br.com.skywalker.plugboleto.common.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class BankSlipEmailStatusResponse extends Response<BankSlipEmailStatusResponse> {
    @JsonProperty("situacao")
    private String situation;

    @JsonProperty("_mensagem")
    private String message;

    public BankSlipEmailStatusResponse(ResponseStatus status, String message, BankSlipEmailStatusResponse data) {
        super(status, message, data);
    }
}
