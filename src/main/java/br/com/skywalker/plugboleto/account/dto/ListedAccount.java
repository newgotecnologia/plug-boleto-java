package br.com.skywalker.plugboleto.account.dto;

import br.com.skywalker.plugboleto.agreement.dto.ListedAgreement;
import br.com.skywalker.plugboleto.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class ListedAccount {
    @JsonProperty("id")
    private long id;

    @JsonProperty("codigo_banco")
    private String accountBankCode;

    @JsonProperty("codigo_banco_correspondente")
    private String correspondingBankCode;

    @JsonProperty("agencia")
    private String accountBankBranch;

    @JsonProperty("agencia_dv")
    private String accountBankBranchVerificationDigit;

    @JsonProperty("conta")
    private String accountNumber;

    @JsonProperty("conta_dv")
    private String accountNumberVerificationDigit;

    @JsonProperty("tipo_conta")
    private String accountType;

    @JsonProperty("cod_beneficiario")
    private String accountDrawer;

    @JsonProperty("cod_beneficiario")
    private String accountDrawerCode;

    @JsonProperty("id_cedente")
    private String assignorId;

    @JsonProperty("criado")
    @JsonFormat(pattern = DateUtil.DATE_TIME_OFFSET_ISO_FORMAT)
    private LocalDateTime creationDate;

    @JsonProperty("atualizado")
    @JsonFormat(pattern = DateUtil.DATE_TIME_OFFSET_ISO_FORMAT)
    private LocalDateTime lastUpdate;

    @JsonProperty("cod_empresa")
    private String accountCompanyCode;

    @JsonProperty("ativo")
    private boolean active;

    @JsonProperty("validacao_ativa")
    private boolean accountActiveValidation;

    @JsonProperty("impressao_atualizada")
    private boolean accountPrintUpdate;

    @JsonProperty("convenios")
    private List<ListedAgreement> accountAgreements;
}

/*
    "id": 5259,
    "codigo_banco": "001",
    "codigo_banco_correspondente": null,
    "agencia": "12345",
    "agencia_dv": "1",
    "conta": "596989",
    "conta_dv": "9",
    "tipo_conta": "CORRENTE",
    "cod_beneficiario": "596989",
    "id_cedente": 41,
    "criado": "2019-08-13T00:03:58.000Z",
    "atualizado": "2019-08-13T00:03:58.000Z",
    "cod_empresa": null,
    "ativo": true,
    "validacao_ativa": true,
    "impressao_atualizada": false,
"convenios": []
*/