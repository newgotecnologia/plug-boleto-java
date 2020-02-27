package br.com.skywalker.plugboleto.bankSlip.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class CreateBankSlipResponseError {
    @JsonProperty("_status_http")
    private long httpStatus;

    @JsonProperty("_erro")
    private Error error;

    @JsonProperty("_dados")
    private CreateBankSlipRequest data;
}

class Error {
    @JsonProperty("erroValidacao")
    private boolean validationError;

    @JsonProperty("erros")
    private Map<String, String> errorDescription;
}
/*
"_falha": [
  {
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
]
*/