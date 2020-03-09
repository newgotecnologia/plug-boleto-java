package br.com.skywalker.plugboleto.assignor;

import br.com.skywalker.plugboleto.assignor.dto.CreateAssignorRequest;
import br.com.skywalker.plugboleto.assignor.dto.CreateAssignorResponse;
import retrofit2.Call;
import retrofit2.http.*;

interface AssignorService {
    @GET(Endpoints.BASE)
    Call<AssignorPagedResponse> findAll();

    @GET(Endpoints.BASE + "/{id}")
    Call<AssignorPagedResponse> findById(@Path("id") long id);

    @POST(Endpoints.BASE)
    Call<CreateAssignorResponse> create(@Body CreateAssignorRequest body);

    @PUT(Endpoints.BASE + "/{id}")
    Call<CreateAssignorResponse> update(@Body CreateAssignorRequest body, @Header("cnpj-cedente") String assignorFederalId, @Path("id") long id);
}
