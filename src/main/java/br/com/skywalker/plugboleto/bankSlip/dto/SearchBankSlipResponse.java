package br.com.skywalker.plugboleto.bankSlip.dto;

import br.com.skywalker.plugboleto.common.PagedResponse;
import br.com.skywalker.plugboleto.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.Call;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

public class SearchBankSlipResponse extends PagedResponse<SearchBankSlipResponse> {
    @JsonProperty("IdIntegracao")
    private String integrationId;

    @JsonProperty("SacadoCPFCNPJ")
    private String drawerFederalId;

    @JsonProperty("SacadoEmail")
    private String drawerEmail;

    @JsonProperty("SacadoEnderecoNumero")
    private String drawerAddressNumber;

    @JsonProperty("SacadoEnderecoBairro")
    private String drawerAddressNeighborhood;

    @JsonProperty("SacadoEnderecoCEP")
    private String drawerAddressZipCode;

    @JsonProperty("SacadoEnderecoCidade")
    private String drawerAddressCity;

    @JsonProperty("SacadoEnderecoComplemento")
    private String drawerAddressComplement;

    @JsonProperty("SacadoEnderecoLogradouro")
    private String drawerAddressPlace;

    @JsonProperty("SacadoEnderecoPais")
    private String drawerAddressCountry;

    @JsonProperty("SacadoEnderecoUF")
    private String drawerAddressStateAcronym;

    @JsonProperty("SacadoNome")
    private String drawerName;

    @JsonProperty("SacadoTelefone")
    private String drawerPhone;

    @JsonProperty("TituloDataDesconto")
    private String titleDiscountDate;

    @JsonProperty("TituloDataEmissao")
    private String titleIssueDate;

    @JsonProperty("TituloDataVencimento")
    private String titleExpirationDate;

    @JsonProperty("TituloDataMulta")
    private String titleFineDate;

    @JsonProperty("PagamentoData")
    private String paymentDate;

    @JsonProperty("PagamentoDataCredito")
    private String creditPaymentDate;

    @JsonProperty("TituloPrazoProtesto")
    private String titleProtestTerm;

    @JsonProperty("TituloMensagem01")
    private String titleMessage1;

    @JsonProperty("TituloMensagem02")
    private String titleMessage2;

    @JsonProperty("TituloMensagem03")
    private String titleMessage3;

    @JsonProperty("TituloOcorrencias")
    private List<TitleOccurrence> titleOccurrences;

    @JsonProperty("TituloMovimentos")
    private List<TitleMovements> titleMovements;

    @JsonProperty("TituloNossoNumero")
    private String titleOurNumber;

    @JsonProperty("TituloNumeroDocumento")
    private String titleDocumentNumber;

    @JsonProperty("TituloOrigemDocumento")
    private String titleDocumentOrigin;

    @JsonProperty("PagamentoRealizado")
    private String paymentMade;

    @JsonProperty("TituloValorJuros")
    private String titleInterestAmount;

    @JsonProperty("TituloInstrucao1")
    private String titleInstruction1;

    @JsonProperty("TituloInstrucao2")
    private String titleInstruction2;

    @JsonProperty("PagamentoValorCredito")
    private String creditPaymentAmount;

    @JsonProperty("TituloValorDesconto")
    private String titleDiscountAmount;

    @JsonProperty("TituloValorOutrosAcrescimos")
    private String titleOtherAdditionsAmount;

    @JsonProperty("TituloValorMulta")
    private String titleFineAmount;

    @JsonProperty("TituloValorMultaTaxa")
    private String titleFineFeeAmount;

    @JsonProperty("PagamentoValorPago")
    private String paymentAmountPaid;

    @JsonProperty("PagamentoValorTaxaCobranca")
    private String paymentChargeFeeAmount;

    @JsonProperty("TituloValorAbatimento")
    private String titleSlaughterAmount;

    @JsonProperty("PagamentoValorOutrasDespesas")
    private String paymentOtherExpensesAmount;

    @JsonProperty("PagamentoValorIOF")
    private String paymentIOFAmount;

    @JsonProperty("PagamentoValorOutrosCreditos")
    private String paymentOtherCreditsAmount;

    @JsonProperty("TituloValor")
    private String titleAmount;

    @JsonProperty("situacao")
    private String situation;

    @JsonProperty("impressao_visualizada")
    private String viewedImpression;

    @JsonProperty("motivo")
    private String reason;

    @JsonProperty("PagamentoValorDesconto")
    private String paymentDiscountAmount;

    @JsonProperty("PagamentoValorAcrescimos")
    private String paymentAdditionsAmount;

    @JsonProperty("PagamentoValorAbatimento")
    private String paymentRebatesAmount;

    @JsonProperty("CedenteAgencia")
    private String assignorAgency;

    @JsonProperty("CedenteAgenciaDV")
    private String assignorAgencyVerificationDigit;

    @JsonProperty("CedenteCodigoBanco")
    private String assignorBankCode;

    @JsonProperty("CedenteConta")
    private String assignorAccount;

    @JsonProperty("CedenteCarteira")
    private String assignorWallet;

    @JsonProperty("CedenteNumeroConvenio")
    private String assignorAgreementNumber;

    public SearchBankSlipResponse(Function<String, Call<? extends PagedResponse<SearchBankSlipResponse>>> pageProvider) {
        super(pageProvider);
    }
}

class TitleOccurrence {
    @JsonProperty("codigo")
    private String code;

    @JsonProperty("mensagem")
    private String message;

