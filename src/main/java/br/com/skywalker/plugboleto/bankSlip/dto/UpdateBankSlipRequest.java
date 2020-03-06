package br.com.skywalker.plugboleto.bankSlip.dto;

import br.com.skywalker.plugboleto.common.Request;
import br.com.skywalker.plugboleto.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import retrofit2.Call;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder

public class UpdateBankSlipRequest extends Request<UpdateBankSlipRequest> {
    @JsonProperty("Tipo")
    private String type;

    @JsonProperty("Boletos")
    private List<UpdateBankSlipBankSlipRequest> bankSlips;

    public UpdateBankSlipRequest(Call<UpdateBankSlipRequest> call) {
        super(call);
    }
}

@Getter
@Builder

class UpdateBankSlipBankSlipRequest {
    @JsonProperty("TituloDataVencimento")
    @JsonFormat(pattern = DateUtil.DATE_TECNOSPEED_PATTERN)
    private LocalDate titleExpirationDate;

    @JsonProperty("TituloValor")
    private String titleAmount;

    @JsonProperty("TituloValorAbatimento")
    private String titleSlaughterAmount;
}

/*
  "Tipo": "0",
  "Boletos": [
    {
      "IdIntegracao": "IdIntegracao1",
      "TituloDataVencimento": "20/06/2018"
    },
    {
      "IdIntegracao": "IdIntegracao2",
      "TituloDataVencimento": "20/06/2018"
    }
  ]
*/