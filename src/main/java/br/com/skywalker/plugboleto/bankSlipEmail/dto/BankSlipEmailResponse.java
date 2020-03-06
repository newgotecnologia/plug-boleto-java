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
@AllArgsConstructor
@NoArgsConstructor

public class BankSlipEmailResponse extends Response<BankSlipEmailResponse> {
    @JsonProperty("situacao")
    private String situation;

    @JsonProperty("protocolo")
    private String protocol;

    public BankSlipEmailResponse(ResponseStatus status, String message, BankSlipEmailResponse data) {
        super(status, message, data);
    }
}

/*
Success Response example

{
  "_status": "sucesso",
  "_dados": {
    "situacao": "PROCESSANDO",
    "protocolo": "SkR1z8B-G"
  }
}
*/