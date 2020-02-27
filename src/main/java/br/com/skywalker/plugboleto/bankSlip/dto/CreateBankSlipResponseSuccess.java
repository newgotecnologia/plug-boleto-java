package br.com.skywalker.plugboleto.bankSlip.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateBankSlipResponseSuccess {
    @JsonProperty("idintegracao")
    private String idIntegration;

    @JsonProperty("situacao")
    private String situation;

    @JsonProperty("TituloNumeroDocumento")
    private String titleDocumentNumber;

    @JsonProperty("TituloNossoNumero")
    private String titleOurNumber;

    @JsonProperty("CedenteContaCodigoBanco")
    private String assignorBankAccountCode;

    @JsonProperty("CedenteContaNumero")
    private String assignorAccountNumber;

    @JsonProperty("CedenteConvenioNumero")
    private String assignorAgreementNumber;
}

/*
This is an example of a success response from a create bank slip request
"_sucesso": [
    {
        "idintegracao": "H1-vGuYDul",
        "situacao": "SALVO",
        "TituloNumeroDocumento": "01012020",
        "TituloNossoNumero": "6",
        "CedenteContaCodigoBanco": "341",
        "CedenteContaNumero": "54321",
        "CedenteConvenioNumero": "321"
    }
]
*/
