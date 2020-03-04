package br.com.skywalker.plugboleto.bankSlipEmail;

import br.com.skywalker.plugboleto.Registry;
import br.com.skywalker.plugboleto.bankSlipEmail.dto.BankSlipEmailRequest;
import br.com.skywalker.plugboleto.bankSlipEmail.dto.BankSlipEmailResponse;
import br.com.skywalker.plugboleto.bankSlipEmail.dto.BankSlipEmailStatusResponse;
import br.com.skywalker.plugboleto.common.Request;
import retrofit2.Retrofit;

public class BankSlipEmailResource {
    public static final String ACCOUNT_SERVICE_KEY = "BANK_SLIP_EMAIL_SERVICE";

    public BankSlipEmailResource(Retrofit retrofit) {
        Registry.set(ACCOUNT_SERVICE_KEY, retrofit.create(BankSlipEmailService.class));
    }

    public Request<BankSlipEmailResponse> sendEmail(BankSlipEmailRequest request, String assignorFederalId) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, BankSlipEmailService.class).sendEmail(request, assignorFederalId));
    }

    public Request<BankSlipEmailStatusResponse> sendEmailStatus(String protocol, String assignorFederalId) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, BankSlipEmailService.class).sendEmailStatus(protocol, assignorFederalId));
    }
}
