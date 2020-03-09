package br.com.skywalker.plugboleto.account;

import br.com.skywalker.plugboleto.account.dto.CreateAccountRequest;
import br.com.skywalker.plugboleto.account.dto.CreateAccountResponse;
import br.com.skywalker.plugboleto.common.Response;
import retrofit2.Call;
import retrofit2.http.*;

public interface AccountService {
    @GET(Endpoints.BASE)
    Call<AccountPagedResponse> findAll();

    @GET(Endpoints.BASE + "/{id}")
    Call<AccountPagedResponse> findById(@Path("id") long id);

    @POST(Endpoints.BASE)
    Call<CreateAccountResponse> create(@Body CreateAccountRequest body, @Header("cnpj-cedente") String assignorFederalId);

    @PUT(Endpoints.BASE + "/{id}")
    Call<CreateAccountResponse> update(@Body CreateAccountRequest body, @Header("cnpj-cedente") String assignorFederalId, @Path("id") long id);

    @DELETE(Endpoints.BASE + "/{id}")
    Call<Response> delete(@Header("cnpj-cedente") String assignorFederalId, @Path("id") long id);
}
