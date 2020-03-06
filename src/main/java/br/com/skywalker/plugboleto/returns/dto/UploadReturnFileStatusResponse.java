package br.com.skywalker.plugboleto.returns.dto;

import br.com.skywalker.plugboleto.common.Response;
import br.com.skywalker.plugboleto.common.ResponseStatus;
import br.com.skywalker.plugboleto.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UploadReturnFileStatusResponse extends Response<UploadReturnFileStatusResponse> {
    @JsonProperty("situacao")
    private String situation;

    @JsonProperty("mensagem")
    private String message;

    @JsonProperty("processados")
    private long processed;

    @JsonProperty("titulos")
    private List<UploadReturnFileStatusTitleResponse> titles;

    @JsonProperty("titulosNaoConciliados")
    private List<UploadReturnFileStatusTitleNonReconciledResponse> titlesNonReconciled;

    public UploadReturnFileStatusResponse(ResponseStatus status, String message, UploadReturnFileStatusResponse data) {
        super(status, message, data);
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

class UploadReturnFileStatusTitleResponse {
    @JsonProperty("idIntegracao")
    private String integrationId;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

class UploadReturnFileStatusTitleNonReconciledResponse {
    @JsonProperty("Ocorrencias")
    private Map<String, String> occurrences;

    @JsonProperty("CodigosOcorrencias")
    private List<String> occurrenceCodes;

    @JsonProperty("CodigoMovimento")
    private List<String> movementCode;

    @JsonProperty("TituloNossoNumero")
    private String titleOurNumber;

    @JsonProperty("TituloNossoNumeroOriginal")
    private String titleOurNumberOriginal;

    @JsonProperty("TituloDataVencimento")
    @JsonFormat(pattern = DateUtil.DATE_TECNOSPEED_PATTERN)
    private LocalDate titleExpirationDate;

    @JsonProperty("PagamentoValorPago")
    private String paymentAmountPaid;

    @JsonProperty("PagamentoValorCredito")
    private String paymentCreditAmount;

    @JsonProperty("PagamentoValorTaxaCobranca")
    private String paymentChargeFeeAmount;

    @JsonProperty("PagamentoValorAcrescimos")
    private String paymentAdditionsAmount;

    @JsonProperty("PagamentoData")
    @JsonFormat(pattern = DateUtil.DATE_TECNOSPEED_PATTERN)
    private LocalDate paymentDate;

    @JsonProperty("PagamentoDataCredito")
    @JsonFormat(pattern = DateUtil.DATE_TECNOSPEED_PATTERN)
    private LocalDate paymentCreditDate;

    @JsonProperty("PagamentoRealizado")
    private boolean paymentMade;

    @JsonProperty("TituloNumeroDocumento")
    private String titleDocumentNumber;
}

/*
    "situacao": "PROCESSADO",
    "mensagem": "",
    "processados": 2,
    "titulos": [
      {
        "idIntegracao": "HyNyGOtj-"
      },
      {
        "idIntegracao": "B1lBl1v5j-"
      }
    ],
    "titulosNaoConciliados": [
      {
        "Ocorrencias": [
          "Movimento: Liquidação normal"
        ],
        "CodigosOcorrencias": [],
        "CodigoMovimento": "06",
        "TituloNossoNumero": "03300000780",
        "TituloNossoNumeroOriginal": "3300000780",
        "TituloDataVencimento": "02/10/2017",
        "PagamentoValorPago": "427,81",
        "PagamentoValorCredito": "0,00",
        "PagamentoValorTaxaCobranca": "0,00",
        "PagamentoValorAcrescimos": "0,00",
        "PagamentoData": "20/09/2017",
        "PagamentoDataCredito": "20/09/2017",
        "PagamentoRealizado": true,
        "TituloNumeroDocumento": "1020"
      }
    ]
*/
