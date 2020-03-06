package br.com.skywalker.plugboleto.bankSlip.dto;

import br.com.skywalker.plugboleto.common.Response;
import br.com.skywalker.plugboleto.common.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class ShippingFileResponse extends Response<ShippingFileResponse> {
    @JsonProperty("_sucesso")
    private List<String> successes;

    @JsonProperty("_falha")
    private List<String> failures;

    public ShippingFileResponse(ResponseStatus status, String message, ShippingFileResponse data) {
        super(status, message, data);
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

class ShippingFileSuccessResponse {
    @JsonProperty("CedenteContaCodigoBanco")
    private String assignorAccountBankCode;

    @JsonProperty("CedenteContaNumero")
    private String assignorAccountNumber;

    @JsonProperty("CedenteConvenioNumero")
    private String assignorAgreementNumber;

    @JsonProperty("arquivo")
    private String archive;

    @JsonProperty("situacao")
    private String situation;

    @JsonProperty("transmissaoAutomatica")
    private boolean automaticTransmission;

    @JsonProperty("remessa")
    private byte[] shipping;

    @JsonProperty("mensagem")
    private String message;

    @JsonProperty("numero")
    private int number;

    @JsonProperty("titulos")
    private List<ShippingFileSuccessTitleResponse> titles;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

class ShippingFileSuccessTitleResponse {
    @JsonProperty("idintegracao")
    private String integrationId;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

class ShippingFileFailureResponse {
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
        "numero": 6,
        "arquivo": "COB_341_543210_040320_00006.rem",
        "remessa": [Arquivo de remessa em base64],
        "titulos": [
          {
            "idintegracao": "GN3JpjxPq"
          }
        ],
        "mensagem": "Remessa gerada com sucesso",
        "situacao": "GERADA",
        "CedenteContaNumero": "54321",
        "CedenteConvenioNumero": "321",
        "transmissaoAutomatica": false,
        "CedenteContaCodigoBanco": "341"
      }
    ],
    "_falha": [
      {
        "_erro": "Boleto não encontrado.",
        "_status_http": 404,
        "idintegracao": "asdasdasdasdasd"
      }
    ]
*/
