package br.com.skywalker.plugboleto.bankSlipEmail;

import br.com.skywalker.plugboleto.bankSlipEmail.dto.BankSlipEmailRequest;
import br.com.skywalker.plugboleto.bankSlipEmail.dto.BankSlipEmailResponse;
import br.com.skywalker.plugboleto.bankSlipEmail.dto.BankSlipEmailStatusResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface BankSlipEmailService {
    @POST(Endpoints.BASE + "/lote")
    Call<BankSlipEmailResponse> sendEmail(@Body BankSlipEmailRequest body, @Header("cnpj-cedente") String assignorFederalId);

    @GET(Endpoints.BASE + "/lote/{protocol}")
    Call<BankSlipEmailStatusResponse> sendEmailStatus(@Path("protocol") String protocol, @Header("cnpj-cedente") String assignorFederalId);
}
