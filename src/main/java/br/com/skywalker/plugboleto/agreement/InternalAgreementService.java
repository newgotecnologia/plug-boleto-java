package br.com.skywalker.plugboleto.agreement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

interface InternalAgreementService {
    @GET
    Call<AgreementPagedResponse> getPage(@Url String url);
}
