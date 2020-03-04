package br.com.skywalker.plugboleto.agreement.dto;

import br.com.skywalker.plugboleto.common.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.Call;

public class CreateAgreementRequest extends Request<CreateAgreementRequest> {
    @JsonProperty("ConvenioNumero")
    private String agreementNumber;

    @JsonProperty("ConvenioNumero")
    private String agreementDescription;

    @JsonProperty("ConvenioCarteira")
    private String agreementWallet;

    @JsonProperty("ConvenioEspecie")
    private String agreementCash;

    @JsonProperty("ConvenioPadraoCNAB")
    private String agreementCNABPattern;

    @JsonProperty("ConvenioNumeroRemessa")
    private String agreementShipmentNumber;

    @JsonProperty("ConvenioReiniciarDiariamente")
    private boolean agreementDailyReset;

    @JsonProperty("Conta")
    private String account;

    public CreateAgreementRequest(Call<CreateAgreementRequest> call) {
        super(call);
    }
}

/*
    "ConvenioNumero": "7889604745",
    "ConvenioDescricao": "Convenio da tecnospeed",
    "ConvenioCarteira": "109",
    "ConvenioEspecie": "R$",
    "ConvenioPadraoCNAB": "400",
    "ConvenioNumeroRemessa": "1",
    "ConvenioReiniciarDiariamente": false,
    "Conta": 168
*/
