package br.com.skywalker.plugboleto.bankSlip;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface InternalBankSlipService {
    @GET
    Call<BankSlipPagedResponse> getPage(@Url String url);
}
