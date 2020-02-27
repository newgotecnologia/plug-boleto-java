package br.com.skywalker.plugboleto.bankSlip.dto;

import br.com.skywalker.plugboleto.common.Response;
import br.com.skywalker.plugboleto.common.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CreateBankSlipResponse extends Response<CreateBankSlipResponse> {
    @JsonProperty("_sucesso")
    private List<CreateBankSlipResponseSuccess> success;

    @JsonProperty("_falha")
    private List<CreateBankSlipResponseError> errors;

    public CreateBankSlipResponse(ResponseStatus status, String message, CreateBankSlipResponse data) {
        super(status, message, data);
    }
}
