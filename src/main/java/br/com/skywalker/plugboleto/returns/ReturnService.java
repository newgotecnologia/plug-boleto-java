package br.com.skywalker.plugboleto.returns;

import br.com.skywalker.plugboleto.bankSlip.dto.GenericProtocolResponse;
import br.com.skywalker.plugboleto.returns.dto.UploadReturnFileRequest;
import br.com.skywalker.plugboleto.returns.dto.UploadReturnFileStatusResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ReturnService {
    @POST(Endpoints.BASE)
    Call<GenericProtocolResponse> uploadReturnFile(@Body UploadReturnFileRequest body, @Header("cnpj-cedente") String assignorFederalId);

    @GET(Endpoints.BASE + "/{protocol}")
    Call<UploadReturnFileStatusResponse> uploadReturnFileStatus(@Path("protocol") String protocol, @Header("cnpj-cedente") String assignorFederalId);
}
