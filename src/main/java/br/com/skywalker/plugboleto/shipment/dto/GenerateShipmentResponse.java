package br.com.skywalker.plugboleto.shipment.dto;

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

public class GenerateShipmentResponse extends Response<GenerateShipmentResponse> {
    @JsonProperty("_sucesso")
    private List<GenerateShipmentSuccessResponse> successes;

    @JsonProperty("_falha")
    private List<GenerateShipmentFailureResponse> failures;

    public GenerateShipmentResponse(ResponseStatus status, String message, GenerateShipmentResponse data) {
        super(status, message, data);
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

class GenerateShipmentSuccessResponse {
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
    private String automaticTransmission;

    @JsonProperty("remessa")
    private byte[] shipment;

    @JsonProperty("mensagem")
    private String message;

    @JsonProperty("numero")
    private long number;

    @JsonProperty("titulos")
    private GenerateShipmentSuccessTitleResponse titles;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

class GenerateShipmentSuccessTitleResponse {
    @JsonProperty("idintegracao")
    private String integrationId;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

class GenerateShipmentFailureResponse {
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
    "CedenteContaCodigoBanco": "341",
    "CedenteContaNumero": "12345",
    "CedenteConvenioNumero": "1234",
    "arquivo": "COB_341_123456_021019_00001.rem",
    "situacao": "GERADA",
    "transmissaoAutomatica": false,
    "remessa": "[base64 contendo o arquivo de remessa]",
    "mensagem": "Remessa gerada com sucesso",
    "numero": 1,
    "titulos": [
      {
        "idintegracao": "eAcvWSIfw"
      }
    ]
  }
],
"_falha": [
 "idintegracao": "IdIntegracao4",
 "_erro": "Boleto não encontrado.",
 "_status_http": "404",
]
*/
