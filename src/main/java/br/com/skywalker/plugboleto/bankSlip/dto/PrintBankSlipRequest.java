package br.com.skywalker.plugboleto.bankSlip.dto;

import br.com.skywalker.plugboleto.common.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import retrofit2.Call;

import java.util.List;

@Getter
@Builder

public class PrintBankSlipRequest {
    @JsonProperty("TipoImpressao")
    private String impressionType;

    @JsonProperty("Boletos")
    private List<String> bankSlipIntegrationIds;
}