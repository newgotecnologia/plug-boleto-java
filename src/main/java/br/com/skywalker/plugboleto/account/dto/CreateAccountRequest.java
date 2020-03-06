package br.com.skywalker.plugboleto.account.dto;

import br.com.skywalker.plugboleto.common.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import retrofit2.Call;

@Getter
@Builder

public class CreateAccountRequest extends Request<CreateAccountRequest> {
    @JsonProperty("ContaCodigoBanco")
    private String accountBankCode;

    @JsonProperty("ContaAgencia")
    private String accountBankBranch;

    @JsonProperty("ContaAgenciaDV")
    private String accountBankBranchVerificationDigit;

    @JsonProperty("ContaNumero")
    private String accountNumber;

    @JsonProperty("ContaNumeroDV")
    private String accountNumberVerificationDigit;

    @JsonProperty("ContaTipo")
    private String accountType;

    @JsonProperty("ContaCodigoBeneficiario")
    private String accountDrawerCode;

    @JsonProperty("ContaCodigoEmpresa")
    private String accountCompanyCode;

    @JsonProperty("ContaValidacaoAtiva")
    private boolean accountActiveValidation;

    @JsonProperty("ContaImpressaoAtualizada")
    private boolean accountPrintUpdate;

    public CreateAccountRequest(Call<CreateAccountRequest> call) {
        super(call);
    }
}

/*
    "ContaCodigoBanco": "341",
    "ContaAgencia": "1234",
    "ContaAgenciaDV": "1",
    "ContaNumero": "59698",
    "ContaNumeroDV": "3",
    "ContaTipo": "CORRENTE",
    "ContaCodigoBeneficiario": "60473",
    "ContaCodigoEmpresa": "12434", => If is Bradesco bank this field is mandatory
    "ContaValidacaoAtiva": false,
    "ContaImpressaoAtualizada": false
*/
