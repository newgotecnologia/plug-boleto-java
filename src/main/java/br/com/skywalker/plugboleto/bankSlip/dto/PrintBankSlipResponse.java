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
@AllArgsConstructor
@NoArgsConstructor

public class PrintBankSlipResponse extends Response<PrintBankSlipResponse> {
    @JsonProperty("situacao")
    private String situation;

    @JsonProperty("protocolo")
    private String protocol;

    @JsonProperty("boletos")
    private List<String> bankSlipIntegrationIds;

    public PrintBankSlipResponse(ResponseStatus status, String message, PrintBankSlipResponse data) {
        super(status, message, data);
    }
}

/*
Success response example
{
  "_status": "sucesso",
  "_mensagem": "Impressão em processamento",
  "_dados": {
    "situacao": "PROCESSANDO",
    "protocolo": "S1xeMu5TbZ"
  }
}

Error response example
{
  "_status": "erro",
  "_mensagem": "Id(s) informado(s) não encontrado(s).",
  "_dados": [
    {
      "boletos": [
        "IdIntegracao1",
        "IdIntegracao2"
      ]
    }
  ]
}
*/