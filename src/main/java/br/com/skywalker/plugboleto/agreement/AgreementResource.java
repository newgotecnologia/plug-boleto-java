package br.com.skywalker.plugboleto.agreement;

import br.com.skywalker.plugboleto.Registry;
import br.com.skywalker.plugboleto.agreement.dto.CreateAgreementRequest;
import br.com.skywalker.plugboleto.agreement.dto.CreateAgreementResponse;
import br.com.skywalker.plugboleto.common.Request;
import retrofit2.Retrofit;

public class AgreementResource {
    public static final String AGREEMENT_SERVICE_KEY = "AGREEMENT_SERVICE";

    public AgreementResource(Retrofit retrofit) {
        Registry.set(AGREEMENT_SERVICE_KEY, retrofit.create(AgreementService.class));
    }

    public Request<AgreementPagedResponse> findAll() {
        return new Request<>(Registry.get(AGREEMENT_SERVICE_KEY, AgreementService.class).findAll());
    }

    public Request<AgreementPagedResponse> findAll(long pageNum, long pageSize) {
        return new Request<>(Registry.get(AGREEMENT_SERVICE_KEY, AgreementService.class).findAll());
    }

    public Request<AgreementPagedResponse> findById(Long id) {
        return new Request<>(Registry.get(AGREEMENT_SERVICE_KEY, AgreementService.class).findById(id));
    }

    public Request<CreateAgreementResponse> create(CreateAgreementRequest request, String assignorFederalId) {
        return new Request<>(Registry.get(AGREEMENT_SERVICE_KEY, AgreementService.class).create(request, assignorFederalId));
    }

    public Request<CreateAgreementResponse> update(CreateAgreementRequest request, String assignorFederalId, long id) {
        return new Request<>(Registry.get(AGREEMENT_SERVICE_KEY, AgreementService.class).update(request, assignorFederalId, id));
    }

    public Request delete(String assignorFederalId, long id) {
        return new Request<>(Registry.get(AGREEMENT_SERVICE_KEY, AgreementService.class).delete(assignorFederalId, id));
    }
}
