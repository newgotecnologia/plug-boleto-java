package br.com.skywalker.plugboleto.account;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

interface InternalAccountService {
    @GET
    Call<AccountPagedResponse> getPage(@Url String url);
}
