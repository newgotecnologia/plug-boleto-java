package br.com.skywalker.plugboleto.agreement;

import br.com.skywalker.plugboleto.agreement.dto.ListedAgreement;
import br.com.skywalker.plugboleto.common.PagedResponse;

public class AgreementPagedResponse extends PagedResponse<ListedAgreement> {
    public AgreementPagedResponse(InternalAgreementService agreementService) {
        super(agreementService::getPage);
    }
}
