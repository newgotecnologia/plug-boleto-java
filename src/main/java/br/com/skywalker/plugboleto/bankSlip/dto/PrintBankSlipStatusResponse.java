package br.com.skywalker.plugboleto.bankSlip.dto;

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

public class PrintBankSlipStatusResponse extends Response<PrintBankSlipStatusResponse> {
    @JsonProperty("situacao")
    private String situation;

    public PrintBankSlipStatusResponse(ResponseStatus status, String message, PrintBankSlipStatusResponse data) {
        super(status, message, data);
    }
}

/*
    "situacao": "PROCESSANDO"
*/
