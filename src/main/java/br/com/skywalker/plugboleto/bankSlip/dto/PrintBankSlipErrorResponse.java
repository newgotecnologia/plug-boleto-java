package br.com.skywalker.plugboleto.bankSlip.dto;

import br.com.skywalker.plugboleto.common.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrintBankSlipErrorResponse {
    @JsonProperty("_status")
    private ResponseStatus status;

    @JsonProperty("_mensagem")
    private String message;

    @JsonProperty("_dados")
    private Object data;
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