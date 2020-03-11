package br.com.skywalker.plugboleto.bankSlip.dto;

import br.com.skywalker.plugboleto.common.Response;
import br.com.skywalker.plugboleto.common.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor

public class CreateBankSlipResponse extends Response<CreateBankSlipResponse> {
    @JsonProperty("_sucesso")
    private List<CreateBankSlipResponseSuccess> success;

    @JsonProperty("_falha")
    private List<CreateBankSlipResponseError> errors;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CreateBankSlipResponseSuccess {
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
    "idintegracao": "H1-vGuYDul",
    "situacao": "SALVO",
    "TituloNumeroDocumento": "01012020",
    "TituloNossoNumero": "6",
    "CedenteContaCodigoBanco": "341",
    "CedenteContaNumero": "54321",
    "CedenteConvenioNumero": "321"
*/

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CreateBankSlipResponseError {
        @JsonProperty("_status_http")
        private long httpStatus;

        @JsonProperty("_erro")
        private Error error;

        @JsonProperty("_dados")
        private CreateBankSlipRequest data;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Error {
        @JsonProperty("erroValidacao")
        private boolean validationError;

        @JsonProperty("erros")
        private Map<String, String> errorDescription;
    }
}

/*
    "_status_http": 400,
    "_erro": {
      "erroValidacao": true,
      "erros": {
        "boleto": "Boleto com Nosso Número 7 já existe para este convênio."
      }
    },
    "_dados": {
      "CedenteContaNumero": "54321",
      "CedenteContaNumeroDV": "0",
      "CedenteConvenioNumero": "321",
      "CedenteContaCodigoBanco": "341",
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
      "SacadoCelular": "44999999999",
      "TituloDataDesconto": "05/01/2020",
      "TituloValorDesconto": "0,01",
      "TituloDataEmissao": "01/01/2020",
      "TituloDataVencimento": "01/01/2020",
      "TituloValorJuros": "0,01",
      "TituloPrazoProtesto": "30",
      "TituloMensagem01": "Juros de 0,01 ao dia",
      "TituloMensagem02": "Nao receber apos 30 dias de atraso",
      "TituloMensagem03": "Titulo sujeito a protesto apos 30 dias",
      "TituloNossoNumero": "7",
      "TituloNumeroDocumento": "01012020",
      "TituloValor": "0,02",
      "TituloLocalPagamento": "Pagável em qualquer banco até o vencimento."
    }
  }
*/
