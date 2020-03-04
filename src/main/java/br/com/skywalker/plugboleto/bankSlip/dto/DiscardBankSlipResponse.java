package br.com.skywalker.plugboleto.bankSlip.dto;

import br.com.skywalker.plugboleto.common.Response;
import br.com.skywalker.plugboleto.common.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DiscardBankSlipResponse extends Response<DiscardBankSlipResponse> {
    @JsonProperty("_sucesso")
    private List<DiscardBankSlipSuccessResponse> successes;

    @JsonProperty("_falha")
    private List<DiscardBankSlipFailureResponse> failures;

    public DiscardBankSlipResponse(ResponseStatus status, String message, DiscardBankSlipResponse data) {
        super(status, message, data);
    }
}

class DiscardBankSlipSuccessResponse {
    @JsonProperty("idintegracao")
    private String integrationId;
}

class DiscardBankSlipFailureResponse {
    @JsonProperty("idintegracao")
    private String integrationId;

    @JsonProperty("_erro")
    private String error;

    @JsonProperty("_status_http")
    private String httpStatus;
}

/*
    "_sucesso": [
      {
        "idintegracao": "BJSdV7dYz"
      }
    ],
    "_falha": [
      {
        "idintegracao": "BJSdV7dYz",
        "_erro": "Boleto não encontrado",
        "_status_http": 404
      }
    ]
*/