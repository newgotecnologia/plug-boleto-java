package br.com.skywalker.plugboleto.bankSlip.dto;

import br.com.skywalker.plugboleto.common.Response;
import br.com.skywalker.plugboleto.common.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericProtocolResponse extends Response<GenericProtocolResponse> {
    @JsonProperty("situacao")
    private String situation;

    @JsonProperty("protocolo")
    private String protocol;

    @JsonProperty("_campo")
    private String field;

    @JsonProperty("_erro")
    private String error;

    public GenericProtocolResponse(ResponseStatus status, String message, GenericProtocolResponse data) {
        super(status, message, data);
    }
}

/*
Success response body
    "situacao": "PROCESSANDO",
    "protocolo": "SkR1z8B-G"

Error response body
    "_campo": "corpo_requisicao",
    "_erro": "O corpo da requisição deve ser um array de IDs de integração.",
*/