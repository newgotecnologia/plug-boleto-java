package br.com.skywalker.plugboleto.assignor;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

interface AssignorService {

    @GET(Endpoints.BASE)
    Call<AssignorPagedResponse> findAll();
    @POST("/")
    Call<AssignorPagedResponse> sendSomething(@Body Object a, @Header("X-Auth") String asd);

}
