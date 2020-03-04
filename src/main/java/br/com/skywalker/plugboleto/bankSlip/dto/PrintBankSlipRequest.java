package br.com.skywalker.plugboleto.bankSlip.dto;

import br.com.skywalker.plugboleto.common.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.Call;

import java.util.List;

public class PrintBankSlipRequest extends Request<PrintBankSlipRequest> {
    @JsonProperty("TipoImpressao")
    private String impressionType;

    @JsonProperty("Boletos")
    private List<String> bankSlipIntegrationIds;

    public PrintBankSlipRequest(Call<PrintBankSlipRequest> call) {
        super(call);
    }
}