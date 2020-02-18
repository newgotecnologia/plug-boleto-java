package br.com.skywalker.plugboleto.assignor;

import retrofit2.Call;
import retrofit2.http.GET;

interface AssignorService {

    @GET(Endpoints.BASE)
    Call<AssignorPagedResponse> findAll();

}