    @JsonProperty("criado")
    @JsonFormat(pattern = DateUtil.DATE_TIME_OFFSET_ISO_FORMAT)
    private LocalDateTime creationDate;

    @JsonProperty("atualizado")
    @JsonFormat(pattern = DateUtil.DATE_TIME_OFFSET_ISO_FORMAT)
    private LocalDateTime lastUpdate;
}

class TitleMovements {
    @JsonProperty("codigo")
    private String code;

    @JsonProperty("mensagem")
    private String message;

    @JsonProperty("data")
    @JsonFormat(pattern = DateUtil.DATE_TIME_TECNOSPEED_PATTERN)
    private LocalDateTime date;

    @JsonProperty("ocorrencias")
    private List<TitleMovementOccurrence> occurrences;
}

class TitleMovementOccurrence {
    @JsonProperty("codigo")
    private String code;

    @JsonProperty("mensagem")
    private String message;
}

/*
Response example from a BankSlip query
{
  "_status": "sucesso",
  "_dados": [
    {
      "IdIntegracao": "HkgMri2cHl",
      "SacadoCPFCNPJ": "28436161661",
      "SacadoEmail": "email@sacado.com",
      "SacadoEnderecoNumero": "987",
      "SacadoEnderecoBairro": "Centro",
      "SacadoEnderecoCEP": "87098765",
      "SacadoEnderecoCidade": "Maringá",
      "SacadoEnderecoComplemento": "Fundos",
      "SacadoEnderecoLogradouro": "Rua teste, 987",
      "SacadoEnderecoPais": "Brasil",
      "SacadoEnderecoUF": "PR",
      "SacadoNome": "Teste de Souza",
      "SacadoTelefone": "4499999999",
      "TituloDataDesconto": "05/01/2020 00:00:00",
      "TituloDataEmissao": "01/01/2020 00:00:00",
      "TituloDataVencimento": "01/01/2020 00:00:00",
      "TituloDataMulta": null,
      "PagamentoData": null,
      "PagamentoDataCredito": null,
      "TituloPrazoProtesto": "30",
      "TituloMensagem01": "Juros de 0,01 ao dia",
      "TituloMensagem02": "Nao receber apos 30 dias de atraso",
      "TituloMensagem03": "Titulo sujeito a protesto apos 30 dias",
      "TituloOcorrencias": [
        {
          "codigo": "02",
          "mensagem": "Tarifa de Manutenção de Título Vencido",
          "criado": "2018-06-29T18:45:22.000Z",
          "atualizado": "2018-06-29T18:45:22.000Z"
        },
        {
          "codigo": "03",
          "mensagem": "Liquidação no Guichê de Caixa em Dinheiro",
          "criado": "2018-06-29T18:45:22.000Z",
          "atualizado": "2018-06-29T18:45:22.000Z"
        },
        {
          "codigo": "06",
          "mensagem": "Movimento: Liquidação",
          "criado": "2018-06-29T18:45:22.000Z",
          "atualizado": "2018-06-29T18:45:22.000Z"
        },
        {
          "codigo": "28",
          "mensagem": "Movimento: Débito de Tarifas/Custas",
          "criado": "2018-06-29T18:45:22.000Z",
          "atualizado": "2018-06-29T18:45:22.000Z"
        }
      ],
      "TituloMovimentos": [
        {
          "codigo": "28",
          "mensagem": "Movimento: Débito de Tarifas/Custas",
          "data": "04/05/2018 00:00:00",
          "ocorrencias": [
            {
              "codigo": "02",
              "mensagem": "Tarifa de Manutenção de Título Vencido"
            }
          ]
        },
        {
          "codigo": "06",
          "mensagem": "Movimento: Liquidação",
          "data": "04/05/2018 00:00:00",
          "ocorrencias": [
            {
              "codigo": "03",
              "mensagem": "Liquidação no Guichê de Caixa em Dinheiro"
            }
          ]
        }
      ],
      "TituloNossoNumero": "1",
      "TituloNumeroDocumento": "01012020",
      "TituloOrigemDocumento": null,
      "PagamentoRealizado": null,
      "TituloValorJuros": "0,01",
      "TituloInstrucao1": "04",
      "TituloInstrucao2": "05",
      "PagamentoValorCredito": "0,00",
      "TituloValorDesconto": "0,01",
      "TituloValorOutrosAcrescimos": "0,00",
      "TituloValorMulta": "0,00",
      "TituloValorMultaTaxa": "0,00",
      "PagamentoValorPago": "0,00",
      "PagamentoValorTaxaCobranca": "0,00",
      "TituloValorAbatimento": "0,00",
      "PagamentoValorOutrasDespesas": "0,00",
      "PagamentoValorIOF": "0,00",
      "PagamentoValorOutrosCreditos": "0,00",
      "TituloValor": "0,02",
      "situacao": "LIQUIDADO",
      "impressao_visualizada": false,
      "motivo": null,
      "PagamentoValorDesconto": "0,00",
      "PagamentoValorAcrescimos": "0,00",
      "PagamentoValorAbatimento": "0,00",
      "CedenteAgencia": "4321",
      "CedenteAgenciaDV": null,
      "CedenteCodigoBanco": "341",
      "CedenteConta": "54321",
      "CedenteCarteira": "109",
      "CedenteNumeroConvenio": "321"
    }
  ],
  "_meta": {
    "_itens_por_pagina": 20,
    "_paginacao": {
      "_proximo": false,
      "_anterior": false
    },
    "_total": 1
  }
}
*/
