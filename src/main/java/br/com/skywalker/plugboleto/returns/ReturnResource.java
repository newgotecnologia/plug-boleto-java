package br.com.skywalker.plugboleto.returns;

import br.com.skywalker.plugboleto.Registry;
import br.com.skywalker.plugboleto.bankSlip.dto.GenericProtocolResponse;
import br.com.skywalker.plugboleto.common.Request;
import br.com.skywalker.plugboleto.returns.dto.UploadReturnFileRequest;
import br.com.skywalker.plugboleto.returns.dto.UploadReturnFileStatusResponse;
import retrofit2.Retrofit;

public class ReturnResource {
    public static final String ACCOUNT_SERVICE_KEY = "RETURN_SERVICE";

    public ReturnResource(Retrofit retrofit) {
        Registry.set(ACCOUNT_SERVICE_KEY, retrofit.create(ReturnService.class));
    }

    public Request<GenericProtocolResponse> uploadReturnFile(UploadReturnFileRequest request, String assignorFederalId) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, ReturnService.class).uploadReturnFile(request, assignorFederalId));
    }

    public Request<UploadReturnFileStatusResponse> uploadReturnFileStatus(String protocol, String assignorFederalId) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, ReturnService.class).uploadReturnFileStatus(protocol, assignorFederalId));
    }
}
