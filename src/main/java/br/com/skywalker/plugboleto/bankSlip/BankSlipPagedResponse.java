package br.com.skywalker.plugboleto.bankSlip;

import br.com.skywalker.plugboleto.bankSlip.dto.SearchBankSlipResponse;
import br.com.skywalker.plugboleto.common.PagedResponse;

public class BankSlipPagedResponse extends PagedResponse<SearchBankSlipResponse> {
    public BankSlipPagedResponse(InternalBankSlipService bankSlipService) {
        super(bankSlipService::getPage);
    }
}
