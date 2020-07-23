package br.com.skywalker.plugboleto.bankSlip;

import br.com.skywalker.plugboleto.bankSlip.dto.SearchBankSlipResponse;
import br.com.skywalker.plugboleto.common.PagedResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankSlipPagedResponse extends PagedResponse<SearchBankSlipResponse> {

    @JsonProperty("_dados")
    private List<SearchBankSlipResponse> data;

    public BankSlipPagedResponse(InternalBankSlipService bankSlipService) {
        super(bankSlipService::getPage);
    }
}
