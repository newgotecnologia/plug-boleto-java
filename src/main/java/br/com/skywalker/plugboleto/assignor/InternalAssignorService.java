package br.com.skywalker.plugboleto.assignor;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

interface InternalAssignorService {
    @GET
    Call<AssignorPagedResponse> getPage(@Url String url);
}
