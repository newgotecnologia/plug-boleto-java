package br.com.skywalker.plugboleto.agreement;

import br.com.skywalker.plugboleto.agreement.dto.CreateAgreementRequest;
import br.com.skywalker.plugboleto.agreement.dto.CreateAgreementResponse;
import br.com.skywalker.plugboleto.common.Response;
import retrofit2.Call;
import retrofit2.http.*;

public interface AgreementService {
    @GET(Endpoints.BASE)
    Call<AgreementPagedResponse> findAll();

    @GET(Endpoints.BASE + "/{id}")
    Call<AgreementPagedResponse> findById(@Path("id") long id);

    @POST(Endpoints.BASE)
    Call<CreateAgreementResponse> create(@Body CreateAgreementRequest body, @Header("cnpj-cedente") String assignorFederalId);

    @PUT(Endpoints.BASE + "/{id}")
    Call<CreateAgreementResponse> update(@Body CreateAgreementRequest body, @Header("cnpj-cedente") String assignorFederalId, @Path("id") long id);

    @DELETE(Endpoints.BASE + "/{id}")
    Call<Response> delete(@Header("cnpj-cedente") String assignorFederalId, @Path("id") long id);
}
